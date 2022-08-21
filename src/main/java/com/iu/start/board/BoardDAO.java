package com.iu.start.board;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.start.util.DBConnector;

@Repository
public class BoardDAO {
	
	public ArrayList<BoardDTO> getList() throws Exception {
		
		ArrayList<BoardDTO> ar = new ArrayList<BoardDTO>();
		Connection con = DBConnector.getConnection();
		String sql="SELECT * FROM BOARD";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			BoardDTO boardDTO = new BoardDTO();
			boardDTO.setNum(rs.getLong(1));
			boardDTO.setTitle(rs.getString(2));
			boardDTO.setWriter(rs.getString(4));
			boardDTO.setRegDate(rs.getDate(5));
			boardDTO.setHit(rs.getInt(6));
			
			ar.add(boardDTO);
		}
		
		DBConnector.disConnection(rs, st, con);
		return ar;
	}
	
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		Connection con = DBConnector.getConnection();
		String sql="SELECT * FROM BOARD WHERE num=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setLong(1, boardDTO.getNum());
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			boardDTO.setNum(rs.getLong("num"));
			boardDTO.setTitle(rs.getString("title"));
			boardDTO.setWriter(rs.getString("writer"));
			boardDTO.setRegDate(rs.getDate("regDate"));
			boardDTO.setHit(rs.getInt("hit"));
			boardDTO.setContents(rs.getClob("contents"));
		}
		
		DBConnector.disConnection(rs, st, con);
		return boardDTO;
	}
	
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		Connection con = DBConnector.getConnection();
		String spl="UPDATE BOARD SET title = ?, CONTENTs=TO_CLOB() WHERE NUM=?";
		PreparedStatement st = con.prepareStatement(spl);
		st.setString(1, boardDTO.getTitle());
		st.setClob(2, boardDTO.getContents());
		st.setLong(3, boardDTO.getNum());
		int result = st.executeUpdate();
		
		DBConnector.disConnection(st, con);
		return result;
	}
	
	public int setDelite(BoardDTO boardDTO) throws Exception {
		Connection con = DBConnector.getConnection();
		String sql="delete board where num=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setLong(1, boardDTO.getNum());
		int result = st.executeUpdate();
		
		DBConnector.disConnection(st, con);
		
		return result;
	}
	
	public int setAdd(BoardDTO boardDTO) throws Exception {
		Connection con = DBConnector.getConnection();
		String sql="INSERT INTO BOARD VALUES (BOARD_SEQ.NEXTVAL, ?,TO_CLOB(), ?, SYSDATE, 0)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1,boardDTO.getTitle());
		st.setClob(2, boardDTO.getContents());
		st.setString(3, boardDTO.getWriter());
		int result = st.executeUpdate();
		
		DBConnector.disConnection(st, con);
		
		return result;
	}

}
