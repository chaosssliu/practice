package com.antra.uploadfile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.antra.uploadfile.service.AwsS3Service;

@Controller
public class UploadController {
	
	private static String UPLOADED_FOLDER = "F://temp//";
	
	@Autowired
	AwsS3Service s3Service;
	
	@GetMapping("/")
	public String index() {
		return "upload";
	}
	
	@PostMapping("/upload")
	public String singleFileUpload(@RequestParam("file") MultipartFile file,
			RedirectAttributes redirectAttributes) {
		if (!file.isEmpty()) {
			s3Service.uploadFile(file);
			redirectAttributes.addFlashAttribute("message", "Successfully uploaded '" + file.getOriginalFilename() + "'");		
		} else {
			redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
			return "redirect:/uploadStatus";
		}
		return "redirect:/uploadStatus";
	}
	
//	@PostMapping("/upload")
//	public String singleFileUpload(@RequestParam("file") MultipartFile file,
//			RedirectAttributes redirectAttributes) {
//		
//		if (file.isEmpty()) {
//			redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
//			return "redirect:uploadStatus";
//		}
//		
//		try {
//			
//			byte[] bytes = file.getBytes();
//			Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
//			Files.write(path, bytes);
//			
//			redirectAttributes.addFlashAttribute("message", "You successfully uploaded'" +file.getOriginalFilename() + "'");
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		return "redirect:/uploadStatus";
//	}
	
	@RequestMapping(value="/uploadStatus")
	public String uploadStatus() {
		return "uploadStatus";
	}

}
