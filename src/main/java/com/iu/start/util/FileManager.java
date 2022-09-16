package com.iu.start.util;

import java.io.File;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
// 공통코드 묶기
import org.springframework.web.multipart.MultipartFile;

import com.iu.start.file.FileDTO;

@Component
public class FileManager {

//	@Autowired
//	private ServletContext sevletContext;
	
	//delete
	public boolean deleteFile(ServletContext servletContext, String path, FileDTO fileDTO)throws Exception{
		String realPath = servletContext.getRealPath(path);
		File file = new File(realPath, fileDTO.getFileName());
		
		return file.delete();
	}
	
	
	//save
	public String saveFile(String path, MultipartFile multipartFile, ServletContext servletContext) throws Exception{
		//경로가 다 다르므로 매개변수로 받는 방법
		//1. 실제 경로
		String realPath = servletContext.getRealPath(path);
		
		//2. 폴더(directory) 체크
		File file = new File(realPath);
		if(!file.exists()) {
			file.mkdirs();
		}
		
		//3. 저장할 파일명 생성
		String fileName = UUID.randomUUID().toString();
		fileName = fileName+"_"+multipartFile.getOriginalFilename();
		
		//4. HDD에 저장
		file = new File(file, fileName);
		multipartFile.transferTo(file);
		
		return fileName;
	}

}
