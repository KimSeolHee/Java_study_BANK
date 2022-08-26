package com.iu.start.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.start.board.impl.BoardDTO;
import com.iu.start.util.Pager;

@Controller
@RequestMapping(value = "/notice/*")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@ModelAttribute("board")
	public String getBoard() {
		return "Notice";
	}
	
	//글목록
	@RequestMapping(value = "list.do", method = RequestMethod.GET)
	public ModelAndView getList(Pager pager) throws Exception{
		ModelAndView mv = new ModelAndView();
		System.out.println(pager.getPage());
//		System.out.println("Page="+page);
		System.out.println(pager.getKind());
		System.out.println(pager.getSearch());
		
		List<BoardDTO> ar = noticeService.getList(pager);
		mv.addObject("pager", pager);
		mv.addObject("list", ar);
		mv.setViewName("board/list"); 
		
		return mv;
	}
	//상세페이지
	@RequestMapping(value = "detail.do", method = RequestMethod.GET)
	public String getDetail(BoardDTO boardDTO, Model model) throws Exception{
		boardDTO = noticeService.getDetail(boardDTO);
		model.addAttribute("boardDTO", boardDTO);
		return "board/detail";
	}
	//글작성
	@RequestMapping(value = "add.do", method = RequestMethod.GET)
	public String setAdd(Model model) throws Exception{
		return "board/add";
	}
	@RequestMapping(value = "add.do", method = RequestMethod.POST)
	public ModelAndView setAdd(BoardDTO boardDTO, MultipartFile[] files) throws Exception{
		System.out.println(files);
		System.out.println("upload 파일명 : "+files.length);
		
		int result = noticeService.setAdd(boardDTO,files);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:./list.do");
		return mv;
	}
	
	//글 수정
	@RequestMapping(value = "update.do")
	public ModelAndView setUpdate(BoardDTO boardDTO, ModelAndView mv) throws Exception{
		boardDTO = noticeService.getDetail(boardDTO);
		mv.addObject("boardDTO", boardDTO);
		mv.setViewName("board/update");
		
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
