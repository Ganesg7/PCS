package entry;

import java.sql.*;
import java.util.Scanner;

import config.JDBCConnection;
import controller.EmployeeController;
import controller.JobController;
import controller.SkillController;

public class EnteryClass {
	public void testConnection() throws ClassNotFoundException, SQLException{
		if(JDBCConnection.getDBConnection().isClosed()) {
			System.out.println("Connection is closed");
		}
		else {
			System.out.println("Connection is opened");
		}
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException{
	    System.out.println("1.Employee");
	    System.out.println("2.Job");
	    System.out.println("3.Skill");
	    System.out.println("Enter Your Choice");
		int Choice;
		int option;
		char ch='y';
		Scanner sc =new Scanner(System.in);
		Choice =sc.nextInt();
		switch (Choice) { 
		
		case 1:
		
		EmployeeController empController=new EmployeeController();
		

		
		while (ch=='y' || ch=='Y') {
			System.out.println("CRUD operation Menu:");
			System.out.println("1. View all employees records");
			System.out.println("2. view single employee record");
			System.out.println("3. add an employee");
			System.out.println("4. update an employee record");
			System.out.println("5. deactivate an employee record");
			System.out.println("6. delete an employee record");
			System.out.println("7. Exit");
			System.out.println("Enter your choice");
			
			option=sc.nextInt();
			switch (option) {
			case 1:
				System.out.println("Following are all Employees Details: ");
				empController.getAllEmployee();
				break;
			case 2:
				empController.getEmployeeById(null);
				break;
			case 3:
				System.out.println("Enter Employee Detail: ");
				empController.addEmployee();
				break;
			case 4:
				empController.updateEmployee(null, option);
				break;
			case 5:
				empController.deactiveEmployee(option);
				break;
			case 6:
	            empController.deleteEmployee();
				break;
			case 7:
	             System.exit(0);
				break;

			default:
				System.out.println("wrong input!!");
			}
			System.out.println("Do you want to continue? (y/n)");
			ch=sc.next().charAt(0);
		}
           
		case 2:
			JobController jobController=new JobController();
			
			
			
			while (ch=='y' || ch=='Y') {
				System.out.println("CRUD operation Menu:");
				System.out.println("1. View all Job records");
				System.out.println("2. view single Job record");
				System.out.println("3. add a Job");
				System.out.println("4. update a Job record");
				System.out.println("5. deactivate a Job record");
				System.out.println("6. delete a Job record");
				System.out.println("7. Exit");
				System.out.println("Enter your choice");
				
				option=sc.nextInt();
				switch (option) {
				case 1:
					System.out.println("Following are all JOB  Details: ");
					jobController.getAllJob();
					break;
				case 2:
					jobController.getJobById();
					break;
				case 3:
					System.out.println("Enter JOB Detail: ");
					jobController.addJob(null, null, null, null, null, option);
					break;
				case 4:
					jobController.updateJob();
					break;
				case 5:
					jobController.deactivateJob(option);
					break;
				case 6:
		            jobController.deleteJob();
					break;
				case 7:
		             System.exit(0);
					break;

				default:
					System.out.println("wrong input!!");
				}
				System.out.println("Do you want to continue? (y/n)");
				ch=sc.next().charAt(0);
			}
			
		
		case 3:
		
			SkillController skillController=new SkillController();
			
			
			
			while (ch=='y' || ch=='Y') {
				System.out.println("CRUD operation Menu:");
				System.out.println("1. View all Skill records");
				System.out.println("2. view single Skill record");
				System.out.println("3. add a Skill");
				System.out.println("4. update a Skill  record");
				System.out.println("5. deactivate a Skill record");
				System.out.println("6. delete a Skill record");
				System.out.println("7. Exit");
				System.out.println("Enter your choice");
				
				option=sc.nextInt();
				switch (option) {
				case 1:
					System.out.println("Following are all Skill Details: ");
					skillController.getAllSkill();
					break;
				case 2:
					skillController.getSkillById();
					break;
				case 3:
					System.out.println("Enter Skill Detail: ");
					skillController.addSkill(null, null);
					break;
				case 4:
					skillController.updateSkill();
					break;
				case 5:
					skillController.deactivateSkill(option);
					break;
				case 6:
		            skillController.deleteSkill();
					break;
				case 7:
		             System.exit(0);
					break;

				default:
					System.out.println("wrong input!!");
				}
				System.out.println("Do you want to continue? (y/n)");
				ch=sc.next().charAt(0);
			
	}

		default:
			System.out.println("Invalied Choice..!!!");
			break;
		
		}
	
	
		}

	
	}





