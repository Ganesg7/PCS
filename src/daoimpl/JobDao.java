package daoimpl;
import java.sql.*;
import config.JDBCConnection;
import dao.IJobDao;
import model.Job;

public class JobDao implements IJobDao{

	Connection conn=null;
	public JobDao() throws ClassNotFoundException,SQLEXception{
	conn=JDBCConnection.getDBConnection();
	
	}
public void getAlljob() {
	try {
		Statement stmt=conn.createStatement();
		ResultSet rst=stmt.executeQuery("select * from Employee");
		if(rst!=null) {
			Job job=new Job();
			while(rst.next()) {
				job.setJobId(rst.getInt(1));
				job.setJobTitle(rst.getString(2));
				job.setJobDescription(rst.getString(3));
				job.setCompanyName(rst.getString(4));
				job.setLocation(rst.getString(5));
				job.setKeySkill(rst.getString(6));
				job.setSalary(rst.getInt(7));
				job.setActive(rst.getString(8));
				System.out.println(job);
			}
		}
	}
	catch(SQLException ex) {
		System.out.println(ex.getMessage());
	}
}
@Override
public void getAllJob() {
	// TODO Auto-generated method stub
	
}
@Override
public void addJob(Job job) {
	// TODO Auto-generated method stub
	
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

	

			
					