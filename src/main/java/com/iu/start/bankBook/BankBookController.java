package com.iu.start.bankBook;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/bankbook/*")
public class BankBookController {
	BankBookDAO dao = new BankBookDAO();
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list(HttpServletRequest re) throws Exception {
		System.out.println("list 실행");
		ArrayList<BankBookDTO> ar = dao.getList();
		re.setAttribute("list", ar);
		
		return "bankbook/list";
	}
	
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String detail(Long bookNum, HttpServletRequest re) throws Exception {
		System.out.println("detail 실행");
		System.out.println("booknum: "+ bookNum);
		
		BankBookDTO dto = new BankBookDTO();
		dto.setBookNum(bookNum);
		
		dto = dao.getDetail(dto);
		re.setAttribute("detail", dto);
		
		return "bankbook/detail";
	}

// 2번째 방법
//	@RequestMapping(value = "detail", method = RequestMethod.GET)
//	public String detail(HttpServletRequest re) throws Exception {
//		System.out.println("detail 실행");
//		
//		Long bookNum = Long.parseLong(re.getParameter("bookNum"));
//		
//		System.out.println("booknum: "+ bookNum);
//		
//		BankBookDTO dto = new BankBookDTO();
//		dto.setBookNum(bookNum);
//		
//		dto = dao.getDetail(dto);
//		
//		re.setAttribute("detail", dto);
//		
//		return "bankbook/detail";
//	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add() {
		System.out.println("들어왔나?");
		
		return "bankbook/add";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public void add(BankBookDTO dto) throws Exception {
		System.out.println("post 들어왔나??");

		int result = dao.setBankBook(dto);
		System.out.println(result);

		if(result  != 0) {
			System.out.println("성공");			
		} else {
			System.out.println("실패");			
		}
		
	}

}
