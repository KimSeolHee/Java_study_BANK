package com.iu.start.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iu.start.util.DBConnector;

public class BankMembersDAO implements MembersDAO {

	@Override
	public int setJoin(BankMembersDTO bankMembersDTO) throws Exception {
		
		Connection con = DBConnector.getConnection();
		String sql = "INSERT INTO BANKMEMBERS VALUES (?,?,?,?,?) ";
		PreparedStatement st = con.prepareStatement(sql);

		st.setString(1, bankMembersDTO.getId());
		st.setString(2, bankMembersDTO.getPw());
		st.setString(3, bankMembersDTO.getName());
		st.setString(4, bankMembersDTO.getEmail());
		st.setString(5, bankMembersDTO.getPhone());
	
		int result = st.executeUpdate();
		
		DBConnector.disConnection(st, con);
		return result;
	}

	@Override
	public ArrayList<BankMembersDTO> getSearchById(String search) throws Exception {
		ArrayList<BankMembersDTO> ar = new ArrayList<BankMembersDTO>();
		Connection con = DBConnector.getConnection();
		String sql = "SELECT * FROM BANKMEMBERS WHERE ID like ? ORDER BY ID ASC";  //'%'||?||'%'
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, "%"+search+"%");
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			BankMembersDTO dto = new BankMembersDTO();
			dto.setId(rs.getString("id"));
			dto.setPw(rs.getString("pw"));
			dto.setName(rs.getString("name"));
			dto.setEmail(rs.getString("Email"));
			dto.setPhone(rs.getString("phone"));
			
			ar.add(dto);
		}
	
		DBConnector.disConnection(rs, st, con);
		
		return ar;
	}
}
