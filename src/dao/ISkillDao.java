package dao;
import model.Skill;
public interface ISkillDao {

	 void getAllSkill();
	 void addSkill(Skill Skill);
	 Skill getSkillById(int id);
	 void updateSkill(Skill skill);
	 void deactivateSkill(int id);
	 void deleteSkill(int id);
}




