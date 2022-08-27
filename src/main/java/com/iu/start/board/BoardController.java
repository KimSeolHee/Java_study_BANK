package com.iu.start.board;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.start.member.BankMembersDTO;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value = "list.do",  method = RequestMethod.GET)
	public String list(Pager pager, Model model) throws Exception {
		System.out.println("controller : "+ pager.getPageStartNum());
		System.out.println("controller : "+ pager.getPageLastNum());
		List<NoticeDTO> ar = boardService.getList(pager);
		
		model.addAttribute("pager", pager);
		model.addAttribute("list", ar);
		
		return "./board/list";
		//value 주소와 같으면 생략가능
	}
	
	@RequestMapping("detail.do")
	public ModelAndView detail(Long num,Pager pager) throws Exception {
		System.out.println("detail-GET확인");
		ModelAndView mv = new ModelAndView();
		NoticeDTO boardDTO = new NoticeDTO();
		
		boardDTO.setNum(num);
		boardDTO = boardService.getDetail(boardDTO);
		mv.addObject("detail", boardDTO);
		mv.setViewName("/board/detail");
		
		return mv;
	}
	
	@RequestMapping(value = "update.do", method = RequestMethod.GET)
	public ModelAndView update(NoticeDTO boardDTO, ModelAndView mv) throws Exception {
		System.out.println("update - get");
		boardDTO = boardService.getDetail(boardDTO);
		
		mv.setViewName("board/update");
		mv.addObject("boardDTO", boardDTO);
		
		return mv;
	}
	
	@RequestMapping(value = "update.do", method = RequestMethod.POST)
	public String update(NoticeDTO boardDTO) throws Exception {
		System.out.println("update - post");
		
		boardDTO.setNum(boardDTO.getNum());
		int result = boardService.setUpdate(boardDTO);
		
		System.out.println(result);
		
		if(result != 0) {
			System.out.println("업데이트성공");
		}
		
		return "redirect: list.do";	
	}
	
	@RequestMapping(value = "delete.do", method = RequestMethod.GET)
	public ModelAndView delete(Long num) throws Exception {
		System.out.println("delete 실행확인");
		NoticeDTO boardDTO = new NoticeDTO();
		boardDTO.setNum(num);
		System.out.println(boardDTO.getNum());
		boardService.setDelite(boardDTO);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect: list.do");
		
		return mv;
	}
	
	@RequestMapping(value = "add.do", method = RequestMethod.GET)
	public ModelAndView add() throws Exception {
		System.out.println("add-get 실행");
		
		NoticeDTO boardDTO = new NoticeDTO();
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("add", boardDTO);
		mv.setViewName("board/add");
		
		return mv;
	}
	
	@RequestMapping(value = "add.do", method = RequestMethod.POST)
	public String add(HttpSession session, NoticeDTO boardDTO) throws Exception {
		System.out.println("add-post");
		boardService.setAdd(boardDTO);
		
		session.setAttribute("add", boardDTO);
		return "redirect: list.do";
	}
	

}
