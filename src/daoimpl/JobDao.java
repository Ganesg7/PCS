package daoimpl;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import config.JDBCConnection;
import dao.IJobDao;
import model.Job;


public class JobDao implements IJobDao{

	Connection conn=null;
	public JobDao() throws ClassNotFoundException,SQLException{
	conn=JDBCConnection.getDBConnection();
	
	}
public List<Job> getAllJob() {
	List<Job> allJobList=new ArrayList <Job>();
	try {
		Statement stmt=conn.createStatement();
		ResultSet rst=stmt.executeQuery("select * from Job");
		if(rst!=null) {
			Job job=null;
			while(rst.next()) {
				job=new Job();
			    job.setJobId(rst.getInt(1));
				job.setJobTitle(rst.getString(2));
				job.setJobDescription(rst.getString(3));
				job.setCompanyName(rst.getString(4));
				job.setLocation(rst.getString(5));
				job.setKeySkill(rst.getString(6));
				job.setSalary(rst.getInt(7));
				job.setActive(rst.getString(8));
				allJobList.add(job);
			}
		}
	}
	catch(SQLException ex) {
		System.out.println(ex.getMessage());
	}
	return allJobList;
}

	
@Override
public void addJob(Job job) {
	try {
		PreparedStatement pst=conn.prepareStatement("insert into Job(JobId,Jobtitle,JobDescription,CompanyName,Location,keySkill,Salary,Active) values(?,?,?,?,?,?,?,?)");
		pst.setInt(   1, job.getJobId());
		pst.setString(2, job.getJobTitle());
		pst.setString(3, job.getJobDescription());
		pst.setString(4, job.getCompanyName());
		pst.setString(5, job.getLocation());
		pst.setString(6, job.getKeySkill());
		pst.setInt(   7,    job.getSalary());
		pst.setString(8, job.getActive());	
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
public Job getJobById(int id) {
	// TODO Auto-generated method stub
	return null;
}
@Override
public void updateJob(Job job) {
	// TODO Auto-generated method stub
	
}
@Override
public void deactivatehJob(int id) {
	// TODO Auto-generated method stub
	
}
@Override
public void deleteJob(int id) {
	// TODO Auto-generated method stub
	
}
}

	

			
					