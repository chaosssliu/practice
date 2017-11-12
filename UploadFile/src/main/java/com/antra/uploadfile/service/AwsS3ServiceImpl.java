package com.antra.uploadfile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

@Service
public class AwsS3ServiceImpl implements AwsS3Service {

	@Autowired
	private AmazonS3Client s3client;
	
	@Override
	public void uploadFile(MultipartFile file) {
		try {
			ObjectMetadata objectMetadata = new ObjectMetadata();
			objectMetadata.setContentType(file.getContentType());
		
			s3client.putObject(new PutObjectRequest("bucketname", file.getOriginalFilename(), file.getInputStream(), objectMetadata)
					.withCannedAcl(CannedAccessControlList.PublicRead));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
