package kr.or.connect.jdbcexam;
import java.util.*;

import kr.or.connect.jdbcexam.dao.*;
import kr.or.connect.jdbcexam.dto.*;
public class jdbcexam5 {
	public static void print_table() {
		RoleDao dao = new RoleDao();
		System.out.println("--------------------------");
		List<Role> list = dao.getRoles();
		for(Role i : list) {
			System.out.println(i);
		}
		System.out.println("--------------------------");
	}
	public static void main(String[] args) {
		char menu = '0';
		Role role = new Role();
		RoleDao dao = new RoleDao();
		Scanner scan = new Scanner(System.in);
		System.out.println("DB_MANIPULATION : ROLE TABLE");
		while(menu !='Q' && menu !='q') {
			System.out.println("--------------------------");
			System.out.println("1. PRINT_ALL_RECORDS");
			System.out.println("2. ADD_RECORDS");
			System.out.println("3. DELETE_RECORDS");
			System.out.println("4. UPDATE_RECORDS");
			System.out.println("Q. EXIT");
			System.out.println("--------------------------");
			System.out.print("SELECT MENU : ");
			menu=scan.next().charAt(0);
			if(menu == '1') {
				print_table();
			}
			else if(menu == '2') {
				// ADD_RECORDS
				System.out.print("ENTER THE ROLE_ID, DESCRIPTION : ");
				int roleId = scan.nextInt();
				String description = scan.next();
				role.setDescription(description);
				role.setRoldId(roleId);
				int insertCount = dao.addRole(role);
				if(insertCount == 1) {
					System.out.println("add Complete");
				}
				else {
					System.out.println("ERROR OUCCURED!");
				}
			}
			else if(menu == '3') {
				// DELETE_RECORDS
				System.out.print("ENTER THE ROLE_ID : ");
				int roleId = scan.nextInt();
				int deleteCount = dao.deleteRole(roleId);
				if(deleteCount == 1) {
					System.out.println("delete Complete");
				}
				else {
					System.out.println("ERROR OUCCURED!");
				}
			}
			else if(menu == '4') {
				// UPDATE_RECORDS
				System.out.print("ENTER THE ROLE_ID, DESCRIPTION : ");
				int roleId = scan.nextInt();
				String description = scan.next();
				role.setDescription(description);
				role.setRoldId(roleId);
				int updateCount = dao.updateRole(role);
				if(updateCount == 1) {
					System.out.println("update Complete");
				}
				else {
					System.out.println("ERROR OUCCURED!");
				}
			}
			else if(menu == 'q'||menu == 'Q') {
				System.out.println("TERMINATE THIS PROGRAM");
				break;
			}
			else {
				System.out.println("INPUT INCORRECT //");
			}
		}
	}
}
