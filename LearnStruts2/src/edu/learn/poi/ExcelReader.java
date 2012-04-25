package edu.learn.poi;

import java.io.IOException;

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
			Workbook workbook = new XSSFWorkbook("C:\\Temp\\test.xlsx");
			
			/*
			 * To read office 97-2003 files
			 */
			//Workbook workbook = new HSSFWorkbook(new FileInputStream("C:\\Temp\\test.xls"));
			Sheet sheet = workbook.getSheetAt(0);
							
			for(Row row : sheet){
				for(Cell cell : row){
					if(cell.getCellType() == Cell.CELL_TYPE_BLANK){						
						continue;
					}else
					if(cell.getCellType() == Cell.CELL_TYPE_STRING){
						continue;
					}else
					{
						System.out.print(cell + " ,");
					}
				}				
				System.out.println();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
