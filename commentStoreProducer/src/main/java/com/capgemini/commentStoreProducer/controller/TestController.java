package com.capgemini.commentStoreProducer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.commentStoreProducer.model.CommentModel;
import com.capgemini.commentStoreProducer.service.CommentModelRepository;

@RestController
public class TestController {
	
	@Autowired
	CommentModelRepository commentModelRepository;
	@RequestMapping(value="/commentlist/{pageId}",method=RequestMethod.GET)
    public List<CommentModel> getList(@PathVariable String pageId) {

		return commentModelRepository.findByPageId(pageId);
    }

}
