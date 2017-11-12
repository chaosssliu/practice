package com.antra.uploadfile.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;

@Configuration
public class S3Config {

	private String accessId = "AKIAJHYCP4L3IFBL2SKQ";
	
	private String accessKey = "Dc9JZzMKSSmuYMUVqQL6HicAIth5A8g7tV9eF0bw";
	
	@Bean
	public BasicAWSCredentials credential() {
		return new BasicAWSCredentials(accessId, accessKey);
	}
		
	@Bean
	public AmazonS3Client s3client() {
		return new AmazonS3Client(credential()); 
	}
}
