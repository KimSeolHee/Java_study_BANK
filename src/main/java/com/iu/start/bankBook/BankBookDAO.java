package com.iu.start.bankBook;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class BankBookDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.iu.start.bankBook.BankBookDAO.";
	
	public int setUpdate(BankBookDTO bookDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"setUpdate", bookDTO);
	}
	
	public int setBankBook(BankBookDTO BookDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"setBankBook", BookDTO);
	}
	
	public List<BankBookDTO> getList() throws Exception{
		return sqlSession.selectList(NAMESPACE+"getList");
	}
	
	public int setChangeSale(BankBookDTO bookDTO) throws Exception{
		return sqlSession.update(NAMESPACE+"setChangeSale", bookDTO);
	}
	
	public BankBookDTO getDetail(BankBookDTO bookDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getDetail", bookDTO);
	}
	
	public int setDelete(BankBookDTO dto) throws Exception{
		return sqlSession.delete(NAMESPACE+"setDelete", dto);
	}
	
}