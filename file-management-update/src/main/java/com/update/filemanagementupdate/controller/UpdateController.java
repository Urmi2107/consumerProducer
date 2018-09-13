package com.update.filemanagementupdate.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateController {
	@Value("${source-path}")
	private String sourcePath="";
	@Value("${destination-path}")
	private String destinationPath="";
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
