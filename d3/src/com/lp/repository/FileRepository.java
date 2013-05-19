package com.lp.repository;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import org.apache.catalina.connector.Request;
import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

public class FileRepository {
	private Logger logger = Logger.getLogger(getClass());
	private String path;

	public FileRepository(String path) {
		logger.info("FileRepository................" + path);
		this.path = path;
		File saveFolder = new File(path);
		if (!saveFolder.exists() || saveFolder.isFile()) {

			logger.info("path FOLDER MAKING................." + path);
			saveFolder.mkdirs();
		}
	}

	public String saveFile(MultipartFile sourcefile,Request request) throws IOException {

		logger.info("fileName ing................." + sourcefile.getOriginalFilename());
		logger.info("fileName ing................." + sourcefile.getName());
		logger.info("fileName ing................." + sourcefile.getBytes());
		logger.info("fileName ing................." + sourcefile.getInputStream());
		logger.info("fileName ing................." + sourcefile.getSize());
		logger.info("fileSize ing................." + sourcefile.getSize() / 1024 + "(KB)");

		logger.info("saveFile ing.................");

		if ((sourcefile == null) || (sourcefile.isEmpty()))
			return null;
		String key = UUID.randomUUID().toString();
		// String targetFilePath = path+"/"+ key;
		// FileRepository fileRepository = new FileRepository(path);
		String targetFilePath = path + "/" + sourcefile.getOriginalFilename();
		sourcefile.transferTo(new File(targetFilePath));
		String filePath = System.getProperty("java.io.tmpdir") + "/" + sourcefile.getOriginalFilename();
		sourcefile.transferTo(new File(filePath));

		logger.info("targetFilePath................." + targetFilePath);
		logger.info("filePath................." + filePath);

		
		
		
		
		 
		
		
		
		key = "/upload-folder/" + sourcefile.getOriginalFilename();
		return key;
	}
}