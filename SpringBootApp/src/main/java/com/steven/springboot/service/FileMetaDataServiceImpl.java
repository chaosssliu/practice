/**
 * 
 */
package com.steven.springboot.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.steven.springboot.DAO.FileMetaDataDAO;
import com.steven.springboot.entity.FileMetaData;
import com.steven.utility.FileUtility;

/**
 * @author Steven
 * @Date Mar 24, 2017 
 * @Desc: 
 */
@Service
public class FileMetaDataServiceImpl implements FileMetaDataService {
	
	@Autowired
	FileService fileServiceImpl;
	
	@Autowired
	FileMetaDataDAO fileMetaDataDAO;
	
	/**
	 * Save meta data
	 */
	@Override
	@Transactional
	public String saveMetaData(int fileId, String fileName, String fileExtension, 
			Long fileSize, String fileAuthor, long fileUploadTime) {
		
		FileMetaData metaData = new FileMetaData(fileId, fileName, fileExtension, fileSize, fileAuthor, fileUploadTime);
		FileUtility.metaDataMap.put(fileId, metaData);
		
		fileMetaDataDAO.save(metaData);
		
		return "Save meta data success!";
	}
	
	/**
	 * Get meta data by file Id
	 * @param Id
	 * @return
	 */
	@Override
	@Transactional
	public FileMetaData getEMeaDataById(int Id) {
		if(FileUtility.metaDataMap.containsKey(Id)) {
//			return FileUtility.metaDataMap.get(Id);
			return fileMetaDataDAO.get(Id);
		}
		return null;
	}
	
	@Override
	@Transactional
	public FileMetaData getEMeaDataByName(String fileName) {
		if(FileUtility.fileMapStringKey.containsKey(fileName)) {
			return fileMetaDataDAO.get(FileUtility.fileMapStringKey.get(fileName));
		}
		return null;
	}
	
	@Override
	@Transactional
	public List<FileMetaData> getAllMetaData() {
		return fileMetaDataDAO.getAllMetaData();
	}
	
	
}
