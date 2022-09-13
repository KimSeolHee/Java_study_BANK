package com.iu.start.bankAccount;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iu.start.member.BankMembersDTO;

@Controller
@RequestMapping("/bankAccount/*")
public class BankAccountController {
	private BankAccountDAO dao;
	
	public BankAccountController() {
		this.dao = new BankAccountDAO();
	}
	
	@RequestMapping(value = "add.do", method = RequestMethod.GET)
	public String add(BankAccountDTO bankAccountDTO, HttpSession session) throws Exception{
//		System.out.println("add");
//		DTO : userName, bookNum
//		int result = this.dao.add(null);
		BankMembersDTO bankMembersDTO = (BankMembersDTO)session.getAttribute("member");
		bankAccountDTO.setUserId(bankMembersDTO.getId());
		
		int result = this.dao.add(bankAccountDTO);
		
		return "redirect:../bankbook/list.do";
	}

}
