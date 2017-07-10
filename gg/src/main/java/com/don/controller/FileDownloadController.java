package com.don.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.don.model.FileInfo;
import com.don.service.FileInfoService;

@RestController
public class FileDownloadController {

	@Autowired
	FileInfoService fileService;

	@RequestMapping(value = "/file/{id}", method = RequestMethod.GET)
	public String uploadFileHandler(@PathVariable("id") Integer id, HttpServletResponse response) {

		FileInfo fileinfo = fileService.getFileInfoById(id);

		if (fileinfo == null) {
			return "File record not found)";
		}

		String path = fileinfo.getPath();
		File file = new File(path);
		
		if (file.exists()) {
			try {
				InputStream is = new FileInputStream(path);
				response.addHeader("Content-disposition", "attachment;filename=" + fileinfo.getName());
				response.setContentType("application/octet-stream");
				FileCopyUtils.copy(is, response.getOutputStream());
				return "File will be downloaded shortly";
			} catch (IOException e) {
				e.printStackTrace();
				return "IO Exception occured on server";
			}
		}
		return "File in record but does not exist";
	}
}