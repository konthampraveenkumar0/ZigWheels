package com.zigwheels.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtils 
{
	
	public static String getFileDetails() throws IOException
	{
		FileInputStream file=new FileInputStream(ConfigReader.getTestDataFile());
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		XSSFRow row=sheet.getRow(1);
		String value=row.getCell(0).toString();
		workbook.close();
		file.close();
		return value;
	}
	
//	public static void writeResultToExcel(String result) throws IOException {
//	    FileInputStream file = new FileInputStream(ConfigReader.getTestDataFile());
//	    XSSFWorkbook workbook = new XSSFWorkbook(file);
//	    XSSFSheet sheet = workbook.getSheet("Sheet1");
//	    XSSFRow row = sheet.getRow(1);
//
//	    // Create a new cell to write the result ( at index 2)
//	    row.createCell(2).setCellValue(result);
//
//	    file.close(); // Close input stream before writing
//
//	    // Save changes
//	    FileOutputStream outFile = new FileOutputStream(ConfigReader.getTestDataFile());
//	    workbook.write(outFile);
//	    outFile.close();
//	    workbook.close();
//	}


}
