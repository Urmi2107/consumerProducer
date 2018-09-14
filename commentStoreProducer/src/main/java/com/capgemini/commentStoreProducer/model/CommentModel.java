package com.capgemini.commentStoreProducer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
@Entity
@Table(name = "comments_model")
		
public class CommentModel {

		@Id
		   @Column(length = 36)
		   private String id;

		   @Version
		   private Integer version;
		
		   @Column(length = 32)
		   private String pageId;

		   @Column(length = 32)
		   private String username;

		   @Column(length = 32)
		   private String emailAddress;

		   @Column
		   private boolean spam;

		public CommentModel(String id, Integer version, String pageId,
				String username, String emailAddress, boolean spam) {
			super();
			this.id = id;
			this.version = version;
			this.pageId = pageId;
			this.username = username;
			this.emailAddress = emailAddress;
			this.spam = spam;
		}

		public CommentModel() {
			super();
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public Integer getVersion() {
			return version;
		}

		public void setVersion(Integer version) {
			this.version = version;
		}

		public String getPageId() {
			return pageId;
		}

		public void setPageId(String pageId) {
			this.pageId = pageId;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getEmailAddress() {
			return emailAddress;
		}

		public void setEmailAddress(String emailAddress) {
			this.emailAddress = emailAddress;
		}

		public boolean isSpam() {
			return spam;
		}

		public void setSpam(boolean spam) {
			this.spam = spam;
		}
		   

		

	}

