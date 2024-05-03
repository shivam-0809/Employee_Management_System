package com.jsp.emp.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.jsp.emp.controller.Controller;
import com.jsp.emp.model.Department;
import com.jsp.emp.model.Employee;
import com.jsp.emp.model.Projects;

public class View {
	static Scanner myInput = new Scanner(System.in);
	static Controller controller = new Controller();
	static Employee employee = new Employee();
	static Department department = new Department();
	static Projects projects = new Projects();
	
	public static void main(String[] args) {
		Employee employee = new Employee();
		Department department1 = new Department();
		do {
			System.out.println("============================ WELCOME TO EMPLOYEE MANAGEMENT SYSTEM============================= ");
			System.out.println("Select operation to perform: ");
			System.out.println(
					"1.Add Employee \n2.View Employee Information \n3.Update Employee Details \n4.Remove Employee \n5.View Department Information\n6.Add Department"
					+ "\n7.Add Projects \n8.View Projects Infromation\n9.Remove Department\n10.Remove Projects\n11.Fetch All Employee Data"
					+ "\n12.Fetch All Department data\n13.Fetch All Projects Data\0.Exit");
			System.out.println("Enter digit respective to desired options: ");
			System.out.println("--------------------------------------------------------------------------------------------------");
			int userChoice = myInput.nextInt();
			myInput.nextLine();
			switch (userChoice) {
			case 0:
				myInput.close();
				System.out.println("---------------------------EXITED--------------------------");
				System.exit(0);
				
				break;
			case 1:
				System.out.println("-----------------------EMPLOYEE DETAILS--------------------");
				System.out.println("Enter Employee Name: ");
				employee.setEmp_name(myInput.nextLine());
				System.out.println("Enter Employee position: ");
				employee.setEmp_position(myInput.nextLine());
				System.out.println("Enter Employee Salary: ");
				employee.setEmp_salary(myInput.nextDouble());
				myInput.nextLine();
				
				boolean addEmployeeDetails = controller.addEmployeeDetails(employee);
				System.out.println(addEmployeeDetails);
				break;
				
			case 2:
				System.out.println("Enter the id of Employee: ");
				 int emp_id= myInput.nextInt();
				//
				  Employee employee1 =controller.FindEmployee(emp_id);
				  if (employee1!=null) {
					System.out.println("Emp Id:"+ employee1.getId());
					System.out.println("Emp Name:"+ employee1.getEmp_name());
					System.out.println("Emp position:"+ employee1.getEmp_position());
					System.out.println("Emp Salary:"+ employee1.getEmp_salary());
				
				  } else {
					System.out.println("-------------------------Employee  not found.------------------------------------");

				}
				break;
			case 3:
				System.out.println("Enter the id of employee to update: ");
				int emp_idToUpdate= myInput.nextInt();
				
				  Employee employee2 =controller.FindEmployee(emp_idToUpdate);

				employee2.setId(emp_idToUpdate);
				System.out.println("Enter salary to update: ");
				double updatedsalary= myInput.nextDouble();
				myInput.nextLine();
				employee2.setEmp_salary(updatedsalary);
				System.out.println("Enter position to update: ");
				String updatedPosition= myInput.nextLine();
				employee2.setEmp_position(updatedPosition);

//				boolean verifyUpdate=controller.UpdateEmployeeSalaryAndPosition(emp_idToUpdate,updatedsalary,updatedPosition);
				if (controller.UpdateEmployeeSalaryAndPosition(emp_idToUpdate,updatedsalary,updatedPosition)) {
					System.out.println("------------------------------Salry and position updated--------------------------");
				} else {
					System.out.println("--------------------------------Salary and position not upated---------------------------");
				}
				
				break;
			
			case 4:
                System.out.println("Enter id of the employee to be remove: ");
                int emp_idToRemove= myInput.nextInt();
                boolean verify=controller.RemoveEmployee(emp_idToRemove);
                if (controller.RemoveEmployee(emp_idToRemove)) {
					System.out.println("----------------------Employee removed------------------------------");
				}else {
					System.out.println("------------------------------Employee does not exists--------------------------------");
				}
				break;
				
			case 5:
				System.out.println("Enter the id of Department: ");
				 int dept_id= myInput.nextInt();
				
				  Department department =controller.FindDepartment(dept_id);
				  if (department!=null) {
					System.out.println("Dept Id:"+ department.getId());
					System.out.println("Dept Name:"+ department.getDept_name());
					
				
				  } else {
					System.out.println("-------------------Department not found.----------------------");

				}
				break;
				  
			case 6:
				System.out.println("-----------------------DEPARTMENT DETAILS--------------------");
				System.out.println("Enter Department Name: ");
				department1.setDept_name(myInput.nextLine());
				boolean addDepartmentDetails = controller.addDepartmentDetails(department1);
				System.out.println(addDepartmentDetails);
				
				break;
			case 7:
				System.out.println("-----------------------PROJECTS DETAILS--------------------");
				System.out.println("Enter Projects Name: ");
				projects.setProject_name(myInput.nextLine());
				System.out.println("Enter Projects Dscription: ");
				projects.setProject_description(myInput.nextLine());
				boolean addProjectsDetails = controller.addProjectsDetails(projects);
				System.out.println(addProjectsDetails);
				
				break;
			case 8:
				System.out.println("Enter the id of Projects: ");
				 int project_id= myInput.nextInt();
				
				  Projects projects =controller.FindProjects(project_id);
				  if (projects!=null) {
					System.out.println("Project Id:"+ projects.getId());
					System.out.println("Project Name:"+ projects.getProject_name());
					
				
				  } else {
					System.out.println("--------------------------Projects not found.-------------------");

				}
				break;
			case 9:
                System.out.println("Enter id of the department to be remove: ");
                int dept_idToRemove= myInput.nextInt();
//                boolean verify1=controller.RemoveDepartment(dept_idToRemove);
                if (controller.RemoveDepartment(dept_idToRemove)) {
					System.out.println("----------------------Department removed------------------------------");
				}else {
					System.out.println("------------------------------Department does not exists--------------------------------");
				}
				break;
			case 10:
                System.out.println("Enter id of the projects to be remove: ");
                int project_idToRemove= myInput.nextInt();
                if (controller.RemoveProjects(project_idToRemove)) {
					System.out.println("----------------------Projects removed------------------------------");
				}else {
					System.out.println("------------------------------Projects does not exists--------------------------------");
				}
				break;
			case 11:
               List<Employee> Fetchemployee= controller.Fetchemployee();
               for (Employee employee3 : Fetchemployee) {
            	   System.out.println("Emp Id: "+employee3.getId());
            	   System.out.println("Emp Name: "+employee3.getEmp_name());
            	   System.out.println("Emp Salary: "+employee3.getEmp_salary());
            	   System.out.println("Emp Position: "+employee3.getEmp_position());
			}
				break;
		   case 12:
			   List<Department> FetchDepartment= controller.FetchDepartment();
			   for (Department department2 : FetchDepartment) {
				   System.out.println("Dept Id: "+department2.getId());
            	   System.out.println("Dept Name: "+department2.getDept_name());
           
  				  
			   }
			   System.out.println("Enter the id of Employee: ");
			   int EmpIdUpdate= myInput.nextInt();
			     myInput.nextLine();
				 Employee employee21 =controller.FindEmployee(EmpIdUpdate);
			   System.out.println("Enter the id of Department: ");
				 int dept_Id= myInput.nextInt();
				 myInput.nextLine();
				 Department department11 =controller.FindDepartment(dept_Id);
				 ArrayList<Employee> all_emp= new ArrayList();
				all_emp.add(employee21);
				employee.setDepartment(department11);
				department11.setEmployee(all_emp);
				if (controller.UpdateDeptId_Emp(employee,department11)) {
					System.out.println("----------------------Set Department------------------------------");
				}else {
					System.out.println("------------------------------Department not set--------------------------------");
				}
				
				break;
		   case 13:
			   List<Projects> FetchProjects= controller.FetchProjects();
			   for (Projects projects2 : FetchProjects) {
				   System.out.println("Project Id: "+projects2.getId());
            	   System.out.println("Project Name: "+projects2.getProject_name());
            	   System.out.println("Project Description: "+projects2.getProject_description());

				}
			   System.out.println("Enter the id of Employee: ");
			   int EmpIdupdate= myInput.nextInt();
			     myInput.nextLine();
				 Employee employee22 =controller.FindEmployee(EmpIdupdate);
			   System.out.println("Enter the id of Projects: ");
				 int Proj_Id= myInput.nextInt();
				 myInput.nextLine();
				 Projects projects1 =controller.FindProjects(Proj_Id);
				 ArrayList<Employee> all_emp1= new ArrayList();
				all_emp1.add(employee22);
				employee.setProjects(FetchProjects);
				projects1.setEmployee(all_emp1);
				if (controller.UpdateProjtId_Emp(employee,projects1)) {
					System.out.println("----------------------Project Set ------------------------------");
				}else {
					System.out.println("------------------------------Projects not set--------------------------------");
				}
				
			   
				break;
				 

			default:
				System.out.println("------------------------------------INVALID SELECTION------------------------------------");

				break;
			}
		} while (true);
	}
	

}
