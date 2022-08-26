package com.iu.start.board.notice;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.start.board.impl.BoardDTO;
import com.iu.start.board.impl.BoardService;
import com.iu.start.util.Pager;

@Service
public class NoticeService implements BoardService {

	@Autowired
	private NoticeDAO noticeDAO;
	
	@Autowired
	private ServletContext servletContext;
	
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		Long totalCount = noticeDAO.getCount(pager);
		pager.getNum(totalCount);
		pager.getRowNum();
		//page				startRow				lastRow
		//1					1							15
		//2					16							30
		//3					31							45
		//page				(page*10)-9			page*10
		//한페이지에 출력할 목록의 갯수 
//		Long perPage=10L; 
//		Long startRow = (page*perPage)-(perPage-1);
//		Long lastRow = page*perPage;
		//Long startRow = (perPage-1)*page+1;
		//Long lastRow = page*perPage;			
//		Map<String, Long> map = new HashMap<String, Long>();
//		map.put("startRow", startRow);
//		map.put("lastRow", lastRow);
		
		/****
		 * 글의 갯수가 총 80개
		 * 1. 글의 총 갯수
		 * 2. 글의 총 갯수를 이용하여 총 페이지 수 구하기
		 * 3. 페이지의 수를 단위로 묶어야함 totalBlock의 갯수
		 * perBlock : 한페이지에 출력할 번호의 수(5개씩)
		 * 4. 페이지로 현재 Block 번호 찾기
		 * 5. 현재블록번호로 시작번호와 끝번호를 알아오기
		 * page=i curBlock = (page/5)올림
		 * curBlock			startNum			lastNum
		 * 1						1							5
		 * 2						6							10
		 * 3						11							15			
		 * */
//		Long totalCount= noticeDAO.getCount();
//		Long totalPage = (long) Math.ceil((double)totalCount/perPage);
//		Long perBlock = 5L;
//		Long totalBlock = (long) Math.ceil((double)totalPage/perBlock);
//		Long curBlock = (long) Math.ceil((double)page/5);
//		Long startNum = (curBlock * 5) - 4;
//		Long lastNum = curBlock * 5;
		
		return noticeDAO.getList(pager);
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		return noticeDAO.getDetail(boardDTO);
	}

	@Override
	public int setAdd(BoardDTO boardDTO) throws Exception {
		return noticeDAO.setAdd(boardDTO);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		return noticeDAO.setUpdate(boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		return noticeDAO.setDelete(boardDTO);
	}
	public int setAdd(BoardDTO boardDTO, MultipartFile[] files) throws Exception {
		//1. 실제 경로
		String realPath = servletContext.getRealPath("resources/upload/notice");
		System.out.println(realPath);
		
		//2.폴더확인
		File file = new File(realPath);
		if(!file.exists()) {
			file.mkdirs();
		}
		
		//3. 저장할 파일명을 만드는 데 중복되지 않게 만들기
		for(MultipartFile mf:files) {
			//파일 비어있으면 올리기
			if(mf.isEmpty()) {
				continue;
			}
			//저장하는 코드
			String fileName = UUID.randomUUID().toString();
			fileName = fileName+"_"+mf.getOriginalFilename();
			file = new File(file, fileName);
			
			mf.transferTo(file);
			
		}
		
//		return noticeDAO.setAdd(boardDTO);
		return 0;
	}
}
