package dao;
import model.EmployeeSkill;
import java.util.List;
public interface IEmployeeSkillDao {
 
	List<EmployeeSkill> getAllEmployeeSkill();
	void addEmployeeSkill(EmployeeSkill Empskill);
	EmployeeSkill getEmployeeSkillById(int id);
	void updateEmployeeSkill(EmployeeSkill Empskill);
	void deactivateEmployeeSkill(int id);
	void deleteEmployeeSkill(int id);
}

