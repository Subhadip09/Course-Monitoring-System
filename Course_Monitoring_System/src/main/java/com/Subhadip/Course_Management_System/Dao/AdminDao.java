package com.Subhadip.Course_Management_System.Dao;

import java.util.List;

import org.hibernate.engine.jdbc.batch.spi.Batch;

import com.Subhadip.Course_Management_System.Exception.AdminException;
import com.Subhadip.Course_Management_System.Models.Admin;
import com.Subhadip.Course_Management_System.Models.Course;
import com.Subhadip.Course_Management_System.Models.Faculty;

public interface AdminDao {
	public String createAdmin(Admin a);
	
	public Admin loginAdmin(String username, String password) throws AdminException;
	
	public String createCourse(Course c);
	
	public String updateCourse(int id, String newName, int newFees, String newDesc);
	
	public List<Course> viewCourse();
	
	public String createBatch(Batch b);
	
	public String createFaculty(Faculty f);
	
	public String updateFaculty(int faId, String newName, String newAddress, String newMobile, String newEmail, String newUsername, String newPassword);
	
	public List<Faculty> viewFaculty();
}
