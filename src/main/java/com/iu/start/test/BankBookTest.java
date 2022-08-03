package com.iu.start.test;

import java.util.ArrayList;
import java.util.Calendar;

import com.iu.start.bankBook.BankBookDAO;
import com.iu.start.bankBook.BankBookDTO;

public class BankBookTest {

	public static void main(String[] args) {
		BankBookDAO dao = new BankBookDAO();
		BankBookDTO dto = new BankBookDTO();
// 1.		
//		Calendar now = Calendar.getInstance();
//		
//		dto.setBookNum(now.getTimeInMillis());
//		dto.setBookName("행복한통장");
//		dto.setBookRate(10.2);
//		try {
//			int result = dao.setBankBook(dto);
//			if(result != 0) {
//				System.out.println("성공");
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
// 2.
//		try {
//			ArrayList<BankBookDTO> ar = dao.getList();
//			for(int i = 0; i < ar.size(); i++) {
//				System.out.print(ar.get(i).getBookNum()+"\t\t");
//				System.out.print(ar.get(i).getBookName()+"\t\t");
//				System.out.print(ar.get(i).getBookRate()+"\t\t");
//				System.out.println(ar.get(i).getBookSale());
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//3.
//		try {
//			dto.setBookSale(1);
//			dto.setBookNum(3L);
//			int result = dao.setChangeSale(dto);
//			
//			if(result != 0) {
//				System.out.println("성공!");
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
// 4.
//		try {
//			dto.setBookNum(5L);
//			dto = dao.getDetail(dto);
//			if(dto != null) {
//				System.out.print("\t"+dto.getBookNum()+" \t|\t ");
//				System.out.print(dto.getBookName()+" \t|\t ");
//				System.out.print(dto.getBookRate()+" \t|\t ");
//				System.out.println(dto.getBookSale());	
//			}else {
//				System.out.println("없다.");				
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	
	}

}
