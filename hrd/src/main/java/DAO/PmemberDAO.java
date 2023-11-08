package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.PmemberDTO;
import jdbc.util.OracleUtility;

public class PmemberDAO {

	private static PmemberDAO dao = new PmemberDAO();
	private PmemberDAO() {};
	public static PmemberDAO getPmemberDao() {
		return dao;
	}
	
	//회원 삭제
	public int delete(int custno)throws SQLException{
		String sql = "delete from p_member where custno = ?";	
		Connection conn = OracleUtility.getConnection();		
		PreparedStatement pstmt = conn.prepareStatement(sql);	
		pstmt.setInt(1, custno);
		int result = pstmt.executeUpdate();
		pstmt.close();
		conn.close();
		return result;
	
	}
	
	//회원 정보 업데이트
	public int update(PmemberDTO member) throws SQLException{
		String sql = "update p_member set phone = ?, address = ?, city = ?, grade = ? where custno = ?";
		Connection conn = OracleUtility.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, member.getPhone());
		pstmt.setString(2, member.getAddress());
		pstmt.setString(3, member.getCity());
		pstmt.setString(4, member.getGrade());
		pstmt.setInt(5, member.getCustno());
		
		int result = pstmt.executeUpdate();
		pstmt.close();
		conn.close();
		return result;
	}
	
	//회원 번호 자동 발생
	public int nextSeq() throws SQLException{
		Connection conn = OracleUtility.getConnection();
		String sql = "select max(custno)+1 from p_member";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		int result = 0;
		if(rs.next())
			result = rs.getInt(1);
		return result;
	}
	
	//회원 등록
	public int insert(PmemberDTO member) throws SQLException{
		Connection conn = OracleUtility.getConnection();
		String sql = "insert into p_member values(?,?,?,?,sysdate,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, member.getCustno());
		pstmt.setString(2, member.getCustname());
		pstmt.setString(3, member.getPhone());
		pstmt.setString(4, member.getAddress());
		pstmt.setString(5, member.getGrade());
		pstmt.setString(6, member.getCity());
		
		int result = pstmt.executeUpdate();
		pstmt.close();
		conn.close();
		
		return result;
	}
	
	//전체 회원 정보
	public List<PmemberDTO> selectList() throws SQLException{
		Connection conn = OracleUtility.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from p_member order by custno";
		
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		List<PmemberDTO> list = new ArrayList<>();
		while(rs.next()) {
			PmemberDTO m = new PmemberDTO(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getDate(5),
						rs.getString(6),
						rs.getString(7)
					);
			list.add(m);
		}
		rs.close();
		pstmt.close();
		conn.close();
		return list;
	}
	
	//회원 상세 정보
	public PmemberDTO selectOne(int custno) throws SQLException{
		PmemberDTO vo = null;
		Connection conn = OracleUtility.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from p_member where custno = ?";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, custno);
		rs = pstmt.executeQuery();
		
		if(rs.next())
			vo = new PmemberDTO(
					rs.getInt(1), 
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getDate(5),
					rs.getString(6),
					rs.getString(7)
					);
		rs.close();
		pstmt.close();
		conn.close();
		
		return vo;
	}
	
}
