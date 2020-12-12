package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PmWindow extends JFrame {
	Container container=null;
	JLabel lTitle;
	JButton bViewSkillEmployee,bAllAvaliableSkill,bAddJob,bViewAllJob,bViewSkillJob,bEmployeeListAppliedjob,bDeactivatejob,bSearch,bLogout;
	JPanel Pm;
	public PmWindow() {
		container=getContentPane();
		lTitle=new JLabel("Project Manager Window");
		Pm=new JPanel();
		Pm.add(lTitle);
		bViewSkillEmployee=new JButton ("View Skill Wise Employee List");
        bViewSkillEmployee.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
        
        bAllAvaliableSkill=new JButton ("View All  AVailable Skill");
        bAllAvaliableSkill.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
        
        
        bAddJob=new JButton ("Add Job");
        bAddJob.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					new AddJob();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
        
        bViewAllJob=new JButton ("View All Jobs");
        bViewAllJob.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new ViewAllJob();
				
			}
		});
        
        bViewSkillJob=new JButton ("View Skill Wise Jobs");
        bViewSkillJob.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
        
        bEmployeeListAppliedjob=new JButton ("View Employee List Who Applied For Job");
        bEmployeeListAppliedjob.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
        
        bDeactivatejob=new JButton ("Activate & Deactivate Job");
        bDeactivatejob.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new SetActiveJob();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
        bSearch=new JButton("Search Empolyee");
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
        
        bLogout=new JButton ("Log Out");
        bLogout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
        
        setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
        this.setTitle("PM Window Screen");
	    this.setVisible(true);
	    this.setBounds(10,10,500,600);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setResizable(false);

}
	public void setLayoutManager() {
		container.setLayout(null);
	}
	public void setLocationAndSize() {
		Pm.setBounds(0, 40, 500, 50);
		Pm.setBackground(Color.BLUE);
		lTitle.setFont(new Font("Verdana", Font.BOLD, 18));
		lTitle.setForeground(Color.white);
		bViewSkillEmployee.setBounds(100, 130, 300, 30);
		bAllAvaliableSkill.setBounds(100, 170, 300, 30);
		bAddJob.setBounds(100, 210, 300, 30);
		bViewAllJob.setBounds(100, 250, 300, 30);
		bViewSkillJob.setBounds(100, 290, 300, 30);
		bEmployeeListAppliedjob.setBounds(100, 330, 300, 30);
		bDeactivatejob.setBounds(100, 370, 300, 30);
		bSearch.setBounds(100, 410, 300, 30);
		bLogout.setBounds(100, 450, 300, 30);
		
		bViewSkillEmployee.setBackground(Color.ORANGE);
		bAllAvaliableSkill.setBackground(Color.ORANGE);
		bAddJob.setBackground(Color.ORANGE);
		bViewAllJob.setBackground(Color.ORANGE);
		bViewSkillJob.setBackground(Color.ORANGE);
		bEmployeeListAppliedjob.setBackground(Color.ORANGE);
		bDeactivatejob.setBackground(Color.ORANGE);
		bSearch.setBackground(Color.ORANGE);
		bLogout.setBackground(Color.ORANGE);
		
	}
	public void addComponentsToContainer() {
		container.add(Pm);
		container.add(bViewSkillEmployee);
		container.add(bAllAvaliableSkill);
		container.add(bAddJob);
		container.add(bViewAllJob);
		container.add(bViewSkillJob);
		container.add(bEmployeeListAppliedjob);
		container.add(bDeactivatejob);
		container.add(bSearch);
		container.add(bLogout);
	}
}
