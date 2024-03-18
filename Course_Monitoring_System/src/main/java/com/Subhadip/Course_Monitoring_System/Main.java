package com.Subhadip.Course_Monitoring_System;

import java.util.Scanner;

import com.Subhadip.Course_Management_System.Dao.AdminDao;
import com.Subhadip.Course_Management_System.DaoImpl.AdminDaoImpl;
import com.Subhadip.Course_Management_System.Exception.AdminException;
import com.Subhadip.Course_Management_System.Models.Admin;

public class Main {
	private static Scanner sc = new Scanner(System.in);
	
	private static AdminDao adao = new AdminDaoImpl();
	
	public static void main(String[] args) throws AdminException {
		boolean flag = true;
		while(flag) {
			System.out.println("Enter 1 for Admin");
			System.out.println("Enter 2 for Faculty");
			System.out.println("Enter 100 for Exit");
			
			int choice = sc.nextInt();
			
			switch(choice)
			{
			case 1:
				System.out.println("Enter 11 for Log in");
				System.out.println("Enter 12 for Sign up");
				System.out.println("Enter 20 for Exit");
				
				int choice1 = sc.nextInt();
				
				switch(choice1)
				{
				case 11:
					System.out.println("Enter admin username");
					String username = sc.next();
					
					System.out.println("Enter admin password");
					String password = sc.next();
					adao.loginAdmin(username, password);
					
					System.out.println("system");
					break;
					
				case 12:
					System.out.println("Enter admin id");
					int adminId = sc.nextInt();
					
					System.out.println("Enter admin username");
					String adminuserName = sc.next();
					
					System.out.println("Enter admin password");
					String adminpassword = sc.next();
					
					Admin a = new Admin(adminId, adminuserName, adminpassword);
						
					adao.createAdmin(a);
					
					break;
					
				}
			case 3:
				flag = false;
				break;
			}
		}
	}
}
