package com.finra.upload.utility;

import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.finra.upload.entity.FileInfo;
import com.finra.upload.service.FileInfoService;
import com.finra.upload.service.mail.MailService;

@Component
@ConfigurationProperties
@EnableScheduling
public class Scheduler {

	@Autowired
    MailService mailService;
    
    @Autowired
	FileInfoService fileService;
    
    @Value("${sendTo}")
    String sendTo;
    
    @Value("${topic}")
    String topic;
    
//    @Scheduled(initialDelay=5000, fixedRate=5000)
// in order to test, delete "//", then configure your email account 
// and destination email address in application.properties
//    @Scheduled(cron="0 0 0/1 1/1 * ? *")
    public void sendEmail() throws MessagingException {
    	String body = getBody();
    	mailService.send(sendTo, topic, body);
    }

	private String getBody() {
		StringBuilder sb = new StringBuilder();
		List<FileInfo> fileInfoList = fileService.getRecentFile();
		for (FileInfo fileInfo : fileInfoList) {
			sb.append(fileInfo.toString()+"\r\n");
		}
		return sb.toString();
	}
}
