package com.Subhadip.Course_Monitoring_System.DaoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.Subhadip.Course_Monitoring_System.Dao.FacultyDao;
import com.Subhadip.Course_Monitoring_System.Models.Batch;
import com.Subhadip.Course_Monitoring_System.Models.Course;
import com.Subhadip.Course_Monitoring_System.Models.CoursePlan;
import com.Subhadip.Course_Monitoring_System.Models.Faculty;
import com.Subhadip.Course_Monitoring_System.Utiliy.Dao;

public class FacultyDaoImpl implements FacultyDao{

	@Override
	public Faculty loginFaculty(String username, String password) {
		// TODO Auto-generated method stub
		EntityManager em = Dao.provideConnection();
		try {
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT f FROM Faculty f WHERE f.username = :username AND f.password = :password");
            query.setParameter("username", username);
            query.setParameter("password", password);
            Faculty faculty = (Faculty) query.getSingleResult();
            em.getTransaction().commit();
            return faculty;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            return null;
        } finally {
            em.close();
        }
	}

	@Override
	public String createCoursePlan(int planId, int batchId, int dayNumber, String topic, String status) {
		// TODO Auto-generated method stub
		EntityManager em = Dao.provideConnection();
		em.getTransaction().begin();
		Batch batch = em.find(Batch.class, batchId);
		CoursePlan cplan = new CoursePlan();
		cplan.setPlanId(planId);
		cplan.setBatchId(batch);
		cplan.setDayNumber(dayNumber);
		cplan.setTopic(topic);
		cplan.setStatus(status);
        em.persist(cplan);
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

	@Override
	public String updatePassword(int id, String newPassword) {
		// TODO Auto-generated method stub
		EntityManager em = Dao.provideConnection();
		em.getTransaction().begin();
		Faculty update = em.find(Faculty.class, id);
		update.setPassword(newPassword);
		em.getTransaction().commit();
		em.close();
		return "password get updated";
	}


}
