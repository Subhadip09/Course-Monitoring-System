package com.Subhadip.Course_Monitoring_System.Dao;

import java.util.List;

import com.Subhadip.Course_Monitoring_System.Models.CoursePlan;
import com.Subhadip.Course_Monitoring_System.Models.Faculty;


public interface FacultyDao {
	public Faculty loginFaculty(String username, String password);
	
	public List<CoursePlan> viewCoursePlan();
	
	public String fillDayWisePlan();
	
	public String updatePassword(int id, String newPassword);
}
