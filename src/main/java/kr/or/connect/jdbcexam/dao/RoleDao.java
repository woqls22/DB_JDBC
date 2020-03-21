package kr.or.connect.jdbcexam.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.connect.jdbcexam.dto.*;
public class RoleDao {
	private static String dburl = "jdbc:mysql://localhost:7749/connectdb?serverTimezone=Asia/Seoul&useSSL=false";
	private static String dbUser = "connectuser";
	private static String dbpassword = "connect123!@#";
	public Role getRole(int roleId) {
		Role role = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try { // 정상연결시
			Class.forName("com.mysql.cj.jdbc.Driver"); // SQL driver loading.
			conn = DriverManager.getConnection(dburl, dbUser, dbpassword);//connection 객체
			String sql = "select role_id, description from role where role_id = ?"; // ? 부분만 변경됨
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, roleId);
			rs = ps.executeQuery(); //쿼리 수행 요청
			if(rs.next()) { // 결과값이 존재한다면 커서 이동 후 true리턴 없다면 false 리턴
				String description = rs.getString("description");
				int id = rs.getInt("role_id");
				role = new Role(id,description); // role 객체 생성
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return role; // 객체 리턴
	}
	public int addRole(Role role) {
		int insertCount = 0 ;
		Connection conn = null;
		PreparedStatement ps = null;
		//ResultSet rs = null; 삽입문이기때문에 결과값은 필요없음.
		
		try { // 정상연결시
			Class.forName("com.mysql.cj.jdbc.Driver"); // SQL driver loading.
			conn = DriverManager.getConnection(dburl, dbUser, dbpassword);//connection 객체
			String sql = "insert into role(role_id, description) values(?,?)"; // ? 부분만 변경됨
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, role.getRoldId()); // role_id
			ps.setString(2, role.getDescription()); // description
			
			insertCount = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return insertCount; // 객체 리턴
	}
	public List<Role> getRoles(){
		List<Role> list = new ArrayList<>();
		// 정상연결시
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // SQL driver loading.
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String sql = "select description, role_id from role order by role_id desc";
			//finally 구문 없이 close를 자동적으로 수행함.
		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpassword);
				PreparedStatement ps = conn.prepareStatement(sql)) {

			try (ResultSet rs = ps.executeQuery()) {

				while (rs.next()) {
					String description = rs.getString(1);
					int id = rs.getInt("role_id");
					Role role = new Role(id, description);
					list.add(role); // list에 반복할때마다 Role인스턴스를 생성하여 list에 추가한다.
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}
	public int deleteRole(int roleId) {
		int deleteCount = 0 ;
		Connection conn = null;
		PreparedStatement ps = null;
		//ResultSet rs = null; 삭제문이기때문에 결과값은 필요없음.
		
		try { // 정상연결시
			Class.forName("com.mysql.cj.jdbc.Driver"); // SQL driver loading.
			conn = DriverManager.getConnection(dburl, dbUser, dbpassword);//connection 객체
			String sql = "delete from role where role_id = ?"; // ? 부분만 변경됨
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, roleId); // role_id
			
			deleteCount = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return deleteCount; // 객체 리턴
	}
	public int updateRole(Role role) {
		int updateCount = 0;
		
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName( "com.mysql.cj.jdbc.Driver" );
			
			conn = DriverManager.getConnection ( dburl, dbUser, dbpassword );
			
			String sql = "update role set description = ? where role_id = ?";
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, role.getDescription());
			ps.setInt(2,  role.getRoldId());
			
			updateCount = ps.executeUpdate();

		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(ps != null) {
				try {
					ps.close();
				}catch(Exception ex) {}
			} // if
			
			if(conn != null) {
				try {
					conn.close();
				}catch(Exception ex) {}
			} // if
		} // finally
		
		return updateCount;
	}
}
