package view;

import java.awt.*;
import view.LoginFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

import model.Employee;

public class EmployeeWindow extends JFrame{

	Container container=null;
	JLabel lTitle;
	static JLabel lName;
	JPanel p1,p2;
	JButton bView,bUpdateProfile,bupdateSkill,bSearch,bLogout;
	public EmployeeWindow(Employee emp) {
		container=getContentPane();
		lTitle=new JLabel("Employee Window Screen");
		lName=new JLabel("Employee Name: "+emp.getFirstName()+" "+emp.getLastName());
		p1=new JPanel();
		p1.add(lTitle);
		
		p2=new JPanel();
		p2.add(lName);
		bView =new JButton("View Profile");
		bUpdateProfile=new JButton("Update Profile");
		bupdateSkill=new JButton("Update Skill");
		bSearch=new JButton("Search Employee");
		bLogout=new JButton("Log Out");
		
		

		bView.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
                	
				new ViewProfile(emp);
			}
			});
		
		
		bUpdateProfile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new UpdateProfile();
				
				
			}
		});
		
		
		bupdateSkill.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		
		bSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
                	
				try {
					new SearchEmp();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			});
		
		bLogout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		
		
		
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		this.setTitle("Employee Window Screen");
		this.setVisible(true);
		this.setBounds(10,10,500,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}
	public void setLayoutManager() {
		container.setLayout(null);
	}
	public void setLocationAndSize() {
		p1.setBounds(0, 30, 500, 50);
		p1.setBackground(Color.BLUE);
		
		lTitle.setFont(new Font("Verdana", Font.BOLD, 18));
		lTitle.setForeground(Color.white);
		p2.setBounds(45, 85, 250, 50);
		lName.setFont(new Font("Verdana", Font.ITALIC, 13));
		bView.setBounds(170, 150, 150, 30);
		bUpdateProfile.setBounds(170, 200, 150, 30);
		bupdateSkill.setBounds(170, 250, 150, 30);
		bSearch.setBounds(170, 300, 150, 30);
		bLogout.setBounds(170, 350, 150, 30);
		bView.setBackground(Color.ORANGE);
		bUpdateProfile.setBackground(Color.ORANGE);
		bupdateSkill.setBackground(Color.ORANGE);
		bSearch.setBackground(Color.ORANGE);
		bLogout.setBackground(Color.ORANGE);
	}
	public void addComponentsToContainer() {
		container.add(p1);
		container.add(p2);
		container.add(bView);
		container.add(bUpdateProfile);
		container.add(bupdateSkill);
		container.add(bSearch);
		container.add(bLogout);
		
	}
}

