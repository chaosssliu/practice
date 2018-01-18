package com.antra.uploadfile.service;

import org.springframework.web.multipart.MultipartFile;

public interface AwsS3Service {

	public void uploadFile(MultipartFile file);
}
