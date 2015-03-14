package com.infy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.infy.forms.FileUploadForm;

@Controller
public class UploadFileController {

	@RequestMapping("/upload")
	public ModelAndView landingPage() {

		String message = "Please Select a File to Upload";
		System.out.println(message);
		return new ModelAndView("upload", "message", message);
	}

	@RequestMapping(value="/uploaded",method = RequestMethod.POST)
	public ModelAndView uploadeFile(@ModelAttribute("uploadForm") FileUploadForm uploadForm) {
		String message = "File Successfully Uploaded";
		if(uploadForm.getUploadedFile()==null)
		{
			message= "No File uploaded";
			System.out.println(message);
		}
		else{
			System.out.println(message);
			// do the parsing logic
		}
		return new ModelAndView("uploaded", "message", message);
	}
}
