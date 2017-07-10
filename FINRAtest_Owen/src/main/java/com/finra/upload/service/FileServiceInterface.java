package com.finra.upload.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

public interface FileServiceInterface {

	String uploadFile(MultipartFile multipartFile, Integer id, long fileUploadTime) throws IOException;

	String downloadFile(Integer id, HttpServletResponse response, HttpServletRequest request) throws IOException;

}