/**
 * 
 */
package com.steven.springboot.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.steven.springboot.entity.FileMetaData;
import com.steven.springboot.service.FileMetaDataService;
import com.steven.springboot.service.FileService;

/**
 * @author yumingwei
 * @Date Mar 23, 2017 
 * @Desc: 
 */
@RestController
public class FileController {
	
	@Autowired
	FileService fileService;
	
	@Autowired
	FileMetaDataService fileMetaDataService;
	
	@PostMapping("/upload")
	public String fileUpload(@RequestParam("fileToUpload") MultipartFile fileToUpload) throws IOException {	
		long fileUploadTime = System.currentTimeMillis();
		String str = fileService.saveFile(fileToUpload, fileUploadTime);
		return str;
	}
	
	@GetMapping(value="/searchFileByFullNameWithExtension/{fileName}.{fileExt}")
	public String searchFileByFullNameWithExtension(@PathVariable("fileName") String fileName, @PathVariable("fileExt") String fileExt) {
		return "File ID: " + fileService.searchFileByFullNameWithExtension(fileName, fileExt).toString();
	}
	
	@GetMapping(value="/searchFileByPartialName/{fileName}")
	public List<Integer> searchFileByPartialName(@PathVariable("fileName") String fileName) {
		return fileService.searchFileByPartialName(fileName);
	}
	
	@GetMapping(value="/searchFileByExtension/{fileExt}")
	public List<Integer> searchFileByExtension(@PathVariable("fileExt") String fileExt) {
		return fileService.searchFileByExtension(fileExt);
	}
	
	@GetMapping(value="/searchFileById/{fileId}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String searchFileById(@PathVariable("fileId") int fileId) {
		return fileService.searchFileById(fileId);
	}
	
	@GetMapping(value="/getMetaDataByName/{fileName}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public FileMetaData getMetaDataByName(@PathVariable("fileName") String fileName) {
		return fileMetaDataService.getEMeaDataByName(fileName);
	}
	
	@GetMapping(value="/getMetaDataById/{fileId}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public FileMetaData getMetaDataById(@PathVariable("fileId") int fileId) {
		return fileMetaDataService.getEMeaDataById(fileId);
	}
	
	@GetMapping(value="/getMetaDataList")
	public List<FileMetaData> getMetaDataList() {
		return fileMetaDataService.getAllMetaData();
	}
	
	@RequestMapping(value="/downloadFilebyId/{fileId}")
	public String downloadFilebyId(@PathVariable("fileId") int fileId) {
		return null;
	}
	
	@RequestMapping(value="/downloadFilebyName/{fileName}")
	public void downloadFilebyName(@PathVariable("fileName") String fileName, HttpServletResponse response, 
			HttpServletRequest request) throws IOException {
		fileService.downLoadFileByName(fileName, response, request);
	}
	
	@GetMapping(value="/downloadFileById/{fileId}")
	public void downloadFileById(@PathVariable("fileId") int fileId, HttpServletResponse response, 
			HttpServletRequest request) throws IOException {
		fileService.downLoadFileById(fileId, response, request);
	}
	
	@GetMapping(value="/getFileList",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public HashMap<Integer,String> getFileList() {
		return fileService.getFileList();
	}

	@GetMapping(value="/getRecentUploadFiles")
	public void getRecentUploadFiles() {
		fileService.sendEmail();
	}
}
