package com.iu.start.bankAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.iu.start.util.DBConnector;

public class BankAccountDAO {
	
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
