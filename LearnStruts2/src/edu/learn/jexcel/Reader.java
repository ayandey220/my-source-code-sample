package edu.learn.jexcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Comment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Reader {
	public static void main(String[] args) {
		System.out.println(ExcelFile("C:\\Temp\\ExportBalesProductionSaleHistory_1.xls"));
	}
	
	public static String ExcelFile(String filename){		
		Workbook workbook = null;
		
		if(filename.endsWith("xlsx")){
			try 
			{
				workbook = new XSSFWorkbook("C:\\Temp\\"+filename);
				System.out.println("2007");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else
		if(filename.endsWith("xls")){
			try {
				workbook = new HSSFWorkbook(new FileInputStream("C:\\Temp\\"+filename));
				System.out.println("1997-2003");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		return readExcelkContent(workbook);
	}
	
	
	public static String readExcelkContent(Workbook workbook){
		Workbook wb = workbook;		
		Sheet sheet = wb.getSheetAt(0);
		StringBuffer excelContent = new StringBuffer();
		excelContent.append("<table>");
		for(Row row : sheet){
			StringBuffer bufferRow = new StringBuffer();
			bufferRow.append("<tr>");
			for(Cell cell : row){		
				bufferRow.append("<td>" +cell+"</td>");				
			}
			bufferRow.append("</tr>");
			System.out.println(bufferRow.toString());
			excelContent.append(bufferRow.toString());
			
			bufferRow = new StringBuffer();			
		}
		
		return excelContent.toString()+"</table>";
	}
	
	/*
	 * Read excel file using j excel file
	 */
//	public static String ExcelFile(String path){
//		StringBuffer excelContent = new StringBuffer();
//		
//		try 
//		{		
//			Workbook workbook = Workbook.getWorkbook(new File(path));
//			Sheet sheet = workbook.getSheet(0);
//		
//			excelContent = new StringBuffer();
//			
//			for(int rows = 0 ; rows < sheet.getRows() ; rows++){
//				StringBuffer row = new StringBuffer();
//				for(int colums = 0 ; colums < sheet.getColumns() ;colums++){
//					Cell cell = sheet.getCell(colums, rows);
//					if(cell.getType() == CellType.LABEL){
//						row.append(cell.getContents());
//					}else
//					if(cell.getType() == CellType.NUMBER){
//						row.append(cell.getContents());
//					}
//				}
//				
//				excelContent.append(row.toString());				
//			}
//			
//		} catch (BiffException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		return excelContent.toString();
//	}
}
