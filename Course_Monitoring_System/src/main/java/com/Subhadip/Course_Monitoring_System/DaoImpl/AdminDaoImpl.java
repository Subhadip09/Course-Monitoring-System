package com.Subhadip.Course_Monitoring_System.DaoImpl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.Subhadip.Course_Monitoring_System.Dao.AdminDao;
import com.Subhadip.Course_Monitoring_System.Exception.AdminException;
import com.Subhadip.Course_Monitoring_System.Models.Admin;
import com.Subhadip.Course_Monitoring_System.Models.Batch;
import com.Subhadip.Course_Monitoring_System.Models.Course;
import com.Subhadip.Course_Monitoring_System.Models.CoursePlan;
import com.Subhadip.Course_Monitoring_System.Models.Faculty;
import com.Subhadip.Course_Monitoring_System.Utiliy.Dao;

public class AdminDaoImpl implements AdminDao{

	@Override
	public String createAdmin(Admin a){
		// TODO Auto-generated method stub
		EntityManager em = Dao.provideConnection();
		em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();
		em.close();
		
		return "Data get inserted";
	}

	@Override
	public Admin loginAdmin(String username, String password) throws AdminException {
		// TODO Auto-generated method stub
		EntityManager em = Dao.provideConnection();
		try {
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT a FROM Admin a WHERE a.username = :username AND a.password = :password");
            query.setParameter("username", username);
            query.setParameter("password", password);
            Admin admin = (Admin) query.getSingleResult();
            em.getTransaction().commit();
            return admin;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            return null;
        } finally {
            em.close();
        }
	}

	@Override
	public String createCourse(Course c) {
		// TODO Auto-generated method stub
		EntityManager em = Dao.provideConnection();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		em.close();
		
		return "Data get inserted";
	}

	@Override
	public String updateCourse(int id, String newName, int newFees, String newDesc) {
		// TODO Auto-generated method stub
		EntityManager em = Dao.provideConnection();
		em.getTransaction().begin();
		Course update = em.find(Course.class, id);
		update.setName(newName);
		update.setFees(newFees);
		update.setDescription(newDesc);
		em.getTransaction().commit();
		em.close();
		return "data get updated";
	}

	@Override
	public List<Course> viewCourse() {
		// TODO Auto-generated method stub
		EntityManager em = Dao.provideConnection();
		em.getTransaction().begin();
		
		Query query = em.createQuery("select c from Course c");
		List<Course> list = query.getResultList();
		
		for(Course c : list)
		{
			System.out.println(c);
		}
		em.getTransaction().commit();
		em.close();
		return null;
	}

	@Override
	public String createBatch(int batchId, int courseId, int facultyId, int noOfStudents, String startDate,
			String duration) {
		// TODO Auto-generated method stub
		EntityManager em = Dao.provideConnection();
		em.getTransaction().begin();
		Course course = em.find(Course.class, courseId);
		Faculty faculty = em.find(Faculty.class, facultyId);
		Batch batch = new Batch();
		batch.setId(batchId);
		batch.setCourseId(course);
        batch.setFacultyId(faculty);
        batch.setNoOfStudents(noOfStudents);
        batch.setBatchStartDate(startDate);
        batch.setDuration(duration);
        em.persist(batch);
        em.getTransaction().commit();
		em.close();
		return null;
	}
	
//	@Override
//	public String createBatch(Batch b) {
//		// TODO Auto-generated method stub
//		EntityManager em = Dao.provideConnection();
//		em.getTransaction().begin();
//		em.persist(b);
//		em.getTransaction().commit();
//		em.close();
//		
//		return "data get inserted";
//	}
	
	@Override
	public String updateBatch(int id, int couId, int facId, String batchStartDate, String batchDuration, int noOfStudents) {
		// TODO Auto-generated method stub
		EntityManager em = Dao.provideConnection();
		em.getTransaction().begin();
		
		Course course = em.find(Course.class, couId);
		Faculty faculty = em.find(Faculty.class, facId);
		Batch update = em.find(Batch.class, id);
		update.setCourseId(course);
		update.setFacultyId(faculty);
		update.setBatchStartDate(batchStartDate);
		update.setDuration(batchDuration);
		update.setNoOfStudents(noOfStudents);
		em.getTransaction().commit();
		em.close();
		return "data get updated";
	}
	
	@Override
	public List<Batch> viewBatch() {
		// TODO Auto-generated method stub
		EntityManager em = Dao.provideConnection();
		em.getTransaction().begin();
		try {
			Query query1 = em.createQuery("select b from Batch b");
			List<Batch> list1 = query1.getResultList();
			
//			  String jpql = "SELECT b FROM Batch b WHERE b.courseId = :cid";
//	          TypedQuery<Batch> query = em.createQuery(jpql, Batch.class);
	//
//	          // Execute the query and return the list of batches
//	          return query.getResultList();
			
			
			for(Batch b : list1)
			{
				System.out.println(b);
			}
			em.getTransaction().commit();
		}
		finally {
			em.close();
		}
		
		
		return null;
	}

	@Override
	public String createFaculty(Faculty f) {
		// TODO Auto-generated method stub
		EntityManager em = Dao.provideConnection();
		em.getTransaction().begin();
		em.persist(f);
		em.getTransaction().commit();
		em.close();
		
		return "data get inserted";
	}

	@Override
	public String updateFaculty(int faId, String newName, String newAddress, String newMobile, String newEmail,
			String newUsername, String newPassword) {
		// TODO Auto-generated method stub
		EntityManager em = Dao.provideConnection();
		em.getTransaction().begin();
		Faculty update = em.find(Faculty.class, faId);
		update.setName(newName);
		update.setAddress(newAddress);
		update.setMobileNo(newMobile);
		update.setEmail(newEmail);
		update.setUsername(newUsername);
		update.setPassword(newPassword);
		em.getTransaction().commit();
		em.close();
		return "data get updated";
	}

	@Override
	public List<Faculty> viewFaculty() {
		// TODO Auto-generated method stub
		EntityManager em = Dao.provideConnection();
		em.getTransaction().begin();
		
		Query query = em.createQuery("select f from Faculty f");
		List<Faculty> list = query.getResultList();
		
		for(Faculty f : list)
		{
			System.out.println(f);
		}
		em.getTransaction().commit();
		em.close();
		return null;
	}


	@Override
	public List<CoursePlan> viewCoursePlan() {
		// TODO Auto-generated method stub
		EntityManager em = Dao.provideConnection();
		em.getTransaction().begin();
		
		Query query = em.createQuery("select cp from CoursePlan cp");
		List<CoursePlan> list = query.getResultList();
		
		for(CoursePlan cp : list)
		{
			System.out.println(cp);
		}
		em.getTransaction().commit();
		em.close();
		
		return null;
	}

	

}
