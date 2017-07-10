package com.finra.upload.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.finra.upload.entity.FileInfo;
import com.finra.upload.service.FileInfoServiceInterface;
import com.finra.upload.service.FileServiceInterface;

@RestController
public class FileController {

	@Autowired
	FileInfoServiceInterface fileInfoService;
	
	@Autowired
	FileServiceInterface fileService;
	
	@GetMapping(value="/getFileById/{id}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public FileInfo getFileInfoById(@PathVariable Integer id) {
		return fileInfoService.getFileInfoById(id);
	}
	
	@GetMapping(value="/getFileList")
	public List<FileInfo> getFileInfoList() {
		return fileInfoService.getFileInfoList();
	}
	
	@GetMapping(value="/getFileByName/{name}")
	public List<FileInfo> getFileInfoByName(@PathVariable String name) {
		return fileInfoService.getFileInfoByName(name);
	}
	
	@GetMapping(value="/getRecentFile")
	public List<FileInfo> getRecentFile() {
		return fileInfoService.getRecentFile();
	}
	
	@PostMapping(value="/uploadFile/{id}")
	public String uploadFile(@PathVariable("id") Integer id, @RequestParam("multipartFile") MultipartFile multipartFile) throws IOException {
		long fileUploadTime = System.currentTimeMillis();
		String string = fileService.uploadFile(multipartFile, id, fileUploadTime);
		return string;
	}
	
	@GetMapping(value="/downloadFile/{id}")
	public String downLoadFile(@PathVariable("id") Integer id, HttpServletResponse response, HttpServletRequest request) throws IOException {
		String string = fileService.downloadFile(id, response, request);
		return string;
	}
}
