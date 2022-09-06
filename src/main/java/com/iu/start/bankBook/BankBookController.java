package com.iu.start.bankBook;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.iu.start.member.BankMembersDTO;
import com.iu.start.util.CommentPager;

@Controller
@RequestMapping(value = "/bankbook/*")
public class BankBookController {
	
	@Autowired
	private BankBookService bankBookService;
	@Autowired
	private BankBookCommentService bankBookCommentService;
	
	//jsp방법
//	@PostMapping("commentAdd")
//	public ModelAndView setCommentAdd(BankBookCommentDTO bankBookCommentDTO)throws Exception{
//		ModelAndView mv = new ModelAndView();
//		int result = bankBookCommentService.setCommentAdd(bankBookCommentDTO);
//		mv.addObject("result", result);
//		mv.setViewName("common/ajaxResult");
//		
//		return mv;
//	}
	
	//json방법
	@PostMapping("commentAdd")
	@ResponseBody
	public String setCommentAdd(BankBookCommentDTO bankBookCommentDTO)throws Exception{
		
		int result = bankBookCommentService.setCommentAdd(bankBookCommentDTO);
		//{"key" : "value"}
		String jsonResult = "{\"comment\":\""+result+"\"}";
		//{"comment":"1"}이게 넘어감
		return jsonResult;
	}
	
//1. jsp
//	@GetMapping("commentList")
//	public ModelAndView getComment(CommentPager commentPager)throws Exception {
//		ModelAndView mv= new ModelAndView();
//		List<BankBookCommentDTO> ar = bankBookCommentService.getComment(commentPager);
//		System.out.println("List");
//		System.out.println(ar.size());
//		
//		mv.addObject("commentList", ar);
//		mv.setViewName("common/commentList");
//		return mv;
//	}
//	
	//2.
	@GetMapping("commentList")
	@ResponseBody
	public List<BankBookCommentDTO> getComment(CommentPager commentPager)throws Exception {
		List<BankBookCommentDTO> ar = bankBookCommentService.getComment(commentPager);
		//json
		// DTO == {}
		// num = 1 =={"num":1, "bookNum": 123, "writer":"name"}
		//[{}{}{}{}{}] jackson이 다 처리해준다(maven에서 pom.xml다운) 

		return ar;
	}	
	
	
	
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void list(HttpServletRequest re) throws Exception{
		List<BankBookDTO> ar= bankBookService.getList();
		
		re.setAttribute("list", ar);
	}
	
	@RequestMapping(value = "detail.do", method = RequestMethod.GET)
	public ModelAndView detail(Long bookNum) throws Exception {
		ModelAndView mv = new ModelAndView();
		System.out.println("detail 실행");
		System.out.println("booknum: "+ bookNum);
		
		
		BankBookDTO dto = new BankBookDTO();
		dto.setBookNum(bookNum);
		
		dto = bankBookService.getDetail(dto);
		mv.addObject("detail", dto);
		mv.setViewName("bankbook/detail");
		
		return mv;
	}

	@RequestMapping(value = "add.do", method = RequestMethod.GET)
	public String add() {
		System.out.println("add 실행");
		
		return "bankbook/add";
	}
	
	@RequestMapping(value = "add.do", method = RequestMethod.POST)
	public ModelAndView add(BankBookDTO dto) throws Exception {

		ModelAndView mv = new ModelAndView();
		Calendar ca = Calendar.getInstance();
		dto.setBookNum(ca.getTimeInMillis());
		
		int result = bankBookService.setBankBook(dto);
		
		if(result  != 0) {
			System.out.println("성공");
			mv.setViewName("redirect: list.do");
		} else {
			System.out.println("실패");
			mv.setViewName("redirect: add.do");
		}
		
		return mv;
	}
	
	@RequestMapping(value = "update.do", method = RequestMethod.GET)
	public ModelAndView update(BankBookDTO dto, ModelAndView mv) throws Exception {
		System.out.println("update페이지 들어갔는지 확인༼ つ ◕_◕ ༽つ༼ つ ◕_◕ ༽つ");
		dto = bankBookService.getDetail(dto);
		mv.setViewName("bankbook/update");
		System.out.println("받은 bookNum="+dto.getBookNum());
		mv.addObject("dto", dto);
		return mv;
	}
	
	@RequestMapping(value = "update.do", method = RequestMethod.POST)
	public ModelAndView update(BankBookDTO dto) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = bankBookService.setUpdate(dto);
		if(result != 0) {
			System.out.println("성공!💯💯👏");
		}
		mv.setViewName("redirect: detail.do?bookNum="+dto.getBookNum());
		return mv;
	}
	
	@RequestMapping(value = "delete.do", method = RequestMethod.GET)
	public ModelAndView delete(BankBookDTO dto) throws Exception {
		System.out.println("delete 실행(☞ﾟヮﾟ)☞☜(ﾟヮﾟ☜)");
		ModelAndView mv = new ModelAndView();
		int result = bankBookService.setDelete(dto);
		System.out.println(result);
		mv.setViewName("redirect: list.do");
		return mv;
	}

}
