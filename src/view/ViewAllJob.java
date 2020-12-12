package view;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import controller.JobController;
import model.Job;

import javax.swing.JScrollPane;

public class ViewAllJob extends JFrame{
	
	JTable table;
	JobController jobController=null;
	DefaultTableModel tableModel=null;
	
	public ViewAllJob() 
	{
		try {
			
			jobController=new JobController();
			List<Job> jobl= jobController.getAllJob();
			
			tableModel=new DefaultTableModel();
			JTable table=new JTable(tableModel);
			table.setPreferredScrollableViewportSize(table.getPreferredSize());
			
			tableModel.addColumn("Job Id");
			tableModel.addColumn("Job Title");
			tableModel.addColumn("Job Description");
			tableModel.addColumn("Company Name");
			tableModel.addColumn("Location");
			tableModel.addColumn("Key Skill");

			tableModel.addColumn("Salary");
			tableModel.addColumn("Active");
			
			for (Job job:jobl) {
				tableModel.insertRow(0, new Object[] { job.getJobId(), job.getJobTitle(), job.getJobDescription(), job.getCompanyName(), job.getLocation(), job.getKeySkill(),  job.getSalary(), job.getActive() });	

			}
			 
			this.add(new JScrollPane(table));
			table=new JTable();
			this.setTitle("All Employee Details");
			this.setBounds(10,10,900,250);
			this.setVisible(true);
			this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			
	} catch (Exception e) {
		e.printStackTrace();
	}
		
	}  
	
	
}