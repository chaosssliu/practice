package com.don.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.don.model.FileInfo;
import com.don.service.FileInfoService;


@RestController
public class FileUploadController {
	
	@Autowired
	FileInfoService fileService;

	@RequestMapping(value = "/file/{id}", method = RequestMethod.POST)
	public String uploadFileHandler(@PathVariable("id") Integer id, @RequestParam("file") MultipartFile file) {

		if (!file.isEmpty()) {
			try {
				// Store file to local disk
				File dir = new File("src/main/resources/files");
				String name = file.getOriginalFilename();
				byte[] bytes = file.getBytes();
				String path = dir.getAbsolutePath() + File.separator + name;
				File savedFile = new File(path);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(savedFile));
				stream.write(bytes);
				stream.close();
				
				// Store meta-data to database
				Long size = savedFile.length();
				Date date = new Date(savedFile.lastModified());
				fileService.addFileInfo(new FileInfo(id,name,size,date,path));
				
				return "Successfully uploaded file: " + name;

			} catch (Exception e) {
				return "Failed to upload file: => " + e.getMessage();
			}
		} else {
			return "Failed to upload file: => the file was empty.";
		}
	}

}