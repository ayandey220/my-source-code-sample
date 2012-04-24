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
			
			Workbook workbook_xlsx = new XSSFWorkbook();
			Sheet sheet = workbook_xlsx.createSheet("test");			
			Row row = sheet.createRow(rowCount++);
			
			CellStyle cellStyle = workbook_xlsx.createCellStyle();
			Font font = workbook_xlsx.createFont();
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
			CellStyle style = workbook_xlsx.createCellStyle();
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
			workbook_xlsx.write(outputStream);			
			outputStream.close();
			
			System.out.println("check C:/temp/ to created test.xlsx file");
			
			/*
			 * To create excel file for Office 2000
			 */
			Workbook workbook_xls = new HSSFWorkbook();
			sheet = workbook_xls.createSheet("test");	
			
			row = sheet.createRow(rowCount++);

			cellStyle = workbook_xls.createCellStyle();
			font = workbook_xls.createFont();
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
			style = workbook_xls.createCellStyle();
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
			
			outputStream = new FileOutputStream("C:\\temp\\test.xls");			
			workbook_xls.write(outputStream);
			outputStream.close();
			
			System.out.println("check C:/temp/ to created test.xls file");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
