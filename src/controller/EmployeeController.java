package controller;


import java.io.*;
import model.Employee;
import dao.IEmployeeDao;
import daoimpl.EmpDao;
import java.sql.*;
import java.util.List;

public class EmployeeController {

	IEmployeeDao empDao=null;
	public EmployeeController() throws ClassNotFoundException, SQLException{
		
	empDao=new EmpDao();
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
public void updateEmployee() {
	try {
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		int id;
		String password, confirmpassword;
		System.out.println("Enter EmployeeId whose record you want to update:");
		id=Integer.parseInt(reader.readLine());
		Employee emp=empDao.getEmployeeById(id);
		System.out.println("Enter your new password:");
		password=reader.readLine();
		System.out.println("Re-enter same password to confirm:");
		confirmpassword=reader.readLine();
		if(password.equals(confirmpassword)) {
			emp.setPassword(password);
			empDao.updateEmployee(emp);
		}
		else {
			System.out.println("Sorry! you have entered different password!");
		}
	}
	catch(IOException ex) {
		System.out.println(ex.getMessage());
	}
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

}
