package com.iu.start.notice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.start.MyAbstractTest;
import com.iu.start.board.impl.BoardDTO;
import com.iu.start.board.notice.NoticeDAO;
import com.iu.start.board.notice.NoticeDTO;

public class NoticeDAOTest extends MyAbstractTest {
	@Autowired
	private NoticeDAO noticeDAO;
	@Test
	public void getList() throws Exception {
		List<BoardDTO> ar = noticeDAO.getList();
		
		assertNotEquals(0, ar.size());
	}

	@Test
	public void getDetail() throws Exception {
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setNum(65L);
		boardDTO = noticeDAO.getDetail(boardDTO);
		
		assertNotNull(boardDTO);
	}
	@Test
	public void setAdd() throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setTitle("test");
		noticeDTO.setWriter("tttt");
		noticeDTO.setContents("테스트중입니다.");
		int result = noticeDAO.setAdd(noticeDTO);
		
		assertEquals(1, result);
	}
	@Test
	public void setUpdate() throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setTitle("gg?");
		noticeDTO.setContents("ㅇㅇㅇㅇㅇㅇ");
		noticeDTO.setNum(81L);
		
		int result = noticeDAO.setUpdate(noticeDTO);
		assertEquals(1, result);
	}
	
	@Test
	public void setDelete() throws Exception {
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setNum(69L);
		int result = noticeDAO.setDelete(boardDTO);
		
		assertEquals(1, result);
	}

}
