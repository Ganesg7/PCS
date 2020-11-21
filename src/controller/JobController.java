package controller;
import java.io.*;
import java.sql.SQLException;
import java.util.List;

import dao.IJobDao;
import daoimpl.JobDao;
import model.Employee;
import model.Job;

public class JobController {
  IJobDao jobDao=null;
  public JobController()throws ClassNotFoundException,SQLException{
	  
  jobDao=new JobDao();
  }
  
	public Job addJob() {
		Job job=new Job();
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter JOb Titel");
			job.setJobTitle(reader.readLine());
			System.out.println("Enter Job Description");
			job.setJobDescription(reader.readLine());
			System.out.println("Enter Company Name");
			job.setCompanyName(reader.readLine());
			System.out.println("Enter Location");
			job.setLocation(reader.readLine());
			System.out.println("Enter Key Skill");
			job.setKeySkill(reader.readLine());
			System.out.println("Enter Salary");
			job.setSalary(Integer.parseInt(reader.readLine()));
			
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
		return job;
	}
			
	public void getAllJob() {
		List<Job> allJobList=jobDao.getAllJob();
		for(Job job:allJobList) {
			System.out.println(job);
		}
	}
public void getJobById() {
	try {
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		int id;
		System.out.println("Enter JobId which record you want to access:  ");
		id=Integer.parseInt(reader.readLine());
		Employee emp=empDao.getEmployeeById(id);
		System.out.println(emp);
	}
	catch (IOException ex) {
		System.out.println(ex.getMessage());
	}
}

}
