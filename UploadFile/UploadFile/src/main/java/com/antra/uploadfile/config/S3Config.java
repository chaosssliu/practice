package com.antra.uploadfile.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;

@Configuration
public class S3Config {

	private String accessId = "AKIAJMPF4QP756QZ3ENA";
	
	private String accessKey = "GiTP3ojFLPHc6oE2dBsYDypj/HyBxuDRKKuyfI8Z";
	
	@Bean
	public BasicAWSCredentials credential() {
		return new BasicAWSCredentials(accessId, accessKey);
	}
		
	@Bean
	public AmazonS3Client s3client() {
		return new AmazonS3Client(credential()); 
	}
}
