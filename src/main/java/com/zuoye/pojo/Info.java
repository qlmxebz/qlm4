package com.zuoye.pojo;

import java.util.Date;

public class Info {
	private Integer id;
	private String title;
	private Date date;
	private String content;
	public  Info(){

	}

	public Info(Integer id, String title, Date date, String content) {
		this.id = id;
		this.title = title;
		this.date = date;
		this.content = content;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
