package daoimpl;

import java.sql.*;

import config.JDBCConnection;
import dao.ISkillDao;
import model.Skill;

public class SkillDao implements ISkillDao{
	Connection conn=null;
	public SkillDao() throws ClassNotFoundException, SQLException {
		conn = JDBCConnection.getDBConnection();
	}
	@Override
	public void getAllSkill() {
		try {
			Statement stmt=conn.createStatement();
			ResultSet rst=stmt.executeQuery("select * from skill");
			if(rst!=null) {
				Skill skill= new Skill();
				while(rst.next()) {
					skill.setSkillId(rst.getInt(1));
					skill.setSkillName(rst.getString(2));
					skill.setSkillDescription(rst.getString(3));
					skill.setActive(rst.getString(4));
					System.out.println(skill);
				}
			}
		}
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		
	}
	@Override
	public void addSkill(Skill skill) {
		try {
			PreparedStatement pst=conn.prepareStatement("insert into Skill values(?,?,?)");
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
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void updateSkill(Skill skill) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deactivateSkill(int id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteSkill(int id) {
		// TODO Auto-generated method stub
		
	}
	
}