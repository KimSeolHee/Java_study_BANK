package com.iu.start.member;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.start.bankAccount.BankAccountDAO;
import com.iu.start.bankAccount.BankAccountDTO;
import com.iu.start.bankBook.BankBookDTO;

@Service
public class BankMembersService {

	@Autowired
	private BankMembersDAO bankMembersDAO;
	@Autowired
	private ServletContext servletContext;
	
//	@Autowired
//	private BankAccountDAO bankAccountDAO;
//	
//	public Map<String, Object> getMyPage(BankMembersDTO bankMembersDTO) throws Exception{
//		Map<String, Object> map = new HashMap<String, Object>();
//		List<BankAccountDTO> ar = bankAccountDAO.getListByUserName(bankMembersDTO);
//		bankMembersDTO = bankMembersDAO.getMyPage(bankMembersDTO);
//		map.put("list", ar);
//		map.put("dto", bankMembersDTO);
//		
//		return map;
//	}
	
	public BankMembersDTO getMyPage(BankMembersDTO bankMembersDTO) throws Exception{
		return bankMembersDAO.getMyPage(bankMembersDTO);
	}
	
	public int setJoin(BankMembersDTO bankMembersDTO, MultipartFile photo) throws Exception{
		int result = bankMembersDAO.setJoin(bankMembersDTO);
		
		//1. HDD에 파일을 저장
		//		파일저장시에 경로는 Tomcat 기준이 아니라 OS의 기준으로 설정
		//1) 파일저장 위치
		//		/resources/upload/member
		if(!photo.isEmpty()) {
		//2) 저장할 폴더의 실제 경로 반환(OS 기준)
		String realPath = servletContext.getRealPath("resources/upload/member");
		System.out.println("realPath : "+realPath);
		//2. 저장된 파일 정보를 DB에 저장
		
		//3) 저장할 폴더의 정보를 가지는 자바 객체 생성
		
		//파일 첨부가 없을 때 구분
//		if(photo.getSize()!=0) {}
//		if(!photo.isEmpty()) {}
		
		//		폴더가 없을땐 만든다.
		File file = new File(realPath);
		if(!file.exists()) {
			file.mkdirs();
		}
		
		//4) 파일을 저장할 때 중복되지 않는 파일명을 만들어줘야함.
		//		--시간 or 자바 클래스 이용
		String fileName = UUID.randomUUID().toString();
		System.out.println("fileName : "+fileName);
		//시간을 이용할땐 아래방법으로
		Calendar ca = Calendar.getInstance();
		//현재 시간을 millis단위로 바꾼다.
		Long time = ca.getTimeInMillis();
		System.out.println("time : "+time);
		
		//뒤에 확장자를 붙이게끔 만들어준다.
		fileName = fileName+"_"+photo.getOriginalFilename();	
		
		//5) HDD에 파일 저장
		// 어느 폴더에 어떤 이름으로 저장할 File 객체 생성
		//(file = 경로명, fileName= 저장할 파일명 을 이용해 파일객체를 새로만듬)
		file = new File(file, fileName);
		
		//		1) MulipartFile 클래스의 transferTo메서드를 사용
		photo.transferTo(file);
		//		2) FileCopyUtils 클래스의 copy메서드를 사용
		
		// 2. 저장된 파일 정보를 DB에 저장
		MembersFileDTO membersFileDTO = new MembersFileDTO();
		membersFileDTO.setFileName(fileName);
		membersFileDTO.setOriName(photo.getOriginalFilename());
		membersFileDTO.setId(bankMembersDTO.getId());
		int count = bankMembersDAO.setAddFile(membersFileDTO);
		System.out.println(count);
		}//isEmpty끝
		
		return result;
	}

	public List<BankMembersDTO> getSearchById(String search) throws Exception{
		return bankMembersDAO.getSearchById(search);
	}
	
	public BankMembersDTO getLogin(BankMembersDTO dto) throws Exception{
		return bankMembersDAO.getLogin(dto);
	}
	
}
