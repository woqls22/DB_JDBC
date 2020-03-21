package kr.or.connect.jdbcexam;
import java.util.List;

import kr.or.connect.jdbcexam.dao.*;
import kr.or.connect.jdbcexam.dto.*;
public class JDBCexam2 {

	public static void main(String[] args) {
		int roleId = 10;
		String description = "DESCENT";
		Role role = new Role(roleId, description);
		RoleDao dao = new RoleDao();
		int insertCount = dao.addRole(role);
		System.out.println(insertCount);
		print_table();
	}
	public static void print_table() {
		RoleDao dao = new RoleDao();
		System.out.println("print ====");
		List<Role> list = dao.getRoles();
		for(Role i : list) {
			System.out.println(i);
		}
	}
}
