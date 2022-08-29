package com.iu.start.board.qna;

import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.start.board.impl.BoardDTO;
import com.iu.start.board.impl.BoardFileDTO;
import com.iu.start.board.impl.BoardService;
import com.iu.start.util.Pager;

@Service
public class QnaService implements BoardService{

	@Autowired
	private QnaDAO qnaDAO;

	@Autowired
	private ServletContext servletContext;
	
	public int setReply(QnaDTO qnaDTO) throws Exception{
		BoardDTO boardDTO = qnaDAO.getDetail(qnaDTO);
		QnaDTO parent = (QnaDTO)boardDTO;
		qnaDTO.setRef(parent.getRef());
		qnaDTO.setStep(parent.getStep()+1);
		qnaDTO.setDepth(parent.getDepth()+1);
		
		qnaDAO.setStepUpdate(parent);
		int result = qnaDAO.setReplyAdd(qnaDTO);
		
		return result;
	}
	
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		Long totalCount = qnaDAO.getCount(pager);
		pager.getNum(totalCount);
		pager.getRowNum();
//		Long perPage=10L;
//		Long startRow = (page*perPage)-(perPage-1);
//		Long lastRow = page*perPage;
//		Map<String, Long> map = new HashMap<String, Long>();
//		map.put("startRow", startRow);
//		map.put("lastRow", lastRow);
		
		return qnaDAO.getList(pager);
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		return qnaDAO.getDetail(boardDTO);
	}

	@Override
	public int setAdd(BoardDTO boardDTO, MultipartFile[] files, ServletContext servletContext) throws Exception {
		int result = qnaDAO.setAdd(boardDTO,files);
		
		String realPath = servletContext.getRealPath("resources/upload/qna");
		System.out.println(realPath);
		File file = new File(realPath);
		if(!file.exists()) {
			file.mkdirs();
		}
		for(MultipartFile mf : files) {
			if(mf.isEmpty()) {
				continue;
			}
			String fileName = UUID.randomUUID().toString();
			fileName = fileName+"_"+mf.getOriginalFilename();
			
			file = new File(file, fileName);
			mf.transferTo(file);
			
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			boardFileDTO.setFileName(fileName);
			boardFileDTO.setOriName(mf.getOriginalFilename());
			boardFileDTO.setNum(225L);//XXXXX
			
			int count = qnaDAO.setAddFile(boardFileDTO);
			System.out.println(count);
			
		}
		
		return result; 
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		return qnaDAO.setUpdate(boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		return qnaDAO.setDelete(boardDTO);
	}
	
}
