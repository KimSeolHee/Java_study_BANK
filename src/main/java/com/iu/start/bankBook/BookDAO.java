package com.iu.start.bankBook;

import java.util.ArrayList;

public interface BookDAO {
	
	//BankBook Table에 Insert
		//BOOKNUM은 현재시간을 밀리세컨즈로 변환하여 입력
		//BOOKSALE은 무조건 1로 입력
		public int setBankBook(BankBookDTO BookDTO) throws Exception;

		//BankBook 모든 데이터를 조회 최신순으로
		public ArrayList<BankBookDTO> getList() throws Exception;
		
		//Sale 컬럼 수정
		public int setChangeSale(BankBookDTO bookDTO) throws Exception;
		
		//BookNum의 값으로 조회
		public BankBookDTO getDetail(BankBookDTO bookDTO) throws Exception;

}
