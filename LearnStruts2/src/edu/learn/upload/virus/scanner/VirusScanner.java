package edu.learn.upload.virus.scanner;

import java.io.IOException;
import java.util.Scanner;

public class VirusScanner {
	public static String fileScanner(String path) {
		String fileStatus = "";
		try 
		{
			Process process = Runtime.getRuntime().exec("C:/Progra~1/ClamWin/bin/clamscan.exe " + path + " --no-summary --remove=yes");
			Scanner scanner = new Scanner(process.getInputStream());
			while(scanner.hasNextLine()){
				String status = scanner.nextLine();
				if((status.lastIndexOf(":",1)) != -1){					
					fileStatus += status.substring(status.lastIndexOf(":") + 1);
					System.out.println("Filename: " + status.substring(0, status.lastIndexOf(":")) + "\nStatus: " + status.substring(status.lastIndexOf(":") + 1));
				}
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		if(fileStatus.trim().toLowerCase().equals("ok")){
			return  "OK";
		}else{
			return fileStatus.trim().toLowerCase();
		}
	}
	
	public static void main(String[] args) {
		System.out.println(fileScanner("C:/temp/add_state_reuse.txt"));
	}
}
