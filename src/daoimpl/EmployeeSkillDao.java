package daoimpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import config.JDBCConnection;
import dao.IEmployeeSkillDao;
import model.EmployeeSkill;

public class EmployeeSkillDao implements IEmployeeSkillDao{
 
	Connection conn=null;
	public EmployeeSkillDao() throws ClassNotFoundException, SQLException {
		conn=JDBCConnection.getDBConnection();
	}
	
		public List<EmployeeSkill> getAllEmployeeSkill() {
			List<EmployeeSkill> allEmpSkillList=new ArrayList<EmployeeSkill>();
			
		try {
			Statement stmt=conn.createStatement();
			ResultSet rst=stmt.executeQuery("select * from EmpSkill");
			if(rst!=null) {
				EmployeeSkill empskill=null;
				while(rst.next()) {
					empskill=new EmployeeSkill();
					empskill.setESId(rst.getInt(1));
					empskill.setEmployeeId(rst.getInt(2));
					empskill.setSkillId(rst.getInt(3));
					empskill.setExpYear(rst.getInt(4));
					allEmpSkillList.add(empskill);
				}
			}
		}
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return allEmpSkillList;
		
		}
		
		public  void addEmployeeSkill1(EmployeeSkill empskill) {
		try {
		PreparedStatement pst=conn.prepareStatement("insert into EmpSkill (ESId,EmployeeId,SkillId,ExpYear) values(?,?,?,?)");
		pst.setInt(1, empskill.getESId());
		pst.setInt(2, empskill.getEmployeeId());
		pst.setInt(3, empskill.getSkillId());
		pst.setInt(4, empskill.getExpYear());
		int i=pst.executeUpdate();
		if(i==1){
			System.out.println("1 record inserted...");
		}
		else {
			System.out.println("insertion failed...");
		}
	}
	catch(SQLException ex) {
		System.out.println(ex.getMessage());
	}
		}
		
			
		
			

		@Override
		public void addEmployeeSkill(EmployeeSkill Empskill) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public EmployeeSkill getEmployeeSkillById(int id) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void updateEmployeeSkill(EmployeeSkill Empskill) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void deactivateEmployeeSkill(int id) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void deleteEmployeeSkill(int id) {
			// TODO Auto-generated method stub
			
		}
		}