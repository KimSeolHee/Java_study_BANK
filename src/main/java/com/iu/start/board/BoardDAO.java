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
			boardDTO.setContent(rs.getString(3));
			boardDTO.setWriter(rs.getString(4));
			boardDTO.setWriteDate(rs.getDate(5));
			boardDTO.setHits(rs.getInt(6));
			
			ar.add(boardDTO);
		}
		
		DBConnector.disConnection(rs, st, con);
		return ar;
	}

}
