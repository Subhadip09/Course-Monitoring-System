package com.Subhadip.Course_Monitoring_System;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.Subhadip.Course_Monitoring_System.Models.Admin;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Admin");
        EntityManager em = emf.createEntityManager();
        
        Admin ad = new Admin(11, "Rajdip", "Rajdip@123");
        
        em.getTransaction().begin();
        
        em.persist(ad);
        
        em.getTransaction().commit();
        
        em.close();
    }
}
