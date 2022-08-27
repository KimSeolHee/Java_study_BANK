package com.iu.start.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
	@Autowired
	private BoardDAO boardDAO;
	

	
	public List<NoticeDTO> getList(Pager pager) throws Exception {
		Long totalCount = boardDAO.getCount(pager);
		pager.getNum(totalCount);
		pager.getRowNum();
		return boardDAO.getList(pager);
		}
	
	public NoticeDTO getDetail(NoticeDTO boardDTO) throws Exception {
		return boardDAO.getDetail(boardDTO);
	}
	
	public int setUpdate(NoticeDTO boardDTO) throws Exception {
		return boardDAO.setUpdate(boardDTO);
	}
	
	public int setDelite(NoticeDTO boardDTO) throws Exception {
		return boardDAO.setDelite(boardDTO);
	}
	
	public int setAdd(NoticeDTO boardDTO) throws Exception {
		return boardDAO.setAdd(boardDTO);
	}


}
