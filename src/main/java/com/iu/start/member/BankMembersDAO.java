package com.iu.start.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.start.util.DBConnector;

@Repository
public class BankMembersDAO implements MembersDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.iu.start.member.BankMembersDAO.";
	
	public int setAddFile(MembersFileDTO MembersFileDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"setAddFile", MembersFileDTO);
	}
	
	public BankMembersDTO getMyPage(BankMembersDTO bankMembersDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getMyPage", bankMembersDTO);
	}
	
	public BankMembersDTO getLogin(BankMembersDTO dto) throws Exception{
		
		return sqlSession.selectOne(NAMESPACE+"getLogin", dto);	
	}

	@Override
	public int setJoin(BankMembersDTO bankMembersDTO) throws Exception {
		
		return sqlSession.insert(NAMESPACE+"setJoin", bankMembersDTO);
	}

	@Override
	public List<BankMembersDTO> getSearchById(String search) throws Exception {
		
		return sqlSession.selectList(NAMESPACE+"getSearchById", search);
	}
	
}
