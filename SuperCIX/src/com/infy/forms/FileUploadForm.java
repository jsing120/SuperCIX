package com.infy.forms;

import org.springframework.web.multipart.MultipartFile;
 
public class FileUploadForm {
 
    private MultipartFile uploadedFile;

	public MultipartFile getUploadedFile() {
		return uploadedFile;
	}

	public void setUploadedFile(MultipartFile uploadedFile) {
		this.uploadedFile = uploadedFile;
	}
 
   
}