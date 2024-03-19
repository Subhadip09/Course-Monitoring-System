package com.Subhadip.Course_Monitoring_System.Models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class Batch {
	@Id
	private int id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Course course;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Faculty faculty;
	
	private int noOfStudents;
	
	private String batchStartDate;
	
	private String duration;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public int getNoOfStudents() {
		return noOfStudents;
	}

	public void setNoOfStudents(int noOfStudents) {
		this.noOfStudents = noOfStudents;
	}

	public String getBatchStartDate() {
		return batchStartDate;
	}

	public void setBatchStartDate(String batchStartDate) {
		this.batchStartDate = batchStartDate;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Batch() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Batch(int id, Course course, Faculty faculty, int noOfStudents, String batchStartDate, String duration) {
		super();
		this.id = id;
		this.course = course;
		this.faculty = faculty;
		this.noOfStudents = noOfStudents;
		this.batchStartDate = batchStartDate;
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "Batch [id=" + id + ", course=" + course + ", faculty=" + faculty + ", noOfStudents=" + noOfStudents
				+ ", batchStartDate=" + batchStartDate + ", duration=" + duration + "]";
	}
}
