package com.comcast.crm.FileUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	public String getDataFromExcelUtility(String sheetName, int rowNum, int colNum) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis= new FileInputStream("./Utility_Files/Testdata6.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(colNum);
		String value = cell.getStringCellValue();
		wb.close();
		fis.close();
		return value;
	}
	public int getLastRowCount(String sheetName) throws EncryptedDocumentException, IOException 
	{
		
		FileInputStream fis= new FileInputStream("./Utility_Files/Testdata6.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		int lastRowNum = sheet.getLastRowNum();  
		wb.close();
		fis.close();
		return lastRowNum;
	}
	public void writeDataToExcel(String sheetName, String price, int i) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis= new FileInputStream("./Utility_Files/Testdata6.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		//int lastRowNum=sh.getLastRowNum();
		Row rw=sh.getRow(i);
		rw.createCell(2).setCellValue(price);
		
		
		
		FileOutputStream fos= new FileOutputStream("./Utility_Files/Testdata6.xlsx");
		wb.write(fos);
		wb.close();
		fis.close();
		fos.close();
		
	}
	
			
//	 private int getRowNumberForInput(String productName) throws IOException {
//	        // This is a simplified example. In a real scenario, you might need
//	        // a more robust way to map the processed data back to its original row.
//	        // For instance, if 'input' is a unique identifier, you can find its row.
//	        FileInputStream fis = new FileInputStream("path/to/your/data.xlsx");
//	        Workbook wb = WorkbookFactory.create(fis);
//	        Sheet sheet = wb.getSheet("Sheet1");
//
//	        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
//	            Row row = sheet.getRow(i);
//	            if (row != null && row.getCell(1) != null && row.getCell(1).getStringCellValue().equals(productName))
//	            {
//	                wb.close();
//	                fis.close();
//	                return i;
//	            }
//	        }
//	        wb.close();
//	        fis.close();
//			int i;
//			return  -i;
//	 }
	

}
