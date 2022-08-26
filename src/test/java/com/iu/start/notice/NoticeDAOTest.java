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
	public void getCount() throws Exception{
//		long result = noticeDAO.getCount();
//		System.out.println("result : "+result);
//		assertEquals(114L, result);
//		
//		Long totalCount= noticeDAO.getCount();
//		Long num = (long) Math.ceil((double)totalCount/10);
//		System.out.println(num);
		//15 / 5 / 3
		//20 / 5 / 4
		//22 / 5 / 5
		Long totalPage = 26L;
		Long perBlock = 5L;
		Long totalBlock = (long) Math.ceil((double)totalPage/perBlock);
		System.out.println(totalBlock);
		
	}
//	@Test
//	public void getList() throws Exception {
//		List<BoardDTO> ar = noticeDAO.getList();
//		
//		assertNotEquals(0, ar.size());
//	}
//
//	@Test
//	public void getDetail() throws Exception {
//		BoardDTO boardDTO = new BoardDTO();
//		boardDTO.setNum(65L);
//		boardDTO = noticeDAO.getDetail(boardDTO);
//		
//		assertNotNull(boardDTO);
//	}
//	@Test
//	public void setAdd() throws Exception {
//		for(int i=0;i<100;i++) {
//			NoticeDTO noticeDTO = new NoticeDTO();
//			noticeDTO.setTitle("Title"+i);
//			noticeDTO.setWriter("tttt");
//			noticeDTO.setContents("테스트중입니다."+i);
//			int result = noticeDAO.setAdd(noticeDTO);	
//			
//			if(i%10==0) {
//				Thread.sleep(500);
//			}
//		}
//		
//		System.out.println("Finish");
//	}
//	@Test
//	public void setUpdate() throws Exception {
//		NoticeDTO noticeDTO = new NoticeDTO();
//		noticeDTO.setTitle("gg?");
//		noticeDTO.setContents("ㅇㅇㅇㅇㅇㅇ");
//		noticeDTO.setNum(81L);
//		
//		int result = noticeDAO.setUpdate(noticeDTO);
//		assertEquals(1, result);
//	}
//	
//	@Test
//	public void setDelete() throws Exception {
//		BoardDTO boardDTO = new BoardDTO();
//		boardDTO.setNum(69L);
//		int result = noticeDAO.setDelete(boardDTO);
//		
//		assertEquals(1, result);
//	}

}
