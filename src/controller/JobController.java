package controller;
import java.io.*;
import java.sql.*;
import java.util.List;
import dao.IJobDao;
import daoimpl.JobDao;
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
			System.out.println("Enter Job Titel");
			String jobTitle=reader.readLine();
			job.setJobTitle(jobTitle);
			if(jobTitle.equals("HR")) {
				job.setActive("Active");
			}
			else {
				job.setActive("Deactive");
			}
			jobDao.addJob(job);
		}
		
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	
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
		System.out.println("Enter Job Id which record you want to access:  ");
		id=Integer.parseInt(reader.readLine());
		Job job=jobDao.getJobById(id);
		System.out.println(job);
	}
	catch (IOException ex) {
		System.out.println(ex.getMessage());
	}
}
public void updateJob() {
	try {
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		int id;
		System.out.println("Enter the Job Id Which record you want to update:");
		id=Integer.parseInt(reader.readLine());
		Job job=jobDao.getJobById(id);
		jobDao.updateJob(job);
	}
	catch(IOException ex) {
		System.out.println(ex.getMessage());
	}
}
public void deactivateJob() {
	try {
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		int id;
		System.out.println("Enter the Job Id which record you want to deactivate:");
		id=Integer.parseInt(reader.readLine());
		Job job=jobDao.getJobById(id);
		jobDao.deactivateJob(job);
	}
	catch(IOException ex) {
		System.out.println(ex.getMessage());
	}
}
public void deleteJob() {
	try {
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		int id;
		System.out.println("Enter the JobId whose record you want to delete:");
		id=Integer.parseInt(reader.readLine());
		jobDao.deleteJob(id);
	}
	catch(IOException ex) {
		System.out.println(ex.getMessage());
	}
}
}
