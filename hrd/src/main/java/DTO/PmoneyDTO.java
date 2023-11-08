package DTO;

import java.sql.Date;

public class PmoneyDTO {

	private int custno;				//회원 번호
	private int salenol;			//판매번호
	private int pcost;				//단가
	private int amount;				//수량
	private int price;				//가격
	private String pcode;			//상품 코드
	private Date sdate;				//판매일자
	
	//커스텀 생성자
	public PmoneyDTO(int custno, int salenol, int pcost, int amount, int price, String pcode, Date sdate) {
		super();
		this.custno = custno;
		this.salenol = salenol;
		this.pcost = pcost;
		this.amount = amount;
		this.price = price;
		this.pcode = pcode;
		this.sdate = sdate;
	}
	
	//기본 생성자
	public PmoneyDTO() {
		super();
	}
	
	//Getter, Setter
	public int getCustno() {
		return custno;
	}
	public void setCustno(int custno) {
		this.custno = custno;
	}
	public int getSalenol() {
		return salenol;
	}
	public void setSalenol(int salenol) {
		this.salenol = salenol;
	}
	public int getPcost() {
		return pcost;
	}
	public void setPcost(int pcost) {
		this.pcost = pcost;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public Date getSdate() {
		return sdate;
	}
	public void setSdate(Date sdate) {
		this.sdate = sdate;
	}
	
	
}
