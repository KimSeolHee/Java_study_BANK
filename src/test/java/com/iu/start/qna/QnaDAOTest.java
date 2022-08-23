package com.iu.start.qna;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.start.MyAbstractTest;
import com.iu.start.board.impl.BoardDTO;
import com.iu.start.board.qna.QnaDAO;
import com.iu.start.board.qna.QnaDTO;

public class QnaDAOTest extends MyAbstractTest{

	@Autowired
	private QnaDAO qnaDAO;
	
	@Test
	public void getList() throws Exception {
		List<BoardDTO> ar= qnaDAO.getList();
		
		assertNotEquals(0, ar.size());
	}
	
	@Test
	public void getDetail() throws Exception {
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setNum(142L);
		boardDTO = qnaDAO.getDetail(boardDTO);
		
		assertNotNull(boardDTO);
	}
	@Test
	public void setAdd() throws Exception {
		QnaDTO qnaDTO = new QnaDTO();
		qnaDTO.setTitle("테스트제목");
		qnaDTO.setContents("잘되는지 확인합니다~");
		qnaDTO.setWriter("tttt");
		int result = qnaDAO.setAdd(qnaDTO);
		
		assertNotEquals(0, result);
	}
	
	@Test
	public void setUpdate() throws Exception {
		QnaDTO qnaDTO = new QnaDTO();
		qnaDTO.setTitle("재입력");
		qnaDTO.setContents("재입력");
		qnaDTO.setNum(142L);
		int result = qnaDAO.setUpdate(qnaDTO);
		
		assertEquals(1, result);
	}
	
	@Test
	public void setDelete() throws Exception {
		QnaDTO qnaDTO = new QnaDTO();
		qnaDTO.setNum(142L);
		int result = qnaDAO.setDelete(qnaDTO);
		
		assertEquals(1, result);
	}
}
