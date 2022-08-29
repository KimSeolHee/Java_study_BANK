package com.iu.start.board.notice;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.start.board.impl.BoardDAO;
import com.iu.start.board.impl.BoardDTO;
import com.iu.start.board.impl.BoardFileDTO;
import com.iu.start.board.impl.BoardService;
import com.iu.start.util.FileManager;
import com.iu.start.util.Pager;

@Service
public class NoticeService implements BoardService {

	@Autowired
	private NoticeDAO noticeDAO;
	
//	@Autowired
//	private ServletContext servletContext;

	@Autowired
	private FileManager fileManager;
	
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
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		return noticeDAO.setUpdate(boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		return noticeDAO.setDelete(boardDTO);
	}
	
	@Override
	public int setAdd(BoardDTO boardDTO, MultipartFile[] files, ServletContext servletContext) throws Exception {
		System.out.println("files"+files);
		int result = noticeDAO.setAdd(boardDTO, files);
		String path ="resources/upload/notice";
		
		for(MultipartFile multipartFile : files) {
			if(multipartFile.isEmpty()) {
				continue;
			}
			String fileName = fileManager.saveFile(path, multipartFile, servletContext);
			System.out.println(fileName);
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			boardFileDTO.setFileName(fileName);
			boardFileDTO.setOriName(multipartFile.getOriginalFilename());
			boardFileDTO.setNum(boardDTO.getNum());
			
			noticeDAO.setAddFile(boardFileDTO);
			
		}

		return result;
	}
}
