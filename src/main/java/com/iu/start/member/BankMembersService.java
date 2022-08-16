package com.iu.start.member;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankMembersService {

	@Autowired
	private BankMembersDAO bankMembersDAO;
	
	public BankMembersDTO getLogin(BankMembersDTO dto) throws Exception {
		return bankMembersDAO.getLogin(dto);
	}
	
	public int setJoin(BankMembersDTO bankMembersDTO) throws Exception{
		return bankMembersDAO.setJoin(bankMembersDTO);
	}

	public ArrayList<BankMembersDTO> getSearchById(String search) throws Exception {
		return bankMembersDAO.getSearchById(search);
	}
}
