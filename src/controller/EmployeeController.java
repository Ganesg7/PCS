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
			if(role.equals("HRA")) {
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

	
public void getAllEmployee() {
	List<Employee> allEmpList=empDao.getAllEmployee();
    for(Employee emp:allEmpList) {
     System.out.println(emp);
}
}

}
