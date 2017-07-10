package com.finra.upload.service;

import java.util.Date;
import java.util.List;

import com.finra.upload.entity.FileInfo;

public interface FileInfoServiceInterface {

	void addFile(Integer id, String name, Long size, Date date, String path, String author);

	List<FileInfo> getFileInfoList();

	FileInfo getFileInfoById(Integer id);

	List<FileInfo> getFileInfoByName(String name);

	List<FileInfo> getRecentFile();

}