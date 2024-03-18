package com.Subhadip.Course_Management_System.Dao;

import com.Subhadip.Course_Management_System.Exception.AdminException;
import com.Subhadip.Course_Management_System.Models.Admin;

public interface AdminDao {
	public String createAdmin(Admin a);
	
	public Admin loginAdmin(String username, String password) throws AdminException;
}
