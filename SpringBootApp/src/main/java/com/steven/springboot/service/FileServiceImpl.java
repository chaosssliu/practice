/**
 * 
 */
package com.steven.springboot.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.steven.utility.FileUtility;

/**
 * @author Steven
 * @Date Mar 24, 2017 
 * @Desc: 
 */
@Service
public class FileServiceImpl implements FileService {
	
	@Autowired
	FileMetaDataService fileMetaDataService;
	
	/**
	 * Save the multipart file
	 * @param fileToUpload
	 * @return
	 * @throws IOException
	 */
	@Override
	public String saveFile(MultipartFile fileToUpload, long fileUploadTime) throws IOException {
		
		if(fileToUpload == null || fileToUpload.isEmpty()) {
			return "The file is null or empty!";
		}
		
		// get meta data from multipart file
		int fileId = FileUtility.fileMap.size() + 1;
		String fileName = fileToUpload.getOriginalFilename();
		String fileExtension = fileToUpload.getContentType();
		long fileSize = fileToUpload.getSize();
		String fileAuthor = "Steven";
				
		// Save the file to the file system
		byte[] bytes = fileToUpload.getBytes();
		Path uploadPath = Paths.get(FileUtility.downloadFileDir + fileToUpload.getOriginalFilename());
		Files.write(uploadPath, bytes);
		FileUtility.fileMap.put(fileId, fileName);
		FileUtility.fileMapStringKey.put(fileName, fileId);
		
		// save meta data
		fileMetaDataService.saveMetaData(fileId, fileName, fileExtension, fileSize, fileAuthor, fileUploadTime);
		
		return "File Upload Success!";
	}
	
	@Override
	public HashMap<Integer,String> getFileList() {
		return FileUtility.fileMap;
	}
	
	@Override
	public String searchFileById(int fileId) {
		if(FileUtility.fileMap.containsKey(fileId)) {
			return FileUtility.fileMap.get(fileId);
		}
		return null;
	}
	
	@Override
	public List<Integer> searchFileByExtension(String fileExt) {
		List<Integer> fileIdList = new ArrayList<Integer>();
		for(String key : FileUtility.fileMapStringKey.keySet()) {
			if(key.matches(".*\\." + fileExt)) {
				fileIdList.add(FileUtility.fileMapStringKey.get(key));
			}
		}
		return fileIdList;
	}
	
	@Override
	public List<Integer> searchFileByPartialName(String fileName) {
		List<Integer> fileIdList = new ArrayList<Integer>();
		for(String key : FileUtility.fileMapStringKey.keySet()) {
			if(key.matches(".*" + fileName + ".*")) {
				fileIdList.add(FileUtility.fileMapStringKey.get(key));
			}
		}
		return fileIdList;
	}
	
	@Override
	public Integer searchFileByFullNameWithExtension(String fileName, String fileExt) {
		String key = fileName + "." + fileExt;
		if(FileUtility.fileMapStringKey.containsKey(key)) {
			Integer id = FileUtility.fileMapStringKey.get(key);
			return id;
		}
		return null;
	}
	
	@Override
	public void downLoadFileById(int fileId, HttpServletResponse response, HttpServletRequest request) throws IOException {
		if(FileUtility.fileMap.containsKey(fileId)) {
			
			// get file location
			String fileLocation = FileUtility.downloadFileDir+FileUtility.fileMap.get(fileId);
			// open the file and put into output stream
			File fileToDownload = new File(fileLocation);
			FileInputStream fileInput = new FileInputStream(fileToDownload);
			
			// get MIME type
			String mimeType = request.getServletContext().getMimeType(fileLocation);
	        if (mimeType == null) {
	            // set to binary type if MIME mapping not found
	            mimeType = "application/octet-stream";
	        }
	        
	        // set file MIME type
			response.setContentType(mimeType);
			response.setContentLengthLong(fileToDownload.length());
			// set the response output stream to the file output stream
			OutputStream fileOutput = response.getOutputStream();

			byte[] buffer = new byte[4096];
			int bytesRead = -1;

			// write bytes read from the input stream into the output stream
			while ((bytesRead = fileInput.read(buffer)) != -1) {
				fileOutput.write(buffer, 0, bytesRead);
			}

			// close streams
			fileInput.close();
			fileOutput.close();	
		}
	}
	
	@Override
	public void downLoadFileByName(String fileName, HttpServletResponse response, HttpServletRequest request) throws IOException {
		if(FileUtility.fileMapStringKey.containsKey(fileName)) {
			this.downLoadFileById(FileUtility.fileMapStringKey.get(fileName), response, request);
		}
	}	
	
	@Override
	public void getRecentUploadFiles() {
		
	}
	
	@Override
	public void sendEmail() {
//		JavaMailSenderImpl sender = new JavaMailSenderImpl();
//		sender.setHost("smtp.gmail.com");
//		MimeMessage message = sender.createMimeMessage();
//		
//		// use the true flag to indicate you need a multipart message
//		MimeMessageHelper helper = new MimeMessageHelper(message, true);
//		helper.setTo("wymice@gmail.com");
//
//		// use the true flag to indicate the text included is HTML
//		helper.setText("Test Send Email", true);
//
//		sender.send(message);
		
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo("smtp.gmail.com");
		msg.setText("Test Send Email");
		
		MailSender mailSender = new JavaMailSenderImpl();
		mailSender.send(msg);
		
	}


}
