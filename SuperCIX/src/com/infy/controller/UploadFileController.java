package com.infy.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.infy.bean.TableBean;
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

	/*@RequestMapping(value="/uploaded",method = RequestMethod.POST)
	public String uploadeFile(@ModelAttribute("uploadForm") FileUploadForm uploadForm,HttpServletResponse response) {
		
	        
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
	*/
	@RequestMapping(value="/preview",method = RequestMethod.POST)
	public ModelAndView previewFileAjax(@ModelAttribute("uploadForm") FileUploadForm uploadForm,HttpServletResponse response) throws IOException {
		
	        
		String message = "File Successfully Uploaded";
		
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
		
		modelView.addObject("message", FileUtils.readFileToString(multipartToFile(uploadForm.getUploadedFile())));
		
		
		return modelView ;
	}
	
	@RequestMapping(value="/uploaded",method = RequestMethod.POST)
	public ModelAndView uploadeFileAjax(@ModelAttribute("uploadForm") FileUploadForm uploadForm,HttpServletResponse response) {
		
	        
		String message = "File Successfully Uploaded";
		
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
		System.out.println("MAAADARCHOOOOODsaaaaaaaaaaa");
		System.out.println("kussssssssssssssssssssssssssssssssssssssaaaaaaaaaaa"+parserTool.cleanHtml(uploadForm.getUploadedFile()));
		modelView.addObject("message", parserTool.cleanHtml(uploadForm.getUploadedFile()));
		
		
		return modelView ;
	}
	@RequestMapping(value="/getTable",method = RequestMethod.POST)
	public ModelAndView getTable(@ModelAttribute("uploadForm") FileUploadForm uploadForm,HttpServletResponse response) {
		
	        
		String message = "File Successfully Uploaded";
		
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
		modelView.setViewName("table");
		System.out.println("MAAADARCHOOOOODsaaaaaaaaaaa");
		//System.out.println("kussssssssssssssssssssssssssssssssssssssaaaaaaaaaaa"+parserTool.cleanHtml(uploadForm.getUploadedFile()));
		List<TableBean> lst = new ArrayList<TableBean>();
		TableBean tb1 =new TableBean();
		tb1.setTagName("form");
		tb1.setCanBeConverted(true);
		TableBean tb2 =new TableBean();
		tb2.setTagName("input");
		tb2.setCanBeConverted(true);
		TableBean tb3 =new TableBean();
		tb3.setTagName("img");
		tb3.setCanBeConverted(true);
		tb3.setTagName("div");
		tb3.setCanBeConverted(false);
		
		tb3.setTagName("a");
		tb3.setCanBeConverted(true);
		
		tb3.setTagName("img");
		tb3.setCanBeConverted(true);
		
		tb3.setTagName("img");
		tb3.setCanBeConverted(true);
		
		
		lst.add(tb1);
		lst.add(tb2);
		lst.add(tb3);
		modelView.addObject("message", lst);
		
		System.err.println("LUNN"+lst.size());
		return modelView ;
	}
	public File multipartToFile(MultipartFile multipart) throws IllegalStateException, IOException 
	{
	        File convFile = new File( multipart.getOriginalFilename());
	        multipart.transferTo(convFile);
	        return convFile;
	}
}
