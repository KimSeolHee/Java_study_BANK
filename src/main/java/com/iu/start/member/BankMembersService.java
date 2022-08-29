package com.iu.start.member;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.start.bankAccount.BankAccountDAO;
import com.iu.start.bankAccount.BankAccountDTO;
import com.iu.start.bankBook.BankBookDTO;
import com.iu.start.util.FileManager;

@Service
public class BankMembersService {

	@Autowired
	private BankMembersDAO bankMembersDAO;
	
	@Autowired
	private FileManager fileManager;
	
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
	
	public int setJoin(BankMembersDTO bankMembersDTO, MultipartFile photo, HttpSession session) throws Exception{
		int result = bankMembersDAO.setJoin(bankMembersDTO);

		String path = "resources/upload/member";
		if(!photo.isEmpty()) {
			String fileName = fileManager.saveFile(path, photo, session.getServletContext());
			
			MembersFileDTO memberFileDTO = new MembersFileDTO();
			memberFileDTO.setFileName(fileName);
			memberFileDTO.setOriName(photo.getOriginalFilename());
			memberFileDTO.setId(bankMembersDTO.getId());
			bankMembersDAO.setAddFile(memberFileDTO);
		}
		
		return result;
	}

	public List<BankMembersDTO> getSearchById(String search) throws Exception{
		return bankMembersDAO.getSearchById(search);
	}
	
	public BankMembersDTO getLogin(BankMembersDTO dto) throws Exception{
		return bankMembersDAO.getLogin(dto);
	}
	
}
