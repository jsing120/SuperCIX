package com.infy.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.swing.text.html.parser.Element;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import net.htmlparser.jericho.Attribute;
import net.htmlparser.jericho.Attributes;
import net.htmlparser.jericho.OutputDocument;
import net.htmlparser.jericho.Source;
import net.htmlparser.jericho.StartTag;
import net.htmlparser.jericho.Tag;

@Component
public class Parsersample {
	
	private static final Object VALID_MARKER = null;
	
	String doctype="<!DOCTYPE html>";

	String Output="";
	
	public String cleanHtml(MultipartFile uploadedFile){
		  Source source = null;
		  StringBuilder builder1 = new StringBuilder();
		  InputStream inputStream = null;
		try {
			inputStream = uploadedFile.getInputStream();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		  BufferedReader is = new BufferedReader(new InputStreamReader(inputStream));
		
		 
		
		
		
		try {
			source = new Source(is);
			OutputDocument outputDocument = new OutputDocument(source);
			
			/*
			 * 
			 * COde for header piece
			 */
			List<net.htmlparser.jericho.Element> h0Elements = source.getAllElements("html");
			for (net.htmlparser.jericho.Element element : h0Elements) {
				
				StartTag startTag = element.getStartTag();
				
			
				outputDocument.replace(startTag,doctype);
				//System.out.println(outputDocument.toString());
				
			}
			
			
			List<net.htmlparser.jericho.Element> h1Elements = source.getAllElements("head");
		
			
			//System.out.println(h1Elements.get(0));
			builder1.append("<head>");
			Element headelElement;
			for (net.htmlparser.jericho.Element element : h1Elements) 
					{
					//System.out.println("Run loop");
				
				List<net.htmlparser.jericho.Element> childElements = element.getChildElements();
					for (net.htmlparser.jericho.Element childelement : childElements)
					{
						builder1.append(childelement);
					}
				
						
						
						String felement="<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js\"></script>";
						String selement="<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js\"></script>";
						String telement="<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css\">";
						String foelement="<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css\">";
						
						//System.out.println("This is Indra" + element.getName());
							
						
						builder1.append(felement).append(selement).append(telement).append(foelement);
						
						System.out.println("THis is Indra");
						
						
						
					}
			
			builder1.append("</head>");
			
			outputDocument.replace(h1Elements.get(0), builder1);
			
		  //System.out.println(outputDocument.toString());
			
			
			/*****
			 * 
			 * Working code for div tag
			 */
			List<net.htmlparser.jericho.Element> h2Elements = source.getAllElements("div");
			for (net.htmlparser.jericho.Element element : h2Elements) {
				
				StartTag startTag = element.getStartTag();
				
				Attributes attributes = startTag.getAttributes();

				Attribute idAttribute =  attributes.get("class");

				if (idAttribute == null)
				{
					String elementValue = element.getTextExtractor().toString();
					//String validAnchorId = AnchorUtils.getLowerCasedValidAnchorTitle(elementValue);
					StringBuilder builder = new StringBuilder();
					String idvalue="form-group";

					builder.append("<div").append(" ").append("class=\"").append(idvalue).append("\"");
					for (Attribute attribute : attributes)
					{
						builder.append(" ");
						builder.append(attribute);

						
					}
					builder.append(">");
					outputDocument.replace(startTag, builder);



				}
				
				
				
			}
			

			
			
			
			
			/*****
			 * 
			 * Working code for input tag
			 */
			
			List<net.htmlparser.jericho.Element> hinputElements = source.getAllElements("input");
			for (net.htmlparser.jericho.Element element : hinputElements) {
				
				StartTag startTag = element.getStartTag();
				
				Attributes attributes = startTag.getAttributes();

				Attribute classAttribute =  attributes.get("class");
				Attribute TypeAttribute =  attributes.get("type");
				Attribute valueAttribute = attributes.get("value");
				
				System.out.println(TypeAttribute.getValue());
				if (TypeAttribute.getValue().equalsIgnoreCase("text"))
				{
					String elementValue = element.getTextExtractor().toString();
					//String validAnchorId = AnchorUtils.getLowerCasedValidAnchorTitle(elementValue);
					StringBuilder builder = new StringBuilder();
					String idvalue="form-control";

					builder.append("<input").append(" ").append("class=\"").append(idvalue).append("\"");
					for (Attribute attribute : attributes)
					{
						builder.append(" ");
						builder.append(attribute);

						
					}
					builder.append(">");
					outputDocument.replace(startTag, builder);



				}
				
				else if (TypeAttribute.getValue().equalsIgnoreCase("submit")) {
					
					String elementValue = element.getTextExtractor().toString();
					//String validAnchorId = AnchorUtils.getLowerCasedValidAnchorTitle(elementValue);
					StringBuilder builder = new StringBuilder();
					String idvalue="btn btn-default";
					String type = "submit";
					String newVal="";

					builder.append("<button").append(" ").append("class=\"").append(idvalue).append("\"");
					for (Attribute attribute : attributes)
					{
						builder.append(" ");
						
						
						
						if(attribute.getName().equalsIgnoreCase("value")){
							
							builder.append("");
							newVal = attribute.getValue();
							
						}else{
						
						builder.append(attribute);
						
						}
						//System.out.println(attribute.getValue());
							
							

						
					}
					builder.append(">" + newVal + " " +"</button>");
					outputDocument.replace(startTag, builder);
					
					
				}
				
				
				
			}
			 PrintWriter writer = new PrintWriter("response.html", "UTF-8");
			  writer.println(outputDocument.toString());
			  
			  writer.close();
			System.out.println(outputDocument.toString());
			  System.out.println("Finished");

			
			//System.out.println(" This source of the text" + source.getTextExtractor().toString());
			//System.out.println(" This end of textt" );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		  //Create output file
		  try
		  {
			 
			
		  }
		  
		  catch (Exception e)
		  {
			  
		  }
		  
		  
		  
		  
		  source.fullSequentialParse();
		  
		  OutputDocument outputDocument=new OutputDocument(source);
		  
		  List<StartTag> tags=source.getAllStartTags();
		  
		  for (Iterator<StartTag> i=tags.iterator(); i.hasNext(); ) {
			  
		    Tag tag=i.next();
		    
		   //System.out.println(tag.getName());
		   if (tag.getName()=="head")
		   {
			   
		   }
		 
		  //Output=Output+(tag.getElement());
		    Output="";
		  

		  }
		return Output;
		  }
		  //Source formatSource=new Source(OutputDocument.toString());
		 // SourceFormatter formatter=new SourceFormatter(formatSource);
		  //formatter.setIndentString("    ");
		  //return formatter.toString();
		}

	


