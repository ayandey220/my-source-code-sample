package edu.learn.poi;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
 * author: Noman ali abbasi
 */
public class ExcelWriter {
	public static void main(String[] args) {		
		try 
		{
			/*
			 * To create excel file for Office 2007
			 */
			String titles[] = {"Firstname","Lastname","Country","Language"};
			String data[][] = {{"noman ali","abbasi","PK","EN"},{"ahsan","shaikh","PK","EN"},
								{"abdul jalil","ahmed","PK","EN"},{"umair","khan","PK","EN"},
								{"abdul rahim","khan","PK","EN"}};
			int rowCount = 0;
			
			Workbook workbook = new XSSFWorkbook();
			Sheet sheet = workbook.createSheet("test");			
			Row row = sheet.createRow(rowCount++);
			
			CellStyle cellStyle = workbook.createCellStyle();
			Font font = workbook.createFont();
			font.setBoldweight(Font.BOLDWEIGHT_BOLD);
			
			cellStyle.setFont(font);
			
			for(int i = 0 ; i < titles.length ; i++){
				Cell cell = row.createCell(i);
				cell.setCellValue(titles[i]);
				cell.setCellStyle(cellStyle);
			}			
			
			
			/*
			 * Fill excel file 
			 */			 
			CellStyle style = workbook.createCellStyle();
			style.cloneStyleFrom(cellStyle);
			for(int i = 0 ; i < data.length ;i++){
				Row dataRow = sheet.createRow(rowCount++);
				Cell cell = dataRow.createCell(0);			
				cell.setCellStyle(style);
				
				cell.setCellValue(data[i][0]);
				
				cell = dataRow.createCell(1);
				cell.setCellValue(data[i][1]);
				
				cell = dataRow.createCell(2);
				cell.setCellValue(data[i][2]);
				
				cell = dataRow.createCell(3);
				cell.setCellValue(data[i][3]);
			}
			
			FileOutputStream outputStream = new FileOutputStream("C:\\temp\\test.xlsx");
			workbook.write(outputStream);
			outputStream.close();
			
			/*
			 * To create excel file for Office 2000
			 */
//			Workbook workbook = new HSSFWorkbook();
//			Sheet sheet = workbook.createSheet("test");	
//			
//			Row row = sheet.createRow(rowCount++);
//
//			CellStyle cellStyle = workbook.createCellStyle();
//			Font font = workbook.createFont();
//			font.setBoldweight(Font.BOLDWEIGHT_BOLD);
//			
//			cellStyle.setFont(font);
//			
//			for(int i = 0 ; i < titles.length ; i++){
//				Cell cell = row.createCell(i);
//				cell.setCellValue(titles[i]);
//				cell.setCellStyle(cellStyle);
//			}			
//			
//			
//			/*
//			 * Fill excel file 
//			 */			 
//			CellStyle style = workbook.createCellStyle();
//			style.cloneStyleFrom(cellStyle);
//			for(int i = 0 ; i < data.length ;i++){
//				Row dataRow = sheet.createRow(rowCount++);
//				Cell cell = dataRow.createCell(0);			
//				cell.setCellStyle(style);
//				
//				cell.setCellValue(data[i][0]);
//				
//				cell = dataRow.createCell(1);
//				cell.setCellValue(data[i][1]);
//				
//				cell = dataRow.createCell(2);
//				cell.setCellValue(data[i][2]);
//				
//				cell = dataRow.createCell(3);
//				cell.setCellValue(data[i][3]);
//			}
//			
//			FileOutputStream outputStream = new FileOutputStream("C:\\temp\\test.xls");
//			
//			workbook.write(outputStream);
//			outputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
