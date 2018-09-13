package com.move.filemanagementmove.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class MoveController {
	@Value("${source-path}")
	private String sourcePath="";
	@Value("${destination-path}")
	private String destinationPath="";
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

}
