package com.iu.start.bankAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.start.member.BankMembersDTO;
import com.iu.start.util.DBConnector;
@Repository
public class BankAccountDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.iu.start.bankAccount.BankAccountDAO.";
	
	public List<BankAccountDTO> getListByUserName(BankMembersDTO bankMembersDTO)throws Exception{
		return sqlSession.selectList(NAMESPACE+"getListByUserName", bankMembersDTO);
	}
	
	public int add(BankAccountDTO dto) throws Exception {
		Connection con = DBConnector.getConnection();
		String sql = "insert into bankaccount values (ACCOUNT_SEQ.NEXTVAL, ?, ?, sysdate)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, dto.getUserId());
		st.setLong(2, dto.getBookNum());
		
		int result = st.executeUpdate();
		
		DBConnector.disConnection(st, con);
		
		return result;
	}

}
