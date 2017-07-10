package com.don.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.don.dao.FileInfoDao;
import com.don.model.FileInfo;

@Service
public class FileInfoService {
	@Autowired
	FileInfoDao fileDao;
	
	public void addFileInfo(FileInfo file) {
		fileDao.save(file);
	}
	
	public FileInfo getFileInfoById (Integer id) {
		return fileDao.findOne(id);
	}
	
	public List<FileInfo> getAllFileInfo() {
		List<FileInfo> list = new ArrayList<>();
		fileDao.findAll().forEach(list::add);
		return list;
	}

	public List<FileInfo> getLastHour() {
		List<FileInfo> list = new ArrayList<>();
		fileDao.getLastHour().forEach(list::add);
		return list;
	}
	
	public List<FileInfo> searchByName(String name) {
		List<FileInfo> list = new ArrayList<>();
		fileDao.searchByName(name).forEach(list::add);
		return list;
	}
	
}
