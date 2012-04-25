<%@page import="jxl.format.Colour"%>
<%@page import="jxl.CellFeatures"%>
<%@page import="jxl.write.WritableCellFeatures"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="jxl.write.Number"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jxl.write.Label"%>
<%@page import="java.io.IOException"%>
<%@page import="jxl.write.WriteException"%>
<%@page import="jxl.write.biff.RowsExceededException"%>
<%@page import="jxl.write.WritableCellFormat"%>
<%@page import="jxl.write.WritableFont"%>
<%@page import="jxl.write.WritableSheet"%>
<%@page import="jxl.Workbook"%>
<%@page import="java.io.File"%>
<%@page import="jxl.write.WritableWorkbook"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%
	WritableWorkbook workbook = null;
	
	String filePath = application.getRealPath("/excelFiles/ExportSalesHistory.xls");
	File file = null;
	try {
		File directory = new File(application.getRealPath("/excelFiles"));
		if(!directory.exists()){
			directory.mkdir();}
	
		file = new File(filePath);
		if(!file.exists()){
			file.createNewFile();
		}	
		
		workbook = Workbook.createWorkbook(file);
		WritableSheet sheet = workbook.createSheet("Sales History Sheet", 0);
		WritableFont font = new WritableFont(WritableFont.ARIAL,10,WritableFont.BOLD);		
		WritableCellFormat cellFormat = new WritableCellFormat(font);
		
		Label firstCol = new Label(0, 0, "First Column",cellFormat);
		Label secondCol = new Label(1, 0, "Second Column",cellFormat);
		Label thirdCol = new Label(2, 0, "Third Column",cellFormat);
		Label forthCol = new Label(3, 0, "Fourth Column",cellFormat); 
		Label fifthCol = new Label(4, 0, "Fifth Column",cellFormat);
		Label sixthCol = new Label(5, 0, "Sixth Column",cellFormat);
		Label seventhCol = new Label(6, 0, "Seventh Column",cellFormat);		
	
		sheet.addCell(firstCol);
		sheet.addCell(secondCol);
		sheet.addCell(thirdCol);
		sheet.addCell(forthCol);
		sheet.addCell(fifthCol);
		sheet.addCell(sixthCol);
		sheet.addCell(seventhCol);
	
		int row = 2;
		int startOffset = 0;
		
		String data[][] = {{"Noman ali","Abbasi","2001","2007","100","25"},{"ahsan","shaikh","2001","2007","100","85"},
						   {"abdul jalil","soomro","2001","2007","10066","7425"},{"talha","ahmed","2001","2007","100","95"},
						   {"mirza asif","baig","2008","2011","10000","1275"}};
		
		for(int i = 0 ; i < data.length ;i++){
			sheet.addCell(new Label(0, row, data[i][0]));
			sheet.addCell(new Label(1, row, data[i][1]));
			sheet.addCell(new Label(2, row, data[i][2]));
			sheet.addCell(new Label(3, row, data[i][3]));				
			sheet.addCell(new Number(4, row, new Integer(data[i][4])));
			sheet.addCell(new Number(5, row, new Integer(data[i][5])));
			
			Integer total = new Integer(data[i][4]) - new Integer(data[i][5]);
						
			WritableCellFeatures wcff=new WritableCellFeatures();
			
			wcff.setComment("This is sample comment",3,10);
			
			WritableCellFormat cellBGColor = new WritableCellFormat();
			cellBGColor.setBackground(Colour.YELLOW);
			
			Number number = new Number(6, row, total);
			number.setCellFeatures(wcff);	
			number.setCellFormat(cellBGColor);
			sheet.addCell(number);
			
			row++;
		}		
		
		workbook.write();	
		workbook.close();
	
	}catch (RowsExceededException e) {
		e.printStackTrace();
	} catch (WriteException e) {
		e.printStackTrace();
	}
	
	out.println("File created successfully ....");
%>


