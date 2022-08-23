package com.iu.start.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.start.board.impl.BoardDTO;

@Controller
@RequestMapping(value = "/qna/*")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	//글목록
	@RequestMapping(value = "list.do", method = RequestMethod.GET)
	public ModelAndView getList() throws Exception{
		List<BoardDTO> ar= qnaService.getList();
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", ar);
		mv.setViewName("qna/list");
		
		return mv;
	}
	//상세보기
	@RequestMapping(value = "detail.do", method = RequestMethod.GET)
	public String getDetail(BoardDTO boardDTO, Model model) throws Exception{
		boardDTO = qnaService.getDetail(boardDTO);
		model.addAttribute("boardDTO", boardDTO);
		
		return "qna/detail";
	}
	//글작성
	@RequestMapping(value = "add.do", method = RequestMethod.GET)
	public String setAdd() throws Exception{
		return "qna/add";
	}
	@RequestMapping(value = "add.do", method = RequestMethod.POST)
	public ModelAndView setAdd(BoardDTO boardDTO) throws Exception{
		int result = qnaService.setAdd(boardDTO);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:./list.do");
		
		return mv;
	}
	//글업데이트
	@RequestMapping(value = "update.do", method = RequestMethod.GET)
	public ModelAndView setUpdate(BoardDTO boardDTO,ModelAndView mv) throws Exception{
		boardDTO = qnaService.getDetail(boardDTO);
		mv.addObject("boardDTO", boardDTO);
		mv.setViewName("qna/update");
		
		return mv;
	}
	@RequestMapping(value = "update.do", method = RequestMethod.POST)
	public String setUpdate(BoardDTO boardDTO) throws Exception{
		int result = qnaService.setUpdate(boardDTO);
		
		return "redirect: ./detail.do?num="+boardDTO.getNum();
	}
	//글삭제
	@RequestMapping(value = "delete.do", method =RequestMethod.GET)
	public String setDelete(BoardDTO boardDTO) throws Exception{
		int result = qnaService.setDelete(boardDTO);
		
		return "redirect: ./list.do";
	}

}
