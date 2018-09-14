package com.capgemini.commentStoreProducer.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.commentStoreProducer.model.CommentModel;

public interface CommentModelRepository extends CrudRepository<CommentModel,String>{
//@Query("select a from CommentModel a where a.pageId=?1")	
List<CommentModel> findByPageId(String pageId);
List<CommentModel> findByPageIdAndSpamIsTrue(String pageId);

}
