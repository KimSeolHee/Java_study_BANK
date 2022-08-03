package com.iu.start.bankBook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iu.start.util.DBConnector;

public class BankBookDAO implements BookDAO{

	@Override
	public int setBankBook(BankBookDTO BookDTO) throws Exception {

		Connection con = DBConnector.getConnection();
		String sql = "INSERT INTO BANKBOOK VALUES (?,?,?,1)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setLong(1, BookDTO.getBookNum());
		st.setString(2, BookDTO.getBookName());
		st.setDouble(3, BookDTO.getBookRate());
		
		int result = st.executeUpdate();
		
		DBConnector.disConnection(st, con);
		return result;
	}

	@Override
	public ArrayList<BankBookDTO> getList() throws Exception {
		ArrayList<BankBookDTO> ar = new ArrayList<BankBookDTO>();

		Connection con = DBConnector.getConnection();
		String sql = "SELECT * FROM BANKBOOK ORDER BY BOOKNUM DESC";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			BankBookDTO dto = new BankBookDTO();
			dto.setBookNum(rs.getLong(1));
			dto.setBookName(rs.getString(2)); 
			dto.setBookRate(rs.getDouble(3)); 
			dto.setBookSale(rs.getInt(4)); 
			ar.add(dto);
		}
		DBConnector.disConnection(rs, st, con);
		return ar;
	}

	@Override
	public int setChangeSale(BankBookDTO bookDTO) throws Exception {
		Connection con = DBConnector.getConnection();
		String sql = "UPDATE BANKBOOK SET BOOKSALE = ? WHERE BOOKNUM = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, bookDTO.getBookSale());
		st.setLong(2, bookDTO.getBookNum());
		int result = st.executeUpdate();
		DBConnector.disConnection(st, con);
		return result;
	}

	@Override
	public BankBookDTO getDetail(BankBookDTO bookDTO) throws Exception {
		Connection con = DBConnector.getConnection();
		String sql ="SELECT * FROM BANKBOOK WHERE BOOKNUM = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setLong(1, bookDTO.getBookNum());
		ResultSet rs = st.executeQuery();
		BankBookDTO dto = null;
		if(rs.next()) {
			dto = new BankBookDTO();
			dto.setBookNum(rs.getLong("bookNum"));
			dto.setBookName(rs.getNString("bookName"));
			dto.setBookSale(rs.getInt("bookSale"));
			dto.setBookRate(rs.getDouble("bookRate"));	
		}
		DBConnector.disConnection(rs, st, con);
		return dto;
	}

}
