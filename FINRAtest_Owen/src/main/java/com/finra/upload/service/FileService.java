package com.finra.upload.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.finra.upload.entity.FileInfo;

@Service
public class FileService implements FileServiceInterface {

	private File UPLOAD_FOLDER = new File("src/main/resources/uploadFile/");
	
	@Autowired
	FileInfoServiceInterface fileInfoService;
	
	@Override
	public String uploadFile(MultipartFile multipartFile, Integer id, long fileUploadTime) throws IOException {
		
		if (multipartFile == null || multipartFile.isEmpty()) {
			return "The File is Null or Empty";
		}
		
		String name = multipartFile.getOriginalFilename();
		long size = multipartFile.getSize();
		Date uploadTime = new Date(fileUploadTime);
		String author = "Owen";
		
		
		byte[] bytes = multipartFile.getBytes();
		String path = UPLOAD_FOLDER.getAbsolutePath() + File.separator + multipartFile.getOriginalFilename();
		Path uploadPath = Paths.get(path);
		Files.write(uploadPath, bytes);
		
		fileInfoService.addFile(id, name, size, uploadTime, path, author);
		
		return "Succeed to Upload File";
		
	}
	
	@Override
	public String downloadFile(Integer id, HttpServletResponse response, HttpServletRequest request) throws IOException {
		
		FileInfo fileInfo = fileInfoService.getFileInfoById(id);
		if (fileInfo != null) {
			String path = fileInfo.getPath();
			File downloadFile = new File(path);
			if (downloadFile.exists()) {
				InputStream inputStream = new FileInputStream(path);
				response.addHeader("Content-disposition", "attachment;file=" + fileInfo.getName());
				response.setContentType("application/octet-stream");	
				FileCopyUtils.copy(inputStream, response.getOutputStream());
				return "Succeed to DownloadFile";
			}
		}
		return "Fail to DownloadFile";
	}
}
