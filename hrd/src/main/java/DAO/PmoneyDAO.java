package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.PsaleDTO;
import jdbc.util.OracleUtility;

public class PmoneyDAO {

	private static PmoneyDAO dao = new PmoneyDAO();
	private PmoneyDAO() {}
	public static PmoneyDAO getPmoneyDao() {
		return dao;
	}
	
	public List<PsaleDTO> selectTotal() throws SQLException{
		String sql = "select mt.custno, custname, decode(grade, 'A','VIP', 'B', '일반', 'C', '직원') agrade, psum\r\n"
				+ "				from p_member mt\r\n"
				+ "				join(\r\n"
				+ "				select custno, sum(price) psum\r\n"
				+ "				from p_money group by custno\r\n"
				+ "				)sale \r\n"
				+ "				on mt.custno = sale.custno\r\n"
				+ "				order by psum DESC";
		
		List<PsaleDTO> list = new ArrayList<PsaleDTO>();
		Connection conn = OracleUtility.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			list.add(new PsaleDTO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4)));
		}
		
		return list;
	}
	
}
