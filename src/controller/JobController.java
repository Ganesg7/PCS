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
  
	public Job addJob(String jobTitel, String jobDec, String cmName, String location, String keySkill, int salary) {
		Job job=new Job();
		job.setJobTitle(jobTitel);
		    job.setJobDescription(jobDec);
			job.setCompanyName(cmName);
			job.setLocation(location);
			job.setKeySkill(keySkill);
			job.setSalary(salary);
		
			if(jobTitel.equals("HR") || jobTitel.equals("Web-Devloper") || jobTitel.equals("java Devloper") || jobTitel.equals("Angular Devloper") ) {
				job.setActive("Active");
			}
			else {
				job.setActive("Deactive");
			}
			jobDao.addJob(job);
			return job;
		}

	
	
			
	public List<Job> getAllJob() {
		List<Job> allJobList=jobDao.getAllJob();
	return allJobList;
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
public void deactivateJob(int jobId) {
	Job job=jobDao.getJobById(jobId);
	jobDao.deactivateJob(job);
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

public void activeJob(int jobId) {
	
	Job job=jobDao.getJobById(jobId);
	jobDao.activateJob(job);
	
}
}
