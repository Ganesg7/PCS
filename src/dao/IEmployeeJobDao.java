package dao;
import model.EmployeeJob;
import java.util.List;
public interface IEmployeeJobDao {

	List<EmployeeJob> getAllEmployeeJob();
	void addEmployeeJob(EmployeeJob Empjob);
	EmployeeJob getEmployeeJobById(int id);
	void updateEmployeeJob(EmployeeJob Empjob);
	void deactivateEmployeeJob(int id);
	void deleteEmployeeJob(int id);
}

