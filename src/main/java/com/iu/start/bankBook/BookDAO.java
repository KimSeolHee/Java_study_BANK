package com.iu.start.bankBook;

import java.util.ArrayList;

import com.iu.start.board.impl.CommentDTO;

public interface BookDAO {
	
		public int setUpdate(BankBookDTO bookDTO) throws Exception;
	
		public int setBankBook(BankBookDTO BookDTO) throws Exception;

		public ArrayList<BankBookDTO> getList() throws Exception;
		
		public int setChangeSale(BankBookDTO bookDTO) throws Exception;
		
		public BankBookDTO getDetail(BankBookDTO bookDTO) throws Exception;
		
		public CommentDTO setComment(BankBookCommentDTO bankBookCommentDTO) throws Exception;

}
