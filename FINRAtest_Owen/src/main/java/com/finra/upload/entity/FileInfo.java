package com.finra.upload.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class FileInfo {

	@Id
	private Integer id;
	private String name;
	private Long size;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT-5")
	private Date date;
	private String path;
	private String author;
	
	public FileInfo() {
		super();
	}
	public FileInfo(Integer id, String name, Long size, Date date, String path, String author) {
		super();
		this.id = id;
		this.name = name;
		this.size = size;
		this.date = date;
		this.path = path;
		this.author = author;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getSize() {
		return size;
	}
	public void setSize(Long size) {
		this.size = size;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	@Override
	public String toString() {
		return "FileInfo: [id="+id
				+", name="+name
				+", size="+size+" Bytes"
				+", date="+date.toString()
				+", author"+author
				+"]";
	}
}
