package com.regalk.amazonviewer.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Report {
	private String content;
	private String nameFile;
	private String title;
	private String extension;
	
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getNameFile() {
		return nameFile;
	}
	public void setNameFile(String nameFile) {
		this.nameFile = nameFile;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getExtension() {
		return extension;
	}
	
	public void setExtension(String extension) {
		this.extension = extension;
	}
	
	public void makeReport() {
		if((getNameFile() != null) && (getTitle() != null) && (getContent() != null)) {
	
		try {
			File file = new File(getNameFile()+"."+getExtension());
			FileOutputStream fos;
			fos = new FileOutputStream(file);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			BufferedWriter bw = new BufferedWriter(osw);
			bw.write(getContent());
			bw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}else {
		System.out.println("Some args nulls");
		}

	}	
}
