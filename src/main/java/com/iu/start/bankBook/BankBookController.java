package com.iu.start.bankBook;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/bankbook/*")
public class BankBookController {
	BankBookDAO dao = new BankBookDAO();
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void list(HttpServletRequest re) throws Exception {
		System.out.println("list 실행");
		ArrayList<BankBookDTO> ar = dao.getList();
		re.setAttribute("list", ar);
		
//		return "bankbook/list"; 
// requestMapping주소와 return view주소와 같으면 return 생략가능!
	}
	
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public ModelAndView detail(Long bookNum, HttpServletRequest re) throws Exception {
		ModelAndView mv = new ModelAndView();
		System.out.println("detail 실행");
		System.out.println("booknum: "+ bookNum);
		
		mv.setViewName("bankBook/detail");
		
		BankBookDTO dto = new BankBookDTO();
		dto.setBookNum(bookNum);
		
		dto = dao.getDetail(dto);
		re.setAttribute("detail", dto);
		
		return mv;
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
	
	// /bankbook/add , /WEB-INF/views/bankbook/add.jsp
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add() {
		System.out.println("add 실행");
		
		return "bankbook/add";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public void add(BankBookDTO dto) throws Exception {
		System.out.println("add 실행 - post");

		int result = dao.setBankBook(dto);

		if(result  != 0) {
			System.out.println("성공");			
		} else {
			System.out.println("실패");			
		}
		
	}

}
