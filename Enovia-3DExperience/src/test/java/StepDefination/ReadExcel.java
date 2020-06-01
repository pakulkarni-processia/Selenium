package StepDefination;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFCreationHelper;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ReadExcel {
	
	public String[] array;
	public File file;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	

	 
	public java.lang.String[] ReadExcel(String worksheet, String data) throws IOException
	{
		File file = new File("src/test/resources/Repository.xlsx");
		
		FileInputStream inputfile = new FileInputStream(file);
		
		XSSFWorkbook workbook=new XSSFWorkbook(inputfile);
		
		XSSFSheet sheet= workbook.getSheet(worksheet);
		
	 
	 int rowcount = sheet.getLastRowNum();
	
	outer:  for (int i = 0; i <= rowcount; i++) 
     {
       // get the total cell count in the excel sheet
              int cellcount = sheet.getRow(i).getLastCellNum();
                 for (int j = 0; j < cellcount; j++) 
           {                         
               //get cell value at the given position [i][j]
                   String value = sheet.getRow(i).getCell(j).getStringCellValue();
               //print the cell value
	                    System.out.println(value);
	                 if (data.equals(value))
	                    {
	                    	int rows = i;
	                    	System.out.println(rows);
	                    	array = new String[cellcount];
							for (int k=0; k < cellcount; k++)
							{
								String forvalue = sheet.getRow(rows).getCell(k).getStringCellValue();
							array [k] = forvalue;
								
							}
							
							break outer;
                  }			
           }	
	
	}
	return array;
	 
	 
}
	
	public 	String[]  credentials(String worksheet, String data)
	{
		String [] array1 = null;
		try 
		{
			array1 = ReadExcel(worksheet, data);
					System.out.println("Credentials"+array1);
					
		} 
		
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return array1;
		
		
	}
	
	public void writeexcel(String worksheet,String data, int row) throws IOException
	{
		File file = new File("src/test/resources/Repository.xlsx");
		
		FileInputStream inputfile = new FileInputStream(file);
		
		XSSFWorkbook workbook=new XSSFWorkbook(inputfile);
		
		XSSFSheet sheet= workbook.getSheet(worksheet);
		 
		 sheet.createRow(row).createCell(1).setCellValue(data);
		 FileOutputStream fos = new FileOutputStream(file);
		 workbook.write(fos);
		 fos.close();
		 System.out.println("Part wite to excel completed");
	}
	
	public 	String[]  readpartnumber(String worksheet, String data)
	{
		String [] array1 = null;
		try 
		{
			array1 = ReadExcel(worksheet, data);
					System.out.println("Partno"+array1);
					
		} 
		
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return array1;
		
		
	}
}

