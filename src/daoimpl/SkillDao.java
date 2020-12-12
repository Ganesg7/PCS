package daoimpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import config.JDBCConnection;
import dao.ISkillDao;
import model.Employee;
import model.Skill;

public class SkillDao implements ISkillDao{
	Connection conn=null;
	public SkillDao() throws ClassNotFoundException, SQLException {
		conn = JDBCConnection.getDBConnection();
	}
	@Override
	public List<Skill> getAllSkill() {
		List<Skill> allSkillList=new ArrayList<Skill>();
		try {
			Statement stmt=conn.createStatement();
			ResultSet rst=stmt.executeQuery("select * from skill");
			if(rst!=null) {
				Skill skill= null;
				while(rst.next()) {
				    skill= new Skill();
					skill.setSkillId(rst.getInt(1));
					skill.setSkillName(rst.getString(2));
					skill.setSkillDescription(rst.getString(3));
					skill.setActive(rst.getString(4));
					allSkillList.add(skill);
					
				}
				
			}
		}
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return allSkillList;
		
		
	}
	@Override
	public void addSkill(Skill skill) {
		try {
			PreparedStatement pst=conn.prepareStatement("insert into Skill(SkillName,SkillDescription,Active) values(?,?,?)");
			pst.setString(1, skill.getSkillName());
			pst.setString(2, skill.getSkillDescription());
			pst.setString(3, skill.getActive());
			int i=pst.executeUpdate();
			if(i==1) {
				System.out.println("1 record inserted...");
			}
			else {
				System.out.println("insertion falied...");
			}
		}
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
	}
	@Override
	public Skill getSkillById(int id) {
		Skill skill=new Skill();
		try{
			PreparedStatement pst=conn.prepareStatement("select * from Skill where SkillId=?");
			pst.setInt(1, id);
			ResultSet rst=pst.executeQuery();
			if(rst!=null) {
				if(rst.next()) {
					skill.setSkillId(rst.getInt(1));
					skill.setSkillName(rst.getString(2));
					skill.setSkillDescription(rst.getString(3));
					skill.setActive(rst.getString(8));
				}
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		return skill;
	}
	@Override
	public void updateSkill(Skill skill) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteSkill(int id) {
		try{
			PreparedStatement pst=conn.prepareStatement("delete from Skill where SkillId=?");
		
		pst.setInt(1, id);
		int i=pst.executeUpdate();
		if(i==1) {
			System.out.println("Skill Deleted....");
		}
		else {
		    System.out.println("Deletion Failed...");	
		}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}
	@Override
public void deactivateSkill(Skill skill) {
		
		try {
		PreparedStatement pst=conn.prepareStatement("Update Skill set Active=? where SkillId=?");
	    pst.setString(1, "Deactive");
	    pst.setInt(2, skill.getSkillId());
	    int i=pst.executeUpdate();
	  
	    
	}
	catch(SQLException ex) {
		System.out.println(ex.getMessage());
	}
	}
	@Override
	public void activateSkill(Skill skill) {
		try {
		PreparedStatement pst=conn.prepareStatement("Update Skill set Active=? where SkillId=?");
	    pst.setString(1, "Active");
	    pst.setInt(2, skill.getSkillId());
	    int i=pst.executeUpdate();
	    
	    
	}
	catch(SQLException ex) {
		System.out.println(ex.getMessage());
	}
		
	}
	
	
}