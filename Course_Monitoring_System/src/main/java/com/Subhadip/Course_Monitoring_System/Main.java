package com.Subhadip.Course_Monitoring_System;

import java.util.Scanner;

import com.Subhadip.Course_Management_System.Dao.AdminDao;
import com.Subhadip.Course_Management_System.DaoImpl.AdminDaoImpl;
import com.Subhadip.Course_Management_System.Exception.AdminException;
import com.Subhadip.Course_Management_System.Models.Admin;
import com.Subhadip.Course_Management_System.Models.Course;

public class Main {
	private static Scanner sc = new Scanner(System.in);
	
	private static AdminDao adao = new AdminDaoImpl();
	
	public static void main(String[] args) throws AdminException {
		boolean flag = true;
		while(flag) {
			System.out.println("Enter 1 for Admin");
			System.out.println("Enter 2 for Faculty");
			System.out.println("Enter 10 for Exit");
			
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
					
					System.out.println("Enter 51 for create course");
					System.out.println("Enter 52 for update course");
					System.out.println("Enter 53 for view course");
					System.out.println("Enter 100 for exit");
					
					int choice2 = sc.nextInt();
					
					switch(choice2)
					{
					case 51:
						System.out.println("Enter course id");
						int courseId = sc.nextInt();
						
						System.out.println("Enter course name");
						String courseName = sc.next();
						
						System.out.println("Enter course fees");
						int courseFees = sc.nextInt();
						
						System.out.println("Enter course description");
						String courseDescription = sc.next();
						
						Course c = new Course(courseId, courseName, courseFees, courseDescription);
							
						adao.createCourse(c);
						break;
					case 52:
						System.out.println("Enter course id");
						int id = sc.nextInt();
						
						System.out.println("Enter new course name");
						String name = sc.next();
						
						System.out.println("Enter new course fees");
						int fees = sc.nextInt();
						
						System.out.println("Enter new course description");
						String desc = sc.next();
							
						adao.updateCourse(id, name, fees, desc);
						break;
					case 53:
						System.out.println("All details of course");
						adao.viewCourse();
						break;
					case 100:
						flag = false;
						break;
					}
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
			case 10:
				flag = false;
				break;
			}
		}
	}
}
