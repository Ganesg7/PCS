package dao;
import model.Employee;

import java.util.List;



public interface IEmployeeDao {

	List<Employee> getAllEmployee();
	void addEmployee(Employee emp);
	Employee getEmployeeById(int id);
	void updateEmployee(Employee emp);
	void deactivateEmployee(Employee Emp);
	void deleteEmployee(int id);
	Employee checkLogin(String userId, String password);
	void activateEmployee(Employee emp);
}
