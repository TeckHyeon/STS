package daodto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDao2 {

	private String url = "jdbc:mysql://localhost:3306/testdb?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
	private String uid = "testuser";
	private String upw = "1234";

	public MemberDao2() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public ArrayList<MemberDto> memberSelect() {

		ArrayList<MemberDto> members = new ArrayList<MemberDto>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(url, uid, upw);
			String sql = "SELECT * FROM member ";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString("id");
				String passwd = rs.getString("passwd");
				String name = rs.getString("name");

				MemberDto dto = new MemberDto(id, passwd, name);
				members.add(dto);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}

		}
		return members;
	}

	public int memberInsert(MemberDto member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int resultCount = 0;
		String id = member.getId();
		String passwd = member.getPasswd();
		String name = member.getName();
		
		String sql = "INSERT INTO Member(id, passwd, name)";
		sql += "VALUES(?,?,?)";
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, passwd);
			pstmt.setString(3, name);
			resultCount = pstmt.executeUpdate();

		} catch (SQLException se) {
			System.out.println(se.getMessage());
			se.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				System.out.println(se.getMessage());
				se.printStackTrace();
			}
		}

		return resultCount;
	}

	public int memberUpdate(MemberDto member) {
		int resultCount = 0;
		String sql = "UPDATE member SET ";
		sql += "id = ? , passwd = ? , name = ? ";
		sql += "WHERE id = ? ";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String id = member.getId();
		String passwd = member.getPasswd();
		String name = member.getName();
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, passwd);
			pstmt.setString(3, name);
			pstmt.setString(4, id);
			resultCount = pstmt.executeUpdate();
		}
		catch (SQLException se) {
			se.printStackTrace();
		}
		finally {
			try {
				if (pstmt != null) { pstmt.close(); }
				if (conn != null) { conn.close(); }
			}
			catch (SQLException se) {
				se.printStackTrace();
			}
		}
		
		return resultCount;
	}

	public int memberDelete(String id) {
		int resultCount = 0;
		String sql = "DELETE FROM member ";
		sql += "WHERE id = ? ";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			resultCount = pstmt.executeUpdate();
		}
		catch (SQLException se) {
			se.printStackTrace();
		}
		finally {
			try {
				if (pstmt != null) { pstmt.close(); }
				if (conn != null) { conn.close(); }
			}
			catch (SQLException se) {
				
			}
		}
		
		return resultCount;
	}
}
