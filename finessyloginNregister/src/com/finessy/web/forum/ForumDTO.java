package com.finessy.web.forum;

public class ForumDTO {

	private int questionId;
	private int groupId;
	private int postBy;
	private String tags;
	private String description;
	private String postOn;
	
	public ForumDTO(int questionId, int groupId, int postBy, String tags, String description, String postOn) {
		this.questionId = questionId;
		this.groupId = groupId;
		this.postBy = postBy;
		this.tags = tags;
		this.description = description;
		this.postOn = postOn;
	}

	@Override
	public String toString() {
		return "ForumDTO [questionId=" + questionId + ", groupId=" + groupId + ", postBy=" + postBy + ", tags=" + tags
				+ ", description=" + description + ", postOn=" + postOn + "]";
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public int getPostBy() {
		return postBy;
	}

	public void setPostBy(int postBy) {
		this.postBy = postBy;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPostOn() {
		return postOn;
	}

	public void setPostOn(String postOn) {
		this.postOn = postOn;
	}
	
		
}
