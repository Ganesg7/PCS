package dao;
import model.EmployeeJob;
public interface IEmployeeJobDao {

	void getAllEmployeeJob();
	void addEmployeeJob(EmployeeJob Empjob);
	EmployeeJob getEmployeeJobById(int id);
	void updateEmployeeJob(EmployeeJob Empjob);
	void deactivateEmployeeJob(int id);
	void deleteEmployeeJob(int id);
}

