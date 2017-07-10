package com.finra.upload.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.finra.upload.entity.FileInfo;

public interface FileInfoDAO extends CrudRepository<FileInfo, Integer>, JpaRepository<FileInfo, Integer> {

	@Query(value="SELECT f FROM FileInfo f WHERE f.name LIKE %?1%")
	List<FileInfo> getFileInfoByName(String name);
	
	@Query(value = "SELECT f FROM FileInfo f WHERE HOUR(f.date) > (HOUR(current_timestamp)-1)")
	List<FileInfo> getRecentFile();
	
//	@Query(value="SELECT f FROM FileInfo f WHERE f.id = 'id'")
//	FileInfo getFileInfoById(Integer id);
}
