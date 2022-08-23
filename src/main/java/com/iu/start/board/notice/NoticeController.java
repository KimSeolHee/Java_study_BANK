package com.iu.start.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.start.board.impl.BoardDTO;

@Controller
@RequestMapping(value = "/notice/*")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	//글목록
	@RequestMapping(value = "list.do", method = RequestMethod.GET)
	public ModelAndView getList() throws Exception{
		List<BoardDTO> ar = noticeService.getList();
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", ar);
		mv.setViewName("notice/list"); 
		
		return mv;
	}
	//상세페이지
	@RequestMapping(value = "detail.do", method = RequestMethod.GET)
	public String getDetail(BoardDTO boardDTO, Model model) throws Exception{
		boardDTO = noticeService.getDetail(boardDTO);
		model.addAttribute("boardDTO", boardDTO);
		return "notice/detail";
	}
	//글작성
	@RequestMapping(value = "add.do", method = RequestMethod.GET)
	public String setAdd() throws Exception{
		return "notice/add";
	}
	@RequestMapping(value = "add.do", method = RequestMethod.POST)
	public ModelAndView setAdd(BoardDTO boardDTO) throws Exception{
		int result = noticeService.setAdd(boardDTO);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:./list.do");
		return mv;
	}
	
	//글 수정
	@RequestMapping(value = "update.do")
	public ModelAndView setUpdate(BoardDTO boardDTO, ModelAndView mv) throws Exception{
		boardDTO = noticeService.getDetail(boardDTO);
		mv.addObject("boardDTO", boardDTO);
		mv.setViewName("notice/update");
		
		return mv;
	}
	@RequestMapping(value = "update.do", method = RequestMethod.POST)
	public String setUpdate(BoardDTO boardDTO) throws Exception{
		int result = noticeService.setUpdate(boardDTO);
		
		return "redirect: ./detail.do?num="+boardDTO.getNum();
	}
	//글삭제
	@RequestMapping(value = "delete.do", method = RequestMethod.GET)
	public String setDelete(BoardDTO boardDTO) throws Exception{
		int result = noticeService.setDelete(boardDTO);
		return "redirect:./list.do";
	}

}
