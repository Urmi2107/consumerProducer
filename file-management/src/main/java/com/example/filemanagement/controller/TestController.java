package com.example.filemanagement.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
public class TestController {
	@Value("${source-path}")
	private String sourcePath="";
	@Value("${destination-path}")
	private String destinationPath="";
		@RequestMapping(value="/copy" ,method=RequestMethod.GET)
		public void copyFile()
		{
			
			
			Path source = Paths.get(sourcePath+"first.txt");
			Path destination = Paths.get(destinationPath+"second.txt");
	 
			try {
				Files.copy(source, destination);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		@RequestMapping(value="/move" ,method=RequestMethod.GET)
		public void moveFile()
		{
			
			
			Path source = Paths.get(sourcePath+"first.txt");
			Path destination = Paths.get(destinationPath+"second.txt");
	 
			try {
				Files.move(source, destination);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		@RequestMapping(value="/delete" ,method=RequestMethod.GET)
		public void deleteFile()
		{
			
			
			Path source = Paths.get(sourcePath+"first.txt");
			//Path destination = Paths.get(destinationPath+"second.txt");
	 
			try {
				Files.delete(source);
			
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		@RequestMapping(value="/update" ,method = RequestMethod.GET)
		public void UpdateFile() throws IOException
		{
	 

	        //File fileToBeModified = new File("D:\\FileManagement1\\Hello.txt");
			File fileToBeModified = new File(sourcePath+"first.txt");
	        String oldContent = "";
	         
	        BufferedReader reader = null;
	         
	        FileWriter writer = null;
	         
	        try
	        {
	            /*reader = new BufferedReader(new FileReader(fileToBeModified));
	             
	            String line = reader.readLine();
	             
	            while (line != null) 
	            {
	                oldContent = oldContent + line + System.lineSeparator();
	                 
	                line = reader.readLine();
	            }*/
	             
	            //Replacing oldString with newString in the oldContent
	             
	            String newContent = "updated content";
	             
	            //Rewriting the input text file with newContent
	             
	            writer = new FileWriter(fileToBeModified);
	             
	            writer.write(newContent);
	        }
	        catch (IOException e)
	        {
	            e.printStackTrace();
	        }
	        finally
	        {
	            try
	            {
	                //Closing the resources
	                 
	                //reader.close();
	                 
	                writer.close();
	            } 
	            catch (IOException e) 
	            {
	                e.printStackTrace();
	            }
	        }
		}
}
