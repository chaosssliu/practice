package com.don.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.don.model.FileInfo;
import com.don.service.FileInfoService;

@RestController
public class FileInfoController {
	
	@Autowired
	FileInfoService fileService;
	
	@RequestMapping("/file/{id}/info")
	public FileInfo getFileInfo(@PathVariable  Integer id) {
		return fileService.getFileInfoById(id);
	}
	
	@RequestMapping("/files/info")
	public List<FileInfo> getAllFileInfo() {
		return fileService.getAllFileInfo();
	}
	
	@RequestMapping("/files/name/{name}")
	public List<FileInfo> searchByName(@PathVariable String name) {
		return fileService.searchByName(name);
	}
	
}
