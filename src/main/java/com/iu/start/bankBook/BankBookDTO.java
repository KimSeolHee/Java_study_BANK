package com.iu.start.bankBook;

import java.sql.Clob;
import java.util.List;

import com.iu.start.bankAccount.BankAccountDTO;

public class BankBookDTO {
	private Long bookNum;
	private String bookName;
	private Double bookRate;
	private Integer bookSale;
	private Clob bookContents;
	private List<BankAccountDTO> bankAccountDTOs;
	
	
	public Long getBookNum() {
		return bookNum;
	}
	public void setBookNum(Long bookNum) {
		this.bookNum = bookNum;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public Double getBookRate() {
		return bookRate;
	}
	public void setBookRate(Double bookRate) {
		this.bookRate = bookRate;
	}
	public Integer getBookSale() {
		return bookSale;
	}
	public void setBookSale(Integer bookSale) {
		this.bookSale = bookSale;
	}
	public Clob getBookContents() {
		return bookContents;
	}
	public void setBookContents(Clob bookContents) {
		this.bookContents = bookContents;
	}
	public List<BankAccountDTO> getBankAccountDTOs() {
		return bankAccountDTOs;
	}
	public void setBankAccountDTOs(List<BankAccountDTO> bankAccountDTOs) {
		this.bankAccountDTOs = bankAccountDTOs;
	}
	
	
}
