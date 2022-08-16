package com.iu.start.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iu.start.util.DBConnector;

public class BoardDAO {
	
	public ArrayList<BoardDTO> getList() throws Exception {
		
		ArrayList<BoardDTO> ar = new ArrayList<BoardDTO>();
		Connection con = DBConnector.getConnection();
		String sql="SELECT * FROM BOARD";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			BoardDTO boardDTO = new BoardDTO();
			boardDTO.setBoardNum(rs.getLong(1));
			boardDTO.setTitle(rs.getString(2));
			boardDTO.setWriter(rs.getString(4));
			boardDTO.setWriteDate(rs.getDate(5));
			boardDTO.setHits(rs.getInt(6));
			
			ar.add(boardDTO);
		}
		
		DBConnector.disConnection(rs, st, con);
		return ar;
	}
	
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		Connection con = DBConnector.getConnection();
		String sql="SELECT * FROM BOARD WHERE BoardNum=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setLong(1, boardDTO.getBoardNum());
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			boardDTO.setBoardNum(rs.getLong("boardNum"));
			boardDTO.setTitle(rs.getString("title"));
			boardDTO.setWriter(rs.getString("writer"));
			boardDTO.setWriteDate(rs.getDate("writeDate"));
			boardDTO.setHits(rs.getInt("hits"));
			boardDTO.setContent(rs.getString("content"));
		}
		
		DBConnector.disConnection(rs, st, con);
		return boardDTO;
	}
	
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		Connection con = DBConnector.getConnection();
		String spl="UPDATE BOARD SET title = ?, CONTENT=? WHERE BOARDNUM=?";
		PreparedStatement st = con.prepareStatement(spl);
		st.setString(1, boardDTO.getTitle());
		st.setString(2, boardDTO.getContent());
		st.setLong(3, boardDTO.getBoardNum());
		int result = st.executeUpdate();
		
		DBConnector.disConnection(st, con);
		return result;
	}
	
	public int setDelite(BoardDTO boardDTO) throws Exception {
		Connection con = DBConnector.getConnection();
		String sql="delete board where boardNum=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setLong(1, boardDTO.getBoardNum());
		int result = st.executeUpdate();
		
		DBConnector.disConnection(st, con);
		
		return result;
	}
	
	public int setAdd(BoardDTO boardDTO) throws Exception {
		Connection con = DBConnector.getConnection();
		String sql="INSERT INTO BOARD VALUES (BOARD_SEQ.NEXTVAL, ?,?, ?, SYSDATE, 0)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1,boardDTO.getTitle());
		st.setString(2, boardDTO.getContent());
		st.setString(3, boardDTO.getWriter());
		int result = st.executeUpdate();
		
		DBConnector.disConnection(st, con);
		
		return result;
	}

}
