package view;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import controller.EmployeeController;
import model.Employee;

import javax.swing.JScrollPane;

public class ViewAllEmp extends JFrame{
	
	JTable table;
	EmployeeController empController=null;
	DefaultTableModel tableModel=null;
	
	public ViewAllEmp() 
	{
		try {
			
			empController=new EmployeeController();
			List<Employee> empl= empController.getAllEmployee();
			
			tableModel=new DefaultTableModel();
			JTable table=new JTable(tableModel);
			table.setPreferredScrollableViewportSize(table.getPreferredSize());
			
			tableModel.addColumn("Employee ID");
			tableModel.addColumn("First Name");
			tableModel.addColumn("Last Name");
			tableModel.addColumn("UserID");
			tableModel.addColumn("Password");
			tableModel.addColumn("Gender");

			tableModel.addColumn("Role");
			tableModel.addColumn("Active");
			
			for (Employee emp:empl) {
				tableModel.insertRow(0, new Object[] { emp.getEmpId(), emp.getFirstName(), emp.getLastName(), emp.getUserId(), emp.getPassword(), emp.getGender(),  emp.getRole(), emp.getActive() });	

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