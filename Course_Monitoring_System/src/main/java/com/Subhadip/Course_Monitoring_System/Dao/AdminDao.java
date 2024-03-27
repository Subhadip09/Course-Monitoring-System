package com.Subhadip.Course_Monitoring_System.Dao;

import java.util.Date;
import java.util.List;

import com.Subhadip.Course_Monitoring_System.Exception.AdminException;
import com.Subhadip.Course_Monitoring_System.Models.Admin;
import com.Subhadip.Course_Monitoring_System.Models.Batch;
import com.Subhadip.Course_Monitoring_System.Models.Course;
import com.Subhadip.Course_Monitoring_System.Models.CoursePlan;
import com.Subhadip.Course_Monitoring_System.Models.Faculty;

public interface AdminDao {
	public String createAdmin(Admin a);
	
	public Admin loginAdmin(String username, String password) throws AdminException;
	
	public String createCourse(Course c);
	
	public String updateCourse(int id, String newName, int newFees, String newDesc);
	
	public List<Course> viewCourse();
	
	public String createBatch(int batchId, int courseId, int facultyId, int noOfStudents, String startDate, String duration);
	
//	public String createBatch(Batch b);
	
	public String updateBatch(int id, int couId, int facId, String batchStartDate, String batchDuration, int noOfStudents);
	
	public List<Batch> viewBatch();
	
	public String createFaculty(Faculty f);
	
	public String updateFaculty(int faId, String newName, String newAddress, String newMobile, String newEmail, String newUsername, String newPassword);
	
	public List<Faculty> viewFaculty();
	
	
	
	public List<CoursePlan> viewCoursePlan();
}
