package com.lp.action;

import java.io.IOException;
import java.io.Writer;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.lp.repository.FileRepository;

@Controller
public class FileAction {
	private FileRepository respository;

	 private Logger logger = Logger.getLogger(getClass());
	@Autowired
	public void setRespository(FileRepository respository) {
		this.respository = respository;
	}

	@RequestMapping("/upload.do")
	public void execute(@RequestParam("upload") MultipartFile file, Writer out)
			throws IOException {
		logger.info("upload ing.................");
		String fileName="";
		long fileSize =0;
		 
		if(file!=null){
			fileName = file.getOriginalFilename();
			fileSize = file.getSize()/1024;
			//do whatever you want
		}
		logger.info("fileName maxUploadSize................."+500000/1024+"(KB)");
		logger.info("fileName ing................."+fileName);
		logger.info("fileSize ing................."+fileSize +"(KB)");
		
		String key = respository.saveFile(file);
		out.write(key);
	}
}