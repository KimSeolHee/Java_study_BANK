package com.iu.start.member;

import java.util.List;

public interface MembersDAO {
	//ȸ������
	public int setJoin(BankMembersDTO bankMembersDTO) throws Exception; 
	//�˻��� �Է�, ���̵� ã��(a, b, c����)
	public List<BankMembersDTO> getSearchById(String search) throws Exception;
}
