package com.iu.start.board;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.start.member.BankMembersDTO;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	BoardDAO boardDAO = new BoardDAO();
	@RequestMapping(value = "list.do",  method = RequestMethod.GET)
	public String list(HttpServletRequest re) throws Exception {
		System.out.println("list-GET확인");
		
		ArrayList<BoardDTO> ar = boardDAO.getList();
		re.setAttribute("list", ar);
		
		return "./board/list";
		//value 주소와 같으면 생략가능
	}
	
	@RequestMapping("detail.do")
	public ModelAndView detail(Long boardNum) throws Exception {
		System.out.println("detail-GET확인");
		ModelAndView mv = new ModelAndView();
		BoardDTO boardDTO = new BoardDTO();
		
		boardDTO.setBoardNum(boardNum);
		boardDTO = boardDAO.getDetail(boardDTO);
		mv.addObject("detail", boardDTO);
		mv.setViewName("/board/detail");
		
		return mv;
	}
	
	@RequestMapping(value = "update.do", method = RequestMethod.GET)
	public ModelAndView update(BoardDTO boardDTO, ModelAndView mv) throws Exception {
		System.out.println("update - get");
		boardDTO = boardDAO.getDetail(boardDTO);
		
		mv.setViewName("board/update");
		mv.addObject("boardDTO", boardDTO);
		
		return mv;
	}
	
	@RequestMapping(value = "update.do", method = RequestMethod.POST)
	public String update(BoardDTO boardDTO) throws Exception {
		System.out.println("update - post");
		
		int result = boardDAO.setUpdate(boardDTO);
		System.out.println(result);
		
		if(result != 0) {
			System.out.println("업데이트성공");
		}
		
		return "redirect: list.do";	
	}
	
	@RequestMapping(value = "delete.do", method = RequestMethod.GET)
	public ModelAndView delete(Long boardNum) throws Exception {
		System.out.println("delete 실행확인");
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setBoardNum(boardNum);
		boardDAO.setDelite(boardDTO);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect: list.do");
		
		return mv;
	}
	
	@RequestMapping(value = "add.do", method = RequestMethod.GET)
	public ModelAndView add() throws Exception {
		System.out.println("add-get 실행");
		
		BoardDTO boardDTO = new BoardDTO();
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("add", boardDTO);
		mv.setViewName("board/add");
		
		return mv;
	}
	
	@RequestMapping(value = "add.do", method = RequestMethod.POST)
	public String add(HttpSession session, BoardDTO boardDTO) throws Exception {
		System.out.println("add-post");
		int result = boardDAO.setAdd(boardDTO);
		
		session.setAttribute("add", boardDTO);
		return "redirect: list.do";
	}
	

}
