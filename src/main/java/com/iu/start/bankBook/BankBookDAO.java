package com.iu.start.bankBook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.iu.start.util.DBConnector;

@Repository
public class BankBookDAO implements BookDAO{
	
	@Override
	public int setUpdate(BankBookDTO bookDTO) throws Exception {
		
		//DB연결
		Connection con = DBConnector.getConnection();
		//sql문 작성
		String sql = "update bankbook set bookName=?, bookRate=? where bookNum = ?";
		//미리준비
		PreparedStatement st = con.prepareStatement(sql);
		//?문처리
		st.setString(1, bookDTO.getBookName());
		st.setDouble(2, bookDTO.getBookRate());
		st.setLong(3, bookDTO.getBookNum());
		//결과 리턴(숫자로 업데이트 항목 확인)
		int result = 0;
		result = st.executeUpdate();
		
		DBConnector.disConnection(st, con);
		return result;
	}

	@Override
	public int setBankBook(BankBookDTO BookDTO) throws Exception {

		Connection con = DBConnector.getConnection();
		String sql = "INSERT INTO BANKBOOK VALUES (?,?,?,1)";
		PreparedStatement st = con.prepareStatement(sql);
		Long millis = System.currentTimeMillis();
		st.setLong(1, millis);
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
	
	public int setDelete(BankBookDTO dto) throws Exception {
		
		Connection con = DBConnector.getConnection();
		String sql = "delete bankbook where bookNum = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setLong(1, dto.getBookNum());
		int result = st.executeUpdate();
		
		DBConnector.disConnection(st, con);
	
		return result;
	}

}
