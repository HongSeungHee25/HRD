package DTO;

public class PsaleDTO {
	
	private int custno;
	private String custname;
	private String agrade;
	private int psum;
	
	public PsaleDTO() {
	}
	//생성자
	public PsaleDTO(int custno, String custname, String agrade, int psum) {
		super();
		this.custno = custno;
		this.custname = custname;
		this.agrade = agrade;
		this.psum = psum;
	}
	//Getter, Setter
	public String getAgrade() {
		return agrade;
	}
	public int getCustno() {
		return custno;
	}
	public String getCustname() {
		return custname;
	}
	public int getPsum() {
		return psum;
	}
	public void setCustno(int custno) {
		this.custno = custno;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public void setPsum(int psum) {
		this.psum = psum;
	}
	
	
	
}