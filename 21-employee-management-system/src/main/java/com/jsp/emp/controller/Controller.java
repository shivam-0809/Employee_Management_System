package com.jsp.emp.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.jsp.emp.model.Department;
import com.jsp.emp.model.Employee;
import com.jsp.emp.model.Projects;

public class Controller {
	static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pgsql");
	static EntityManager entityManager = entityManagerFactory.createEntityManager();
	static EntityTransaction entityTransaction = entityManager.getTransaction();

//==========================METHOD FOR ADDDING EMPLOYEE DEPT AND PROJECTS=======================
	public boolean addEmployeeDetails(Employee employee) {
		if (employee != null) {
			entityTransaction.begin();
			entityManager.persist(employee);

			entityTransaction.commit();

			return true;
		}
		return false;

	}

	public boolean addDepartmentDetails(Department department) {
		if (department != null) {
			entityTransaction.begin();
			entityManager.persist(department);
			entityTransaction.commit();

			return true;
		}
		return false;

	}

	public boolean addProjectsDetails(Projects projects) {
		if (projects != null) {
			entityTransaction.begin();
			entityManager.persist(projects);
			entityTransaction.commit();

			return true;
		}
		return false;
	}

//======================================== METHOD FOR VIEWING DATA========================================
	public Employee FindEmployee(int emp_Id) {

		return entityManager.find(Employee.class, emp_Id);
	}

	public Department FindDepartment(int dept_id) {
		return entityManager.find(Department.class, dept_id);

	}

	public Projects FindProjects(int project_id) {
		return entityManager.find(Projects.class, project_id);
	}

//	===================== METHOD TO UPDATE===============================

	public boolean UpdateEmployeeSalaryAndPosition(int emp_idToUpdate, double updatedsalary, String updatedPosition) {
		Employee update = FindEmployee(emp_idToUpdate);
		if (update != null) {
			update.setEmp_salary(updatedsalary);
			update.setEmp_position(updatedPosition);
			entityTransaction.begin();
			entityManager.merge(update);
			entityTransaction.commit();

			return true;
		}
		return false;

	}

//	===============================METHOD TO REMOVE=================================

	public boolean RemoveEmployee(int emp_idToRemove) {
		Employee employee = FindEmployee(emp_idToRemove);
		if (employee != null) {

			entityTransaction.begin();
			entityManager.remove(employee);

			entityTransaction.commit();

			return true;

		}
		return false;
	}

	public boolean RemoveDepartment(int dept_idToRemove) {
		Department department = FindDepartment(dept_idToRemove);
		if (department != null) {

			entityTransaction.begin();
			entityManager.remove(department);

			entityTransaction.commit();

			return true;

		}
		return false;
	}

	public boolean RemoveProjects(int project_idToRemove) {
		Projects projects = FindProjects(project_idToRemove);
		if (projects != null) {

			entityTransaction.begin();
			entityManager.remove(projects);

			entityTransaction.commit();

			return true;

		}
		return false;
	}

//==================================================FETCH METHOD ====================
	public List<Employee> Fetchemployee() {
		String jpql = "SELECT s FROM Employee s";
		TypedQuery<Employee> query = entityManager.createQuery(jpql, Employee.class);
		return query.getResultList();

	}

	public List<Department> FetchDepartment() {
		String jpql = "SELECT s FROM Department s";
		TypedQuery<Department> query = entityManager.createQuery(jpql, Department.class);
		return query.getResultList();

	}

	public List<Projects> FetchProjects() {
		String jpql = "SELECT s FROM Projects s";
		TypedQuery<Projects> query = entityManager.createQuery(jpql, Projects.class);
		return query.getResultList();

	}

//=======================================================================================================
	public boolean UpdateDeptId_Emp(Employee employee, Department department11) {
		if (employee != null && department11 != null) {

			entityTransaction.begin();
			entityManager.merge(employee);
			entityManager.merge(department11);

			entityTransaction.commit();

			return true;
		}
		return false;
	}

	public boolean UpdateProjtId_Emp(Employee employee, Projects projects1) {
		if (employee != null && projects1 != null) {

			entityTransaction.begin();
			entityManager.merge(employee);
			entityManager.merge(projects1);

			entityTransaction.commit();

			return true;
		}
		return false;
	}

}
