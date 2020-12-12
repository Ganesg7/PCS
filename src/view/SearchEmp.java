package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

import controller.EmployeeController;
import model.Employee;


public class SearchEmp extends JFrame{
	Container container;
    JLabel lEmployeeID,lTitel;
    JFrame f;
    JPanel Pm;
    JTextField tEmployeeId;
    JButton bSearch;
    EmployeeController empController=null;
	public SearchEmp() throws ClassNotFoundException, SQLException {
		container=getContentPane();
		lTitel=new JLabel("Search Employee");
		Pm=new JPanel();
		Pm.add(lTitel);
		
		lEmployeeID=new JLabel("Enter The Employee ID You Want Search:-");
		tEmployeeId=new JTextField();
		
		 f=new JFrame();
		bSearch=new JButton("Search");
		empController=new EmployeeController();
		
		bSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
			String userId;
				userId=tEmployeeId.getText();
				
				Employee emp=new Employee();
				
				emp=empController.getEmployeeById(userId);
				
				if(userId==null) {
					JOptionPane.showMessageDialog(f,"Enter The Employee Id.","updated",JOptionPane.YES_OPTION);
				}
				else {
				new ViewProfile(emp);
				}
			}
			
		});
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		this.setTitle("Employee Search Screen");
		this.setVisible(true);
		this.setBounds(10,10,500,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}
	public void setLayoutManager() {
		container.setLayout(null);
	}
	public void setLocationAndSize() {
		Pm.setBounds(0, 15, 500, 50);
		Pm.setBackground(Color.BLUE);
		lTitel.setFont(new Font("Verdana", Font.BOLD, 18));
		lTitel.setForeground(Color.white);
		lEmployeeID.setBounds(10, 80, 300, 30);
		lEmployeeID.setFont(new Font("Verdana", Font.BOLD, 12));
		lEmployeeID.setForeground(Color.blue);
		tEmployeeId.setBounds(310, 80, 150, 30);
		bSearch.setBounds(315, 120, 100, 30);
	}
	public void addComponentsToContainer() {
		container.add(lEmployeeID);
		container.add(tEmployeeId);
		container.add(Pm);

		container.add(bSearch);
	}

}

