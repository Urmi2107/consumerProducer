package com.copy.filemanagementcopy.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CopyController {
	
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
}
