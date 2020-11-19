package controller;
import java.io.*;
import model.Job;

public class JobController {

	public Employee addEmployee() {
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
			job.setSalary(reader.readLine());
			if(Jobtitel.equals("HRA")) {
				job.setActive("Active");
			}
			else {
				job.setActive("Deactive");
			}
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
		return job;
	}
			
	}
