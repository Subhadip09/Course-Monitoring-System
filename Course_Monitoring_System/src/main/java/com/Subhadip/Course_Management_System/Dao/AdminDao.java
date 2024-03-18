package com.Subhadip.Course_Management_System.Dao;

import java.util.List;

import com.Subhadip.Course_Management_System.Exception.AdminException;
import com.Subhadip.Course_Management_System.Models.Admin;
import com.Subhadip.Course_Management_System.Models.Course;

public interface AdminDao {
	public String createAdmin(Admin a);
	
	public Admin loginAdmin(String username, String password) throws AdminException;
	
	public String createCourse(Course c);
	
	public String updateCourse(int id, String newName, int newFees, String newDesc);
	
	public List<Course> viewCourse();
}
