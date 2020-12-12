package controller;
import java.io.*;
import java.sql.SQLException;
import java.util.List;
import dao.ISkillDao;
import daoimpl.SkillDao;
import model.Skill;

public class SkillController {

	ISkillDao skillDao=null;
	public SkillController() throws ClassNotFoundException,SQLException
	{
		skillDao=new SkillDao();
	}
	
	public Skill addSkill(String skillName2, String skillDec)  
	{
		Skill skill=new Skill();
		
		skill.setSkillDescription(skillDec);
		

		skill.setSkillName(skillName2);
		if(skillName2.equals("Java Coding") || skillName2.equals("SQL Query") || skillName2.equals("HTML Coding") || skillName2.equals("CSS Coding") || skillName2.equals("JavaScript Coding")) {
			skill.setActive("Active");
		}
		else {
			skill.setActive("Deactive");
		}
		skillDao.addSkill(skill);
		return skill;
		
}

	public List<Skill> getAllSkill()
	{
		List<Skill> allSkillList=skillDao.getAllSkill();
		return allSkillList;
		
	}
	public void getSkillById()
	{
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			System.out.println("Enter the Skill ID which Skill record you want to access:");
			id=Integer.parseInt(reader.readLine());
			Skill skill=skillDao.getSkillById(id);
			System.out.println(skill);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	public void updateSkill() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			System.out.println("Enter the Skill Id Which SKill record you want to update:");
			id=Integer.parseInt(reader.readLine());
			Skill skill=skillDao.getSkillById(id);
			skillDao.updateSkill(skill);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	public void deactivateSkill(int skillId) {

		Skill skill=skillDao.getSkillById(skillId);
		skillDao.deactivateSkill(skill);
	}
	public void deleteSkill() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			System.out.println("Enter the Skill Id which Skill record you want to delete:");
			id=Integer.parseInt(reader.readLine());
			skillDao.deleteSkill(id);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public void activeSkill(int skillId) {
		

		Skill skill=skillDao.getSkillById(skillId);
		skillDao.activateSkill(skill);
	}
}
