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
	
	public Skill addSkill()  
	{
		Skill skill=new Skill();
		try {
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Skill Description:");
		skill.setSkillDescription(reader.readLine());
		System.out.println("Enter Skill Name:");
		String skillName=reader.readLine();
		skill.setSkillName(skillName);
		if(skillName.equals("coding")) {
			skill.setActive("Active");
		}
		else {
			skill.setActive("Deactive");
		}
		skillDao.addSkill(skill);
		
	}
		catch(IOException ex)
		{
			System.out.println(ex.getMessage());
		}
		return skill;
		
}

	public void getAllSkill()
	{
		List<Skill> allSkillList=skillDao.getAllSkill();
		for(Skill skill:allSkillList)
		{
			System.out.println(skill);
		}
		
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
	public void deactivateSkill() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			System.out.println("Enter the Skill ID which Skill record you want to deactivate:");
			id=Integer.parseInt(reader.readLine());
			Skill skill=skillDao.getSkillById(id);
			skillDao.deactivateSkill(skill);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
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
}
