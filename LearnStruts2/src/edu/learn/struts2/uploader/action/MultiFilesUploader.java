package edu.learn.struts2.uploader.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import edu.learn.jexcel.Reader;
import edu.learn.upload.virus.scanner.VirusScanner;

public class MultiFilesUploader extends ActionSupport {
	private static final long serialVersionUID = 1L;	
	private List<File> upload;
	private ArrayList<String> uploadFileName = new ArrayList<String>();
	private ArrayList<String> uploadContentType = new ArrayList<String>();
	private ArrayList<String> excelFileContent = new ArrayList<String>();
	private ArrayList<String> antivirusStatus = new ArrayList<String>();
		
	public String filesUploader(){
		if(upload != null){
			for(int i = 0 ; i < upload.size(); i++){
				String path = "";
				try 
				{
					path = "C:/Temp/"+uploadFileName.get(i);
					FileInputStream fileInputStream = new FileInputStream(upload.get(i));
					FileOutputStream fileOutputStream = new FileOutputStream(new File(path));				
					
					while(fileInputStream.available() != 0){
						byte[] data = new byte[(int)upload.get(i).length()];
						fileInputStream.read(data);
						fileOutputStream.write(data);
					}
					
					fileInputStream.close();
					fileOutputStream.close();				
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				antivirusStatus.add(VirusScanner.fileScanner(path));
			}		
			
			for(String f : uploadFileName){
				System.out.println(">>"+f);
				if(f.endsWith("xls") || f.endsWith("xlsx"))
					excelFileContent.add(Reader.ExcelFile(f));			
			}
			
			for(String c : uploadContentType){
				System.out.println(c);
			}
		}else{
			uploadFileName.add("No file found to upload");
		}
		
		System.out.println("getText>>" + getText("file.upload1") + ", " + getText("file.upload2"));
		return SUCCESS;
	}

	public List<File> getUpload() {
		return upload;
	}

	public void setUpload(List<File> upload) {
		this.upload = upload;
	}

	public ArrayList<String> getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(ArrayList<String> uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public ArrayList<String> getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(ArrayList<String> uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public ArrayList<String> getExcelFileContent() {
		return excelFileContent;
	}

	public void setExcelFileContent(ArrayList<String> excelFileContent) {
		this.excelFileContent = excelFileContent;
	}

	public ArrayList<String> getAntivirusStatus() {
		return antivirusStatus;
	}

	public void setAntivirusStatus(ArrayList<String> antivirusStatus) {
		this.antivirusStatus = antivirusStatus;
	}	
}
