package view;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import controller.EmployeeController;
import model.EmployeeJob;
import model.Skill;

import javax.swing.JScrollPane;

public class EmployeeApplyJob extends JFrame{
	
	JTable table;
	EmployeeController empController=null;
	DefaultTableModel tableModel=null;
	
	public EmployeeApplyJob() 
	{
		try {
			
			empController=new EmployeeController();
			List<EmployeeJob> empjob= empController.getAllEmployeeJob();
			
			tableModel=new DefaultTableModel();
			JTable table=new JTable(tableModel);
			table.setPreferredScrollableViewportSize(table.getPreferredSize());
			
			tableModel.addColumn("EmployeeJob Id");
			tableModel.addColumn("Employee ID");
			tableModel.addColumn("Job Id");

			tableModel.addColumn(" Recruited ");
			
			for (EmployeeJob EmployeeJob:empjob) {
				tableModel.insertRow(0, new Object[] { EmployeeJob.getEJId(), EmployeeJob.getEmployeeId(), EmployeeJob.getJobId(), EmployeeJob.getRecruited()});	
			
			}
			 
			this.add(new JScrollPane(table));
			table=new JTable();
			this.setTitle("Employee Applyed For Job");
			this.setBounds(10,10,900,250);
			this.setVisible(true);
			this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			
	} catch (Exception e) {
		e.printStackTrace();
	}
		
	}  
	
	
}