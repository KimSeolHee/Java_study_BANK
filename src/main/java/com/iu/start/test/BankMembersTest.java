package com.iu.start.test;

import java.util.ArrayList;
import java.util.Scanner;

import com.iu.start.member.BankMembersDAO;
import com.iu.start.member.BankMembersDTO;

public class BankMembersTest {

	public static void main(String[] args) {
		BankMembersDAO membersDAO = new BankMembersDAO();
		BankMembersDTO membersDTO = new BankMembersDTO();
//		try {
//			membersDTO.setId("tjfl");
//			membersDTO.setPw("dffff");
//			membersDTO.setName("서리");
//			membersDTO.setEmail("tlfl64@naver.com");
//			membersDTO.setPhone("010-2626-1111");
//			
//			int result = membersDAO.setJoin(membersDTO);
//			
//			if(result != 0) {
//				System.out.println("대성공");
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		System.out.println("test");
			try {
				ArrayList<BankMembersDTO> ar = membersDAO.getSearchById("SE");
				System.out.println(ar.size()); //ar에서 검색할 단어가 있는지 미리 확인! 
				for(int i = 0;i  < ar.size(); i++) {
					System.out.println(ar.get(i).getId());
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		System.out.println("test2");
		
	}

}
