package com.Subhadip.Course_Monitoring_System.Utiliy;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Dao {
	public static EntityManagerFactory emf = null;
	
	static {
		emf = Persistence.createEntityManagerFactory("Admin");
	}
	
	public static EntityManager provideConnection()
	{
		return emf.createEntityManager();
	}
}
