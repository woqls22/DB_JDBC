package kr.or.connect.jdbcexam;
import java.util.*;

import kr.or.connect.jdbcexam.dao.*;
import kr.or.connect.jdbcexam.dto.*;
public class jdbcexam4 {

	public static void main(String[] args) {
		int roleId = 500;
		RoleDao dao = new RoleDao();
		int deleteCount = dao.deleteRole(roleId);
		System.out.println(deleteCount);
		System.out.println("AFTER ====");
		List<Role> list = dao.getRoles();
		for(Role role : list) {
			System.out.println(role);
		}
	}

}
