/**
 * 
 */
package com.steven.springboot.DAO;

import java.util.List;

import com.steven.springboot.entity.FileMetaData;

/**
 * @author yumingwei
 * @Date Mar 26, 2017 
 * @Desc: 
 */
public interface FileMetaDataDAO {

	void save(FileMetaData fileMetaData);

	FileMetaData get(int fileId);

	List<FileMetaData> getAllMetaData();

}