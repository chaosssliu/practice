/**
 * 
 */
package com.steven.springboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Steven
 * @Date Mar 24, 2017 
 * @Desc: 
 */
@Entity
@Table(name="FielMetaDataTable")
public class FileMetaData {

	@Id
	@Column(name="fileId",unique=true)
	private int fileId;
	@Column(name="fileName")
	private String fileName;
	@Column(name="fileExtension")
	private String fileExtension;
	@Column(name="fileSize")
	private long fileSize;
	@Column(name="fileAuthor")
	private String fileAuthor;
	@Column(name="fileUploadTime")
	private long fileUploadTime;
	
	
	public FileMetaData() {}

	/**
	 * @param fileId
	 * @param fileName
	 * @param fileExtension
	 * @param fileSize
	 * @param fileAuthor
	 */
	public FileMetaData(int fileId, String fileName, String fileExtension, long fileSize, String fileAuthor, long fileUploadTime) {
		this.fileId = fileId;
		this.fileName = fileName;
		this.fileExtension = fileExtension;
		this.fileSize = fileSize;
		this.fileAuthor = fileAuthor;
		this.fileUploadTime = fileUploadTime;
	}
	
	public int getFileId() {
		return fileId;
	}
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileExtension() {
		return fileExtension;
	}
	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}
	public long getFileSize() {
		return fileSize;
	}
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
	public String getFileAuthor() {
		return fileAuthor;
	}
	public void setFileAuthor(String fileAuthor) {
		this.fileAuthor = fileAuthor;
	}
	public long getFileUploadTime() {
		return fileUploadTime;
	}
	public void setFileUploadTime(long fileUploadTime) {
		this.fileUploadTime = fileUploadTime;
	}
	
}
