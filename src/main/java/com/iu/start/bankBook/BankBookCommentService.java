package com.iu.start.bankBook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.start.util.CommentPager;

@Service
public class BankBookCommentService {

	@Autowired
	private BankBookCommentDAO bankBookCommentDAO;
	
	public int setCommentAdd(BankBookCommentDTO bankBookCommentDTO)throws Exception{
		return bankBookCommentDAO.setCommentAdd(bankBookCommentDTO);
	}
	
	public List<BankBookCommentDTO> getComment(CommentPager commentPager)throws Exception{
//		Long totalCount = bankBookCommentDAO.getCount(commentPager);
		commentPager.getRowNum();
//		commentPager.getNum(totalCount);
		return bankBookCommentDAO.getComment(commentPager);
	}
}
