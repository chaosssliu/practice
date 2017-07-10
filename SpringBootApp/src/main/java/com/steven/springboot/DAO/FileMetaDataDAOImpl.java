/**
 * 
 */
package com.steven.springboot.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.steven.springboot.entity.FileMetaData;

/**
 * @author yumingwei
 * @Date Mar 26, 2017 
 * @Desc: 
 */
@Repository
public class FileMetaDataDAOImpl implements FileMetaDataDAO {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public void save(FileMetaData fileMetaData) {
		em.persist(fileMetaData);
	}
	
	@Override
	public FileMetaData get(int fileId) {
		FileMetaData fileMetaData = em.find(FileMetaData.class, fileId);
		return fileMetaData;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<FileMetaData> getAllMetaData() {
		Query query = em.createQuery("select m from FileMetaData m", FileMetaData.class);
		List<FileMetaData> fileMetaDataList = query.getResultList();
		return fileMetaDataList;
	}
}



