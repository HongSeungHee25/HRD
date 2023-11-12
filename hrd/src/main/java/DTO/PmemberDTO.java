package DTO;

import java.sql.Date;

public class PmemberDTO {
	private int custno;			//회원 번호
	private String custname;	//회원 이름
	private String phone;		//회원 전화번호
	private String address;		//회원 주소
	private Date joindate;		//회원가입 일자
	private String grade;			//회원 등급
	private String city;			//회원 거주도시
	
	//커스텀 생성자
	public PmemberDTO(int custno, String custname, String phone, String address, Date joindate, String grade, String city) {
		super();
		this.custno = custno;
		this.custname = custname;
		this.phone = phone;
		this.address = address;
		this.joindate = joindate;
		this.grade = grade;
		this.city = city;
	}

	//기본 생성자
	public PmemberDTO() {
		super();
	}

	//Getter, Setter
	public int getCustno() {
		return custno;
	}

	public void setCustno(int custno) {
		this.custno = custno;
	}

	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getJoindate() {
		return joindate;
	}

	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	
	
}
