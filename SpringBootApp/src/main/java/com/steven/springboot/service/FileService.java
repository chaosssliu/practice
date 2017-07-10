/**
 * 
 */
package com.steven.springboot.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author yumingwei
 * @Date Mar 26, 2017 
 * @Desc: 
 */
public interface FileService {

	/**
	 * Save the multipart file
	 * @param fileToUpload
	 * @param uploadTime 
	 * @return
	 * @throws IOException
	 */
	String saveFile(MultipartFile fileToUpload, long fileUploadTime) throws IOException;

	HashMap<Integer, String> getFileList();

	String searchFileById(int fileId);

	List<Integer> searchFileByExtension(String fileExt);

	List<Integer> searchFileByPartialName(String fileName);

	Integer searchFileByFullNameWithExtension(String fileName, String fileExt);

	void downLoadFileById(int fileId, HttpServletResponse response, HttpServletRequest request) throws IOException;

	void downLoadFileByName(String fileName, HttpServletResponse response, HttpServletRequest request)
			throws IOException;

	void sendEmail();

	void getRecentUploadFiles();

}