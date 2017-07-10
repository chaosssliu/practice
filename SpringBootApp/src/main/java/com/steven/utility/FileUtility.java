/**
 * 
 */
package com.steven.utility;

import java.util.HashMap;

import com.steven.springboot.entity.FileMetaData;

/**
 * @author Steven
 * @Date Mar 25, 2017 
 * @Desc: 
 */
public class FileUtility {

	public static String downloadFileDir = "./src/main/resources/downloads/";
	
	public static HashMap<Integer, String> fileMap = new HashMap<Integer, String>();
	
	public static HashMap<String, Integer> fileMapStringKey = new HashMap<String, Integer>();
	
	public static HashMap<Integer, FileMetaData> metaDataMap = new HashMap<Integer, FileMetaData>();
		
}
