package Datadriven;

import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import basepage.Basetesting;

	
	public class Datareading extends Basetesting {
		
	        public static FileInputStream fis = null;
		    public static XSSFWorkbook workbook = null;
		    public static XSSFSheet sheet = null;
		    public static XSSFRow row = null;
		    public static XSSFCell cell = null;
		    public static int TotalNumberOfRows;
	 
		    public static String getCellData( String sheetName, String colName, int rowNum)
		    {
		        try
		        {
		        	fis = new FileInputStream("C:\\Users\\sathyamoorthy.p\\Eclipse Helios\\SAIFramework\\src\\Datadriven\\Controller.xlsx");
			        workbook = new XSSFWorkbook(fis);
		            int col_Num = -1;
		            sheet = workbook.getSheet(sheetName);
		            row = sheet.getRow(0);
		            for(int i = 0; i < row.getLastCellNum(); i++)
		            {
		                if(row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
		                col_Num = i;
		            }
		 
		            row = sheet.getRow(rowNum - 1);
		            cell = row.getCell(col_Num);
		 
		            if(cell.getCellType() == Cell.CELL_TYPE_STRING)
		            return cell.getStringCellValue();
		            
		            else if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC|| cell.getCellType() == Cell.CELL_TYPE_FORMULA)
		            {
		                String cellValue = String.valueOf(cell.getNumericCellValue());
		                if(HSSFDateUtil.isCellDateFormatted(cell))
		                {
		                    DateFormat df = new SimpleDateFormat("dd/MM/yy");
		                    Date date = cell.getDateCellValue();
		                    cellValue = df.format(date);
		                }
		             return cellValue;
		                }
		           
		            else if(cell.getCellType() == Cell.CELL_TYPE_BLANK)
		            return "";
		           
		            else
		            return String.valueOf(cell.getBooleanCellValue());
		       
		               }
		        catch(Exception e)
		        {
		            e.printStackTrace();
		            return "row "+rowNum+" or column "+colName +" does not exist  in Excel";
		        }
		    }
		    
		    
		    
		
		public static Object[][] getExcelData(String sheetname,int num) throws Exception
		{
		FileInputStream fis = new FileInputStream("C:\\Users\\sathyamoorthy.p\\Eclipse Helios\\SAIFramework\\src\\Datadriven\\Controller.xlsx");
		  
		XSSFWorkbook wb = new XSSFWorkbook(fis);
	    XSSFSheet sheet = wb.getSheet(sheetname);
	    
	     TotalNumberOfRows = (sheet.getLastRowNum()+1);
	    int TotalNumberOfCols =num;
	    
	    System.out.println("------------------"+TotalNumberOfRows);
	    System.out.println("Columnsssssssssss "+TotalNumberOfCols);
	    String[][] arrayExcelData = new String[TotalNumberOfRows-1][TotalNumberOfCols];
	    
	    for (int i = 1; i<TotalNumberOfRows; i++)
	    {
	        for (int j=0; j<TotalNumberOfCols; j++)
	        {
	          XSSFRow row = sheet.getRow(i);

	      //String cellData = row.getCell(j).toString();
	          arrayExcelData[i-1][j] = row.getCell(j).toString();
	       	       
	        }
	    }
	  
	    return arrayExcelData;
	    
	  }
		
	}
	
