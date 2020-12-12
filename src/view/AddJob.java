package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

import controller.JobController;

public class AddJob extends JFrame{
	Container container=null;
	JLabel lTitel;
	JLabel JobTitel,JobDec,CmName,Location,keySkill,Salary;
	JTextField tJobTitel,tJobDec,tCmName,tLocation,tkeyskill,tsalary;
	JButton bAdd,breset;
	JPanel pm;
	JFrame f; 
	JobController jobController=null;
	public AddJob() throws ClassNotFoundException, SQLException {
		container=getContentPane();
		 f=new JFrame();  
		 lTitel=new JLabel("Add JOB");
		 pm=new JPanel();
		 pm.add(lTitel);
		 JobTitel=new JLabel("Enter The Job Titel:");
		JobDec=new JLabel(" Enter The Job Description:");
		CmName=new JLabel("Company Name:");
		Location=new JLabel("Location:");
		keySkill=new JLabel("Key Skill:");
		Salary=new JLabel("Salary:");
		
		tJobTitel=new JTextField();
		tJobDec=new JTextField();
		tCmName=new JTextField();
		tLocation=new JTextField();
		tkeyskill=new JTextField();
		tsalary=new JTextField();
		jobController=new JobController();
		
		bAdd=new JButton("Add");
		bAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
					String jobTitel, jobDec,cmName,Location,keySkill;
					int salary;
					jobTitel=tJobTitel.getText();
					jobDec=tJobDec.getText();
					cmName=tCmName.getText();
					Location=tLocation.getText();
					keySkill=tkeyskill.getText();
					salary=Integer.parseInt(tsalary.getText());
					jobController.addJob(jobTitel, jobDec,cmName,Location,keySkill,salary);
					JOptionPane.showMessageDialog(f,"Skill Added","Successfully Add",JOptionPane.YES_OPTION);  
			         dispose();		
								
			}
		});
		
		breset=new JButton("Reset");
		breset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				tJobTitel.setText("");
				tJobDec.setText("");
				tCmName.setText("");
				tLocation.setText("");
				tkeyskill.setText("");
				tsalary.setText("");
			}
		});
		
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		this.setTitle("PME Window Screen");
		this.setVisible(true);
		this.setBounds(10,10,500,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}
	public void setLayoutManager() {
		container.setLayout(null);
	}
	public void setLocationAndSize() {
		pm.setBounds(0, 10, 500, 50);
		pm.setBackground(Color.BLUE);
		lTitel.setFont(new Font("Verdana", Font.BOLD, 18));
		lTitel.setForeground(Color.white);
		
		JobTitel.setBounds(20, 80, 180, 30);
		JobDec.setBounds(20, 130, 180, 30);
		CmName.setBounds(20, 180, 180, 30);
		Location.setBounds(20, 220, 180, 30);
		keySkill.setBounds(20, 270, 180, 30);
		Salary.setBounds(20, 320, 180, 30);;
		
		tJobTitel.setBounds(190, 80, 180, 30);
		tJobDec.setBounds(190, 130, 180, 30);
		tCmName.setBounds(190, 180, 180, 30);
		tLocation.setBounds(190, 220, 180, 30);
		tkeyskill.setBounds(190, 270, 180, 30);
		tsalary.setBounds(190, 320, 180, 30);
		
		bAdd.setBounds(40, 400, 80, 30);
		breset.setBounds(350, 400, 80, 30);
		bAdd.setBackground(Color.green);
		breset.setBackground(Color.red);
	
	}
	public void addComponentsToContainer() {

		container.add(pm);
		container.add(JobTitel);
		container.add(JobDec);
		container.add(Location);
		container.add(CmName);
		container.add(Salary);
		container.add(keySkill);
		container.add(tJobDec);
		container.add(tJobTitel);
		container.add(tCmName);
		container.add(tLocation);
		container.add(tkeyskill);
		container.add(tsalary);
		container.add(bAdd);
		container.add(breset);
	}
}

