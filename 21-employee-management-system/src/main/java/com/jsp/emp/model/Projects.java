package com.jsp.emp.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Projects {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="Project_name")
	private String Project_name;
	
	@Column(name="Project_description")
	private String Project_description;
	
	@ManyToMany
	private List<Employee>  employee;
	
	
	public List<Employee> getEmployee() {
		return employee;
	}
	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}
	public Projects() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProject_name() {
		return Project_name;
	}
	public void setProject_name(String project_name) {
		Project_name = project_name;
	}
	public String getProject_description() {
		return Project_description;
	}
	public void setProject_description(String project_description) {
		Project_description = project_description;
	}
	
	
	
	
	

}
