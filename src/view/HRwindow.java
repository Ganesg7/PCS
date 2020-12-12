package view;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

import controller.EmployeeController;

public class HRwindow extends JFrame{

	Container container=null;
	JLabel HR;
	JButton bSetActive,bViewAllEmp, bViewSelectiveEmp, bAddSkill, bViewSkill, bSetDeactiveSkill, bLogout;
	JPanel hr;
	
	public HRwindow() {
		container=getContentPane();
		HR=new JLabel("Human Resources Window");
		hr=new JPanel();
		hr.add(HR);
		bSetActive=new JButton("Activate & Deactive Users");
		bSetActive.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					new SetActive();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		bViewAllEmp=new JButton("View all Employees");
		bViewAllEmp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new ViewAllEmp();
								
			}
		});
		
		bViewSelectiveEmp=new JButton("View Selective Employees");
		bViewSelectiveEmp.addActionListener(new ActionListener() {
			
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
        
		bAddSkill=new JButton("Add Your Skill");
		bAddSkill.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new AddSkill();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}				
			}
		});
  
		bViewSkill=new JButton("View Skill");
		bViewSkill.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
								
				new ViewAllSkill();
			}
		});
		
		bSetDeactiveSkill=new JButton("Activate & Deactivate Skill");
		bSetDeactiveSkill.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new SetActiveSkill();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
								
			}
		});
	
		bLogout=new JButton("Log Out");
		bLogout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					dispose();			
			}
		});
		
		

		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		this.setTitle("HRA Window Screen");
		this.setVisible(true);
		this.setBounds(10,10,500,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}
	public void setLayoutManager() {
		container.setLayout(null);
	}
	public void setLocationAndSize() {
		hr.setBounds(0, 50, 500, 50);
		hr.setBackground(Color.BLUE);
		HR.setFont(new Font("Verdana", Font.BOLD, 18));
		HR.setForeground(Color.white);
		bSetActive.setBounds(95, 150, 300, 30);
		
		bViewAllEmp.setBounds(95, 190, 300, 30);
		bViewSelectiveEmp.setBounds(95,230,300,30);
	    bAddSkill.setBounds(95, 270, 300, 30);
	    bViewSkill.setBounds(95, 310, 300, 30);
	    bSetDeactiveSkill.setBounds(95, 350, 300, 30);
	    bLogout.setBounds(95, 390, 300, 30);
		bSetActive.setBackground(Color.ORANGE);
		bViewAllEmp.setBackground(Color.ORANGE);
		bViewSelectiveEmp.setBackground(Color.ORANGE);
		bAddSkill.setBackground(Color.ORANGE);
		bViewSkill.setBackground(Color.ORANGE);
		bSetDeactiveSkill.setBackground(Color.ORANGE);
		bLogout.setBackground(Color.ORANGE);
	}
	public void addComponentsToContainer() {
		container.add(hr);
		container.add(bSetActive);
		container.add(bViewAllEmp);
		container.add(bViewSelectiveEmp);
		container.add(bAddSkill);
		container.add(bViewSkill);
		container.add(bSetDeactiveSkill);
		container.add(bLogout);
		
	}
}
