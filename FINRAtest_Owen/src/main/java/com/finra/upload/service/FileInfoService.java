package com.finra.upload.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finra.upload.dao.FileInfoDAO;
import com.finra.upload.entity.FileInfo;

@Service
public class FileInfoService implements FileInfoServiceInterface {

	@Autowired
	FileInfoDAO fileInfoDAO;
	
	@Override
	@Transactional
	public void addFile(Integer id, String name, Long size, Date date, String path, String author) {	
		FileInfo fileInfo = new FileInfo(id, name, size, date, path, author);	
		fileInfoDAO.save(fileInfo);	
	}
	
	@Override
	@Transactional
	public List<FileInfo> getFileInfoList() {
		List<FileInfo> list = new ArrayList<>();
		fileInfoDAO.findAll().forEach(list::add);
		return list;
	}
	
	@Override
	@Transactional
	public FileInfo getFileInfoById(Integer id) {
		return fileInfoDAO.findOne(id);
	}
	
	@Override
	@Transactional
	public List<FileInfo> getFileInfoByName(String name) {
		List<FileInfo> list = new ArrayList<>();
		fileInfoDAO.getFileInfoByName(name).forEach(list::add);
		return list;
	}
	
	@Override
	@Transactional
	public List<FileInfo> getRecentFile() {
		List<FileInfo> list = new ArrayList<>();
		fileInfoDAO.getRecentFile().forEach(list::add);
		return list;
	}
}
