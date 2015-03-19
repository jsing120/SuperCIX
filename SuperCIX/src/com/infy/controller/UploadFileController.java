package com.infy.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.infy.forms.FileUploadForm;
import com.infy.parser.Parsersample;

@Controller
public class UploadFileController {

	@Autowired
	private Parsersample parserTool;
	@RequestMapping("/upload")
	public ModelAndView landingPage() {

		String message = "Please Select a File to Upload";
		System.out.println(message);
		return new ModelAndView("upload", "message", message);
	}

	@RequestMapping(value="/uploaded",method = RequestMethod.POST)
	public PrintWriter uploadeFile(@ModelAttribute("uploadForm") FileUploadForm uploadForm,HttpServletResponse response) {
		
	        
		String message = "File Successfully Uploaded";
		PrintWriter writer=null;
		ModelAndView modelView= new ModelAndView();
		if(uploadForm.getUploadedFile()==null)
		{
			message= "No File uploaded";
			System.out.println(message);
		}
		else{
			System.out.println(uploadForm.getUploadedFile());
		// writer= parserTool.cleanHtml(uploadForm.getUploadedFile());
			System.out.println(message);
			// do the parsing logic
		}
		modelView.setViewName("uploaded");
		modelView.addObject("message", message);
		modelView.addObject("file", writer);
		response.setContentType("text/html");
	    response.setHeader("Content-Disposition","attachment;filename=myFile.html");
	    
	    try {
	    ServletOutputStream out = response.getOutputStream();
	  
			out.println(parserTool.cleanHtml(uploadForm.getUploadedFile()));
		
	    out.flush();
	    out.close();
	    } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
