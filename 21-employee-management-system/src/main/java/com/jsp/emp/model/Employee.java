package com.jsp.emp.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="Emp_name")
	private String Emp_name;
	
	@Column(name="Emp_position")
	private String Emp_position;
	
	@Column(name="Emp_salary")
	private double Emp_salary;
	
	@CreationTimestamp
	private LocalDateTime creationDateTime;
	
	@ManyToOne
	private Department department;
	
	@ManyToMany
	private List<Projects>projects;

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	

	public List<Projects> getProjects() {
		return projects;
	}

	public void setProjects(List<Projects> projects) {
		this.projects = projects;
	}

	public Employee() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmp_name() {
		return Emp_name;
	}

	public void setEmp_name(String emp_name) {
		Emp_name = emp_name;
	}

	public String getEmp_position() {
		return Emp_position;
	}

	public void setEmp_position(String emp_position) {
		Emp_position = emp_position;
	}

	public double getEmp_salary() {
		return Emp_salary;
	}

	public void setEmp_salary(double emp_salary) {
		Emp_salary = emp_salary;
	}

	public LocalDateTime getCreationDateTime() {
		return creationDateTime;
	}

	public void setCreationDateTime(LocalDateTime creationDateTime) {
		this.creationDateTime = creationDateTime;
	}
	
	

}
