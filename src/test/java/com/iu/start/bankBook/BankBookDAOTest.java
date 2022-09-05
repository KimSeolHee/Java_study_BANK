package com.iu.start.bankBook;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.start.MyAbstractTest;

public class BankBookDAOTest extends MyAbstractTest{
	
	@Autowired
	private BankBookDAO bankBookDAO;
	
//	@Test
//	public void setUpdate() throws Exception{
//		BankBookDTO bookDTO = new BankBookDTO();
//		bookDTO.setBookName("돈없는통장");
//		bookDTO.setBookRate(1.1);
//		bookDTO.setBookNum(1660198856896L);
//		
//		int result = bankBookDAO.setUpdate(bookDTO);
//		
//		assertEquals(1, result);
//	}

//	@Test
//	public void setBankBook() throws Exception{
//		BankBookDTO bookDTO = new BankBookDTO();
//		Long millis = System.currentTimeMillis();
//		bookDTO.setBookNum(millis);
//		bookDTO.setBookName("좋은통장");
//		bookDTO.setBookRate(2.2);
//		
//		int result = bankBookDAO.setBankBook(bookDTO);
//		
//		assertEquals(1, result);
//	}
	
//	@Test
//	public void getList() throws Exception {
//		List<BankBookDTO> ar = bankBookDAO.getList();
//		assertEquals(0, ar.size());
//	}
	@Test
	public void setComment() throws Exception{
		BankBookCommentDTO commentDTO = new BankBookCommentDTO();
		commentDTO.setBookNum(1661584257995L);
		commentDTO.setWriter("tttt");
		commentDTO.setContents("ggg");
		
		int result = bankBookDAO.setComment(commentDTO);
		
		assertEquals(1,result);
		
	}
}
