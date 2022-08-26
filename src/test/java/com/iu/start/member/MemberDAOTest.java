package com.iu.start.member;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.start.MyAbstractTest;
import com.iu.start.member.BankMembersDAO;
import com.iu.start.member.BankMembersDTO;

public class MemberDAOTest extends MyAbstractTest{

	@Autowired
	private BankMembersDAO bankMembersDAO;
	
	@Test
	public void getSearchByIdTest() throws Exception{
		String search = "tttt";
		List<BankMembersDTO> ar= bankMembersDAO.getSearchById(search);
		
		assertEquals(1, ar.size());
	}
	
	@Test
	public void getMyPage() throws Exception{
		BankMembersDTO bankMembersDTO = new BankMembersDTO();
		bankMembersDTO.setId("tttt");
		
		bankMembersDTO = bankMembersDAO.getMyPage(bankMembersDTO);
		System.out.println(bankMembersDTO.getEmail());
		assertNotNull(bankMembersDTO);
	}
	
	
//	@Test
//	public void getLoginTest() throws Exception{
//		BankMembersDTO bankMembersDTO = new BankMembersDTO();
//		
//		bankMembersDTO.setId("tttt");
//		bankMembersDTO.setPw("tttt");
//		bankMembersDTO = bankMembersDAO.getLogin(bankMembersDTO);
//		assertNotNull(bankMembersDTO);
//	}
	
//	@Test
//	public void setJoin() throws Exception{
//		BankMembersDTO bankMembersDTO = new BankMembersDTO();
//		bankMembersDTO.setId("dd");
//		bankMembersDTO.setPw("544");
//		bankMembersDTO.setName("kdjfkj");
//		bankMembersDTO.setEmail("dkfj@dkfjdskl");
//		bankMembersDTO.setPhone("154154554");
//		
//		int result = bankMembersDAO.setJoin(bankMembersDTO);
//		
//		assertEquals(1, result);
//	}
	
}
