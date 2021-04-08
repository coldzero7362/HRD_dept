package departmemt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class departDAO {
	private static departDAO instance = new departDAO();
	
	public static departDAO getInstance() {
		return instance;
	}
	
	private Connection getConnection() throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","hr","hr");
		return conn;
	}
	public ArrayList<departVO> selectDeptID(int num){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<departVO> list = new ArrayList<departVO>();
		departVO vo = new departVO();
		
		try {
			conn = getConnection();
			String sql = "select * from personnel where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				
				vo.setId(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setDept(rs.getString(3));
				vo.setPosition(rs.getString(4));
				vo.setDuty(rs.getString(5));
				vo.setPhone(rs.getString(6));
				
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public ArrayList<departVO> selectDeptDepart(String dept){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<departVO> list = new ArrayList<departVO>();
		
		try {
			conn = getConnection();
			String sql = "select * from personnel where dept = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dept);;
			rs = pstmt.executeQuery();
			while(rs.next()) {
				departVO vo = new departVO();
				vo.setId(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setDept(rs.getString(3));
				vo.setPosition(rs.getString(4));
				vo.setDuty(rs.getString(5));
				vo.setPhone(rs.getString(6));
				
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public int insertDept(departVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int num = 0;
		try {
			conn = getConnection();
			String sql = "insert into personnel values(?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			int d =  vo.getPosition().length();
			System.out.println(d);
			
			pstmt.setInt(1,vo.getId());
			pstmt.setString(2,vo.getName());
			pstmt.setString(3,vo.getDept());
			pstmt.setString(4, vo.getPosition());
			pstmt.setString(5, vo.getDuty());
			pstmt.setString(6,vo.getPhone());
			
			num = pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}
	public departVO getADept(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int num = 0;
		departVO vo = new departVO();
		try {
			conn = getConnection();
			String sql = "select * from personnel where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				
				vo.setId(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setDept(rs.getString(3));
				vo.setPosition(rs.getString(4));
				vo.setDuty(rs.getString(5));
				vo.setPhone(rs.getString(6));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}
	
	public int updateDept(departVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int num = 0;
		try {
			conn = getConnection();
			String sql = "update PERSONNEL set id=?,name=?,dept=?,position=?,duty=?,phone=? where id = ?";
			pstmt = conn.prepareStatement(sql);
			System.out.println(vo.getId());
			pstmt.setInt(1,vo.getId());
			pstmt.setString(2,vo.getName());
			pstmt.setString(3,vo.getDept());
			pstmt.setString(4, vo.getPosition());
			pstmt.setString(5, vo.getDuty());
			pstmt.setString(6,vo.getPhone());
			pstmt.setInt(7,vo.getId());
			
			num = pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}

	public int deleteDept(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int num = 0;
		System.out.println("ddd");
		try {
			conn = getConnection();
			String sql = "delete PERSONNEL where id=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1,id);
			
			num = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}
	public boolean checkDept(int id,String name){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int dbId = 0;
		String dbName = "";
		boolean rst = false;
		try {
			conn = getConnection();
			String sql = "select id,name from personnel where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dbId = rs.getInt(1);
				dbName = rs.getString(2);
			}
			if(dbId == id && dbName.equals(name)) {
				rst = true;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rst;
		
	}

	
	
}
