package dao;
import model.Skill;
import java.util.List;
public interface ISkillDao {

	 List<Skill> getAllSkill();
	 void addSkill(Skill Skill);
	 Skill getSkillById(int id);
	 void updateSkill(Skill skill);
	 void deactivateSkill(int id);
	 void deleteSkill(int id);
}




