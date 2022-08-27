package com.iu.start.board.impl;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.iu.start.util.Pager;

public interface BoardDAO {
	
	//글의 총갯수
	public Long getCount(Pager pager) throws Exception;
	//글목록
	public abstract List<BoardDTO> getList(Pager pager) throws Exception;
	//글상세보기 abstract생략가능
	public abstract BoardDTO getDetail(BoardDTO boardDTO) throws Exception; 
	//글쓰기
	public abstract int setAdd(BoardDTO boardDTO, MultipartFile[] files) throws Exception;
	//글수정
	public int setUpdate(BoardDTO boardDTO) throws Exception;
	//글삭제
	public int setDelete(BoardDTO boardDTO) throws Exception;

}
