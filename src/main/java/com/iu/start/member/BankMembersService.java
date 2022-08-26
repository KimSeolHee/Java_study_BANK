package com.iu.start.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.start.bankAccount.BankAccountDAO;
import com.iu.start.bankAccount.BankAccountDTO;
import com.iu.start.bankBook.BankBookDTO;

@Service
public class BankMembersService {

	@Autowired
	private BankMembersDAO bankMembersDAO;
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
	
	public int setJoin(BankMembersDTO bankMembersDTO) throws Exception{
		return bankMembersDAO.setJoin(bankMembersDTO);
	}

	public List<BankMembersDTO> getSearchById(String search) throws Exception{
		return bankMembersDAO.getSearchById(search);
	}
	
	public BankMembersDTO getLogin(BankMembersDTO dto) throws Exception{
		return bankMembersDAO.getLogin(dto);
	}
	
}
