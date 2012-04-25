package edu.learn.struts2.generic;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLConnection;

import javax.activation.FileTypeMap;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

public class GenericAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private static final String RESULT_RAW = "raw";
	private InputStream inputStream;
	private String contentType;
	private String contentDisposition;
	
	public String sendFile(){
		File file = null;
		String mimeType = "";
		
		try {			
			//file = new File("C:/downloads/asm.pdf");			
			//file = new File("C:/RHDSetup.log");
			file = new File("C:/downloads/Exports.xls");
			System.out.println("filePath: " + file.getAbsolutePath());
			inputStream = new FileInputStream(file);
			mimeType = URLConnection.guessContentTypeFromStream(inputStream);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		FileTypeMap type = FileTypeMap.getDefaultFileTypeMap();		
		
		System.out.println("MIMETYPE: " + mimeType + ", " + type.getContentType(file));
		//setContentType("text/plain");		
		
		//setContentType("application/pdf");
		setContentType(type.getContentType(file));
		setContentDisposition("attachment; filename="+file.getName());
		
		return RESULT_RAW;
	}
		
	public String sendRaw(String message){
		try 
		{
			inputStream = new ByteArrayInputStream(message.getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		setContentType("text/plain");
		setContentDisposition("inline");
		
		return RESULT_RAW;
	}
	
	public String sendJSON(Object obj){
		String json = new Gson().toJson(obj);		
		return sendRaw(json);
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getContentDisposition() {
		return contentDisposition;
	}

	public void setContentDisposition(String contentDisposition) {
		this.contentDisposition = contentDisposition;
	}	
	
	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
}
