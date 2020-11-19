package dao;
import model.EmployeeSkill;
public interface IEmployeeSkillDao {
 
	void getAllEmployeeSkill();
	void addEmployeeSkill(EmployeeSkill Empskill);
	EmployeeSkill getEmployeeSkillById(int id);
	void updateEmployeeSkill(EmployeeSkill Empskill);
	void deactivateEmployeeSkill(int id);
	void deleteEmployeeSkill(int id);
}

