package com.iu.start.member;

import java.util.ArrayList;

public interface MembersDAO {
	//회원가입
	public int setJoin(BankMembersDTO bankMembersDTO) throws Exception; 
	//검색어 입력, 아이디 찾기(a, b, c포함)
	public ArrayList<BankMembersDTO> getSearchById(String search) throws Exception;
}
