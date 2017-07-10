/**
 * 
 */
package com.steven.springboot.DAO;

import java.util.List;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.steven.springboot.entity.FileMetaData;

/**
 * @author yumingwei
 * @Date Apr 3, 2017 
 * @Desc: 
 */
public class FileMetaDataDAOImpl2 implements FileMetaDataDAO {
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Override
	public void save(FileMetaData fileMetaData) {
		
	}

	@Override
	public FileMetaData get(int fileId) {
		return null;
	}

	@Override
	public List<FileMetaData> getAllMetaData() {
		return null;
	}

}
