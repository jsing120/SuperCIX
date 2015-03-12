package com.infy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UploadFileController {

	@RequestMapping("/upload")
	public ModelAndView helloWorld() {

		String message = "Hello World, Spring 3.0!";
		System.out.println(message);
		return new ModelAndView("upload", "message", message);
	}

}
