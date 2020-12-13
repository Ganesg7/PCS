package controller;


import java.io.*;
import model.Employee;
import model.EmployeeJob;
import dao.IEmployeeDao;
import dao.IEmployeeJobDao;
import daoimpl.EmpDao;
import daoimpl.EmployeeJobDao;

import java.sql.*;
import java.util.List;

public class EmployeeController {

	IEmployeeJobDao empjobdao= null;
	IEmployeeDao empDao=null;
	public EmployeeController() throws ClassNotFoundException, SQLException{
		
	empDao=new EmpDao();
	empjobdao=new EmployeeJobDao();
	}
	public Employee checkLogin(String userId, String password) {
		Employee emp=empDao.checkLogin(userId, password);
		return emp;
	}
			
			public void addEmployee() {
		Employee emp=new Employee();
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter First Name:");
			emp.setFirstName(reader.readLine());
			System.out.println("Enter Last Name:");
			emp.setLastName(reader.readLine());
			System.out.println("Enter UserId:");
			emp.setUserId(reader.readLine());
			System.out.println("Enter Password:");
			emp.setPassword(reader.readLine());
			System.out.println("Enter Gender:");
			emp.setGender(reader.readLine());
            System.out.println("Enter Role:");
			String role=reader.readLine();
			emp.setRole(role);
			if(role.equals("HRA") || role.equals("PME") || role.equals("EMP") ) {
				emp.setActive("Active");
			}
			else {
				emp.setActive("Deactive");
			}
			empDao.addEmployee(emp);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
		
	}

	
	public List<Employee> getAllEmployee() {
				List<Employee> allEmpList=empDao.getAllEmployee();
			   
				return allEmpList;
			}
    

public Employee getEmployeeById(String EmpId) {
	
	int id;
	
	id=Integer.parseInt(EmpId);
	Employee emp=empDao.getEmployeeById(id);

	return emp;
}
public Employee updateEmployee(String newpassword , int empid) {
		Employee emp=new Employee();
	
	
		emp.setPassword(newpassword);
		emp.setEmpId(empid);
		empDao.updateEmployee(emp);
		return emp;
}
public void deactiveEmployee(int empId) {
	int id;
	id=empId;
	Employee emp=empDao.getEmployeeById(id);
	empDao.deactivateEmployee(emp);
}

public void activeEmployee(int empId) {
	int id;
	id=empId;
	Employee emp=empDao.getEmployeeById(id);
	empDao.activateEmployee(emp);
}

public void deleteEmployee() {
	try {
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		int id;
		System.out.println("Enter EmployeeId whose record you want to delete:");
		id=Integer.parseInt(reader.readLine());
		empDao.deleteEmployee(id);
	}
	catch(IOException ex) {
		System.out.println(ex.getMessage());
	}
}


public  void addEmployeeJob(int empId, int jobId, String recruited) {
EmployeeJob Empjob=new EmployeeJob();
	
	Empjob.setEmployeeId(empId);
	Empjob.setJobId(jobId);
    Empjob.setRecruited(recruited);
	empjobdao.addEmployeeJob(Empjob);
}
public List<EmployeeJob> getAllEmployeeJob() {
	List<EmployeeJob> allEmpJobList=empjobdao.getAllEmployeeJob();
	   
	return allEmpJobList;
}

}
