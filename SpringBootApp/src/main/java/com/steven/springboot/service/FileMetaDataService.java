/**
 * 
 */
package com.steven.springboot.service;

import java.util.List;

import com.steven.springboot.entity.FileMetaData;

/**
 * @author yumingwei
 * @Date Mar 26, 2017 
 * @Desc: 
 */
public interface FileMetaDataService {

	/**
	 * Save meta data
	 * @param uploadTime 
	 */
	String saveMetaData(int fileId, String fileName, String fileExtension, Long fileSize, String fileAuthor, long fileUploadTime);

	/**
	 * Get meta data by file Id
	 * @param Id
	 * @return
	 */
	FileMetaData getEMeaDataById(int Id);

	FileMetaData getEMeaDataByName(String fileName);

	List<FileMetaData> getAllMetaData();

}