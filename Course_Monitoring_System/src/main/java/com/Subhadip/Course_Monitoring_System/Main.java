package com.Subhadip.Course_Monitoring_System;

import java.util.Scanner;

import com.Subhadip.Course_Monitoring_System.Dao.AdminDao;
import com.Subhadip.Course_Monitoring_System.Dao.FacultyDao;
import com.Subhadip.Course_Monitoring_System.DaoImpl.AdminDaoImpl;
import com.Subhadip.Course_Monitoring_System.DaoImpl.FacultyDaoImpl;
import com.Subhadip.Course_Monitoring_System.Exception.AdminException;
import com.Subhadip.Course_Monitoring_System.Models.Admin;
import com.Subhadip.Course_Monitoring_System.Models.Batch;
import com.Subhadip.Course_Monitoring_System.Models.Course;
import com.Subhadip.Course_Monitoring_System.Models.Faculty;

public class Main {
	private static Scanner sc = new Scanner(System.in);
	
	private static AdminDao adao = new AdminDaoImpl();
	
	private static FacultyDao fdao = new FacultyDaoImpl();
	
	public static void main(String[] args) throws AdminException {
		boolean flag = true;
		while(flag) {
			System.out.println("Enter 1 for Admin");
			System.out.println("Enter 2 for Faculty");
			System.out.println("Enter 3 for Exit");
			
			int choice = sc.nextInt();
			
			switch(choice)
			{
			// Admin Log in
			case 1:
				System.out.println("Enter 1 for Log in");
				System.out.println("Enter 2 for Sign up");
				System.out.println("Enter 20 for Exit");
				
				int choice1 = sc.nextInt();
				
				switch(choice1)
				{
				case 1:
					System.out.println("Enter admin username");
					String username = sc.next();
					
					System.out.println("Enter admin password");
					String password = sc.next();
					
					adao.loginAdmin(username, password);
					
					System.out.println("Enter 1 for create course");
					System.out.println("Enter 2 for update course");
					System.out.println("Enter 3 for view course");
					System.out.println("Enter 4 for create batch under a course");
					System.out.println("Enter 5 ");
					System.out.println("Enter 6 ");
					System.out.println("Enter 7 for create faculty");
					System.out.println("Enter 8 for update faculty");
					System.out.println("Enter 9 for view faculty");
					System.out.println("Enter 10");
					System.out.println("Enter 11");
					System.out.println("Enter 12");
					System.out.println("Enter 13");
					System.out.println("Enter 14");
					System.out.println("Enter 15");
					System.out.println("Enter 0 for exit");
					
					int choice2 = sc.nextInt();
					
					switch(choice2)
					{
					case 1:
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
					case 2:
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
					case 3:
						System.out.println("All details of course");
						adao.viewCourse();
						break;
					case 4:
						System.out.println("Enter batch id");
						int batchId = sc.nextInt();
						
						System.out.println("Enter course id");
						int cId = sc.nextInt();
						
						System.out.println("Enter course name");
						String cName = sc.next();
						
						System.out.println("Enter course fees");
						int cFees = sc.nextInt();
						
						System.out.println("Enter course description");
						String cDesc = sc.next(); 
						
						System.out.println("Enter faculty id");
						int fId = sc.nextInt();
						
						System.out.println("Enter faculty name");
						String fName = sc.next();
						
						System.out.println("Enter no of student in the batch");
						int noOfStu = sc.nextInt();
						
						System.out.println("Enter batch start date");
						String startdate = sc.next();
						
						System.out.println("Enter batch duration");
						String duration = sc.next();
						
						Batch b = new Batch(batchId, new Course(cId, cName, cFees, cDesc), new Faculty(fId, fName), noOfStu, startdate, duration);
						
						adao.createBatch(b);
						break;
					case 5:
						//update batch
						break;
					case 6:
						//view batch
						break;
					case 7:
						System.out.println("Enter faculty id");
						int facId = sc.nextInt();
						
						System.out.println("Enter faculty name");
						String facName = sc.next();
						
						System.out.println("Enter faculty address");
						String facAddress = sc.next();
						
						System.out.println("Enter faculty mobile no");
						String facMobile = sc.next();
						
						System.out.println("Enter faculty email id");
						String facEmail = sc.next();
						
						System.out.println("Enter faculty username");
						String facUsername = sc.next();
						
						System.out.println("Enter faculty password");
						String facPassword = sc.next();
						
						Faculty f = new Faculty(facId, facName, facAddress, facMobile, facEmail, facUsername, facPassword);
						
						adao.createFaculty(f);
						
						break;
					case 8:
						System.out.println("Enter faculty id");
						int faId = sc.nextInt();
						
						System.out.println("Enter new faculty name");
						String newName = sc.next();
						
						System.out.println("Enter new faculty address");
						String newAddress = sc.next();
						
						System.out.println("Enter new faculty mobile no");
						String newMobile = sc.next();
						
						System.out.println("Enter new faculty email id");
						String newEmail = sc.next();
						
						System.out.println("Enter new faculty username");
						String newUsername = sc.next();
						
						System.out.println("Enter new faculty password");
						String newPassword = sc.next();
						
						adao.updateFaculty(faId, newName, newAddress, newMobile, newEmail, newUsername, newPassword);
						
						break;
					case 9:
						System.out.println("All details of faculty");
						adao.viewFaculty();
						break;
					case 10:
						// allocate faculty to a batch
						break;
					case 11:
						// create course plan
						break;
					case 12:
						// update course plan
						break;
					case 13:
						// view course plan
						break;
					case 14:
						// view day wise update of every batch
						break;
					case 15:
						// generate report for every batch
						break;
					case 0:
						flag = false;
						break;
					}
					break;
					
				case 2:
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
				// Faculty Log in
			case 2:
				System.out.println("Enter 1 for Log in");
				System.out.println("Enter 2 for exit");
				
				int choice2 = sc.nextInt();
				
				switch(choice2)
				{
				case 1:
					System.out.println("Enter faculty username");
					String username = sc.next();
					
					System.out.println("Enter faculty password");
					String password = sc.next();
					
					fdao.loginFaculty(username, password);
					
					System.out.println("You have logged in successfully");
					
					System.out.println("Enter 1 for view course plan");
					System.out.println("Enter 2 for fill day wise plan");
					System.out.println("Enter 3 for update password");
					
					int choice3 = sc.nextInt();
					
					switch(choice3)
					{
					case 1:
						//view course plan
						break;
					case 2:
						//fill day wise plan
						break;
					case 3:
						System.out.println("Enter your id");
						int id = sc.nextInt();
						
						System.out.println("Enter new password");
						String newpassword = sc.next();
						
						fdao.updatePassword(id, newpassword);
						break;
					}
					break;
				case 2:
					flag = false;
					break;
				}
			case 3:
				flag = false;
				break;
			}
		}
	}
}
