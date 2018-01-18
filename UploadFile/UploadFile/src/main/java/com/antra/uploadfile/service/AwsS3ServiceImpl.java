package com.antra.uploadfile.service;

import java.security.MessageDigest;

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
	
	@Autowired
	private MDHashing mdHashing;
	
	@Override
	public void uploadFile(MultipartFile file) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			String digest = mdHashing.getDigest(file.getInputStream(), md, 1024);
			
			ObjectMetadata objectMetadata = new ObjectMetadata();
			objectMetadata.setContentType(file.getContentType());
		
			s3client.putObject(new PutObjectRequest("chaossstest", "folder/" + file.getOriginalFilename(), file.getInputStream(), objectMetadata)
					.withCannedAcl(CannedAccessControlList.PublicRead));
			
			System.out.println("MD5 digest is " + digest);
			System.out.println("ETag is " + s3client.getObjectMetadata("chaossstest", "folder/" + file.getOriginalFilename()).getETag());
			System.out.println("MD5 is " + s3client.getObjectMetadata("chaossstest", "folder/" + file.getOriginalFilename()).getContentMD5());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
