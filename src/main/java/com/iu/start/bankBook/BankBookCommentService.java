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
		commentPager.getRowNum();
		Long totalCount = bankBookCommentDAO.getCommentListTotalCount(commentPager);
		commentPager.getNum(totalCount);
		return bankBookCommentDAO.getComment(commentPager);
	}
	
	
	
}
