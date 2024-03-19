package com.Subhadip.Course_Management_System.Models;

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
	private Course courseId;
	
	@OneToOne
	private Faculty facultyId;
	
	private int noOfStudents;
	
	private String batchStartDate;
	
	private String duration;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Course getCourseId() {
		return courseId;
	}

	public void setCourseId(Course courseId) {
		this.courseId = courseId;
	}

	public Faculty getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(Faculty facultyId) {
		this.facultyId = facultyId;
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

	public Batch(int id, int noOfStudents, String batchStartDate, String duration) {
		super();
		this.id = id;
		this.noOfStudents = noOfStudents;
		this.batchStartDate = batchStartDate;
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "Batch [id=" + id + ", noOfStudents=" + noOfStudents + ", batchStartDate=" + batchStartDate
				+ ", duration=" + duration + "]";
	}
	
	
}
