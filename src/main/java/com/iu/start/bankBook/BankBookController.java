package com.iu.start.bankBook;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.start.member.BankMembersDTO;

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
	public ModelAndView detail(Long bookNum) throws Exception {
		ModelAndView mv = new ModelAndView();
		System.out.println("detail 실행");
		System.out.println("booknum: "+ bookNum);
		
		
		BankBookDTO dto = new BankBookDTO();
		dto.setBookNum(bookNum);
		
		dto = dao.getDetail(dto);
		mv.addObject("detail", dto);
		mv.setViewName("bankbook/detail");
		
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
	public ModelAndView add(BankBookDTO dto) throws Exception {
		System.out.println("add 실행 - post");

		ModelAndView mv = new ModelAndView();
		int result = dao.setBankBook(dto);
		
		if(result  != 0) {
			System.out.println("성공");
			mv.setViewName("redirect: list");
		} else {
			System.out.println("실패");
			mv.setViewName("redirect: add");
		}
		
		return mv;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public ModelAndView update(BankBookDTO dto, ModelAndView mv) throws Exception {
		System.out.println("update페이지 들어갔는지 확인༼ つ ◕_◕ ༽つ༼ つ ◕_◕ ༽つ");
		BankBookDAO dao = new BankBookDAO();
		dto = dao.getDetail(dto);
		mv.setViewName("bankbook/update");
		System.out.println("받은 bookNum="+dto.getBookNum());
		mv.addObject("dto", dto);
		return mv;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ModelAndView update(BankBookDTO dto) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = dao.setUpdate(dto);
		if(result != 0) {
			System.out.println("성공!💯💯👏");
		}
		mv.setViewName("redirect: detail?bookNum="+dto.getBookNum());
		return mv;
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public ModelAndView delete(BankBookDTO dto) throws Exception {
		System.out.println("delete 실행(☞ﾟヮﾟ)☞☜(ﾟヮﾟ☜)");
		ModelAndView mv = new ModelAndView();
		int result = dao.setDelete(dto);
		System.out.println(result);
		mv.setViewName("redirect: list");
		return mv;
	}

}
