package daoimpl;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import config.JDBCConnection;
import dao.IEmployeeJobDao;
import model.EmployeeJob;


public class EmployeeJobDao implements IEmployeeJobDao {
	static Connection conn=null;
	public EmployeeJobDao() throws ClassNotFoundException,SQLException{
		conn=JDBCConnection.getDBConnection();
	}
	public List<EmployeeJob> getAllEmployeeJob() {
		List<EmployeeJob> allEmpJobList=new ArrayList<EmployeeJob>();
		try {
			Statement stmt=conn.createStatement();
			ResultSet rst=stmt.executeQuery("select * from Empjob");
			if(rst!=null) {
				EmployeeJob Empjob=null;
				while(rst.next()) {
			Empjob=new EmployeeJob();
			 Empjob.setEJId(rst.getInt(1));
			 Empjob.setEmployeeId(rst.getInt(2));
			 Empjob.setJobId(rst.getInt(3));
			 Empjob.setRecruited(rst.getString(4));
			 allEmpJobList.add(Empjob);
				
				
				
			}
		}
	}
	catch(SQLException ex) {
		System.out.println(ex.getMessage());
	}
		return allEmpJobList;
	}
	public void addEmployeeJob(EmployeeJob Empjob) {
		try {
		
			PreparedStatement pst=conn.prepareStatement("Insert into EmpJob(EmployeeId,JobId,Recruited) values(?,?,?)");
		  
		    pst.setInt(1, Empjob.getEmployeeId());
		    pst.setInt(2, Empjob.getJobId());
		    pst.setString(3, Empjob.getRecruited());
		    int i=pst.executeUpdate();
		    if(i==1) {
		    	System.out.println("1 record inserted....");
		    	
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
	public EmployeeJob getEmployeeJobById(int id) {
		EmployeeJob employeejob=new EmployeeJob(); //1
		try{
			PreparedStatement pst=conn.prepareStatement("select * from EmpJob where EJId=?");
			pst.setInt(1,id);
			ResultSet rst=pst.executeQuery();
			if(rst!=null) {
				if(rst.next()) {
					employeejob=new EmployeeJob();
					employeejob.setEJId(rst.getInt(1));
					employeejob.setEmployeeId(rst.getInt(2));
					employeejob.setJobId(rst.getInt(3));
					employeejob.setRecruited(rst.getString(4));
				}
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return employeejob;
	}
	@Override
	public void updateEmployeeJob(EmployeeJob Employeejob) {
		try {
			PreparedStatement pst=conn.prepareStatement("update EmpJob set Recruited=? where EJId=? ");
			pst.setString(1, Employeejob.getRecruited());
			pst.setInt(2, Employeejob.getEJId());
			int i=pst.executeUpdate();
			if(i==1){
				System.out.println("1 record updated...");
			}
			else {
				System.out.println("update failed...");
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
	}
	@Override
	public void deactivateEmployeeJob(int id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteEmployeeJob(int id) {
		// TODO Auto-generated method stub
		
	}

}
