package edu.learn.poi;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	public static void main(String[] args) {
		try 
		{
			/*
			 * To read office 2007 files
			 */
			Workbook workbook_xlsx = new XSSFWorkbook("C:\\Temp\\test.xlsx");
			Sheet sheet = workbook_xlsx.getSheetAt(0);
			
			for(Row row : sheet){
				for(Cell cell : row){
					System.out.print(cell + ",");
				}				
				System.out.println();
			}
			
			/*
			 * To read office 97-2003 files
			 */
			Workbook workbook_xls = new HSSFWorkbook(new FileInputStream("C:\\Temp\\test.xls"));
			sheet = workbook_xls.getSheetAt(0);
							
			for(Row row : sheet){
				for(Cell cell : row){
					System.out.print(cell + ",");
				}				
				System.out.println();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
