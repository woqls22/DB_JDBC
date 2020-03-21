package kr.or.connect.jdbcexam;
import kr.or.connect.jdbcexam.dao.*;
import kr.or.connect.jdbcexam.dto.*;
public class JDBCexam1 {

	public static void main(String[] args) {
		RoleDao dao = new RoleDao();
		Role role = dao.getRole(100);
		System.out.println(role);
	}

}
