package com.capgemini.commentStoreProducer.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.commentStoreProducer.model.CommentModel;
import com.capgemini.commentStoreProducer.service.CommentModelRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class TestController {
	
	@Autowired
	CommentModelRepository commentModelRepository;
	@RequestMapping(value="/commentlist/{pageId}" ,method=RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "getDataFallBack")
    public List<CommentModel> getList(@PathVariable String pageId) {
		
		//if(emp1.getName().equalsIgnoreCase("emp1"))
			//throw new RuntimeException();
			/*try
			{

				return commentModelRepository.findByPageId(pageId);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return null;*/
		if( commentModelRepository.findByPageId(pageId).isEmpty())
		{
			System.out.println("error");
			throw new RuntimeException();
		}
		
		return commentModelRepository.findByPageId(pageId);

    }
public List<CommentModel> getDataFallBack(String pageId) {
		
	/*CommentModel c = new CommentModel();
		c.setId("default");
		c.setEmailAddress("default");
		c.setPageId("default");
		c.setSpam(false);
		c.setUsername("default");
		c.setVersion(0);
		List<CommentModel> list=new ArrayList<CommentModel>();
		list.add(c);
		System.out.println(list);*/
	CommentModel c = new CommentModel(null, null, pageId, null, null, false);
	List<CommentModel> l = new ArrayList<CommentModel>();
	l.add(c);
	return l;
		
	}

}
