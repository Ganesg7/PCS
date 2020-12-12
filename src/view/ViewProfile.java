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

import controller.EmployeeController;
import model.Employee;

public class ViewProfile extends JFrame {
	Container container=null;
	JLabel lName,lRole,lUserId,lGender,lStatus,lEmpId;
    JButton bBack;
	

    public ViewProfile(Employee userId) {

    	container=getContentPane();
        lEmpId=new JLabel("Employee Id:"+"   "+userId.getEmpId());
    	lName=new JLabel("NAME         :"+"   "+ userId.getFirstName()+" "+userId.getLastName());
    	lRole=new JLabel("Role            :"+"   "+ userId.getRole());
    	lUserId=new JLabel("User ID       :"+"   "+ userId.getUserId());
    	lGender=new JLabel("Gender       :"+"   "+ userId.getGender());
    	lStatus= new JLabel("Status         :"+"   "+ userId.getActive());
    	
        bBack=new JButton("Back");
    	bBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new LoginFrame();

					dispose();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
 
			}
			
		});
    	
    	setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		this.setTitle("Profile view Of "+userId.getFirstName()+userId.getLastName());
		this.setVisible(true);
		this.setBounds(10,10,500,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
    }
	public void setLayoutManager() {
		container.setLayout(null);
	}
	public void setLocationAndSize() {
		lEmpId.setBounds(70, 60, 300, 35);
		 lName.setBounds(70, 90, 300, 35);
		 lRole.setBounds(70, 120, 300, 35);
		 lUserId.setBounds(70, 150, 300, 35);
		 lGender.setBounds(70, 180, 300, 35);
		 lStatus.setBounds(70, 210, 300, 35);
		 lEmpId.setFont(new Font("SansSerif", Font.PLAIN, 18));
		 lName.setFont(new Font("SansSerif", Font.PLAIN, 18));
		 lRole.setFont(new Font("SansSerif", Font.PLAIN, 18));
		 lUserId.setFont(new Font("SansSerif", Font.PLAIN, 18));
		 lGender.setFont(new Font("SansSerif", Font.PLAIN, 18));
		 lStatus.setFont(new Font("SansSerif", Font.PLAIN, 18));
		 lEmpId.setForeground(Color.blue);
		 lName.setForeground(Color.blue);
		 lRole.setForeground(Color.blue);
		 lUserId.setForeground(Color.blue);
	     lGender.setForeground(Color.blue);
	     lStatus.setForeground(Color.blue);
	     
	     bBack.setBounds(175, 350, 100, 35);
	 	 bBack.setBackground(Color.green);
	}
	public void addComponentsToContainer() {
		container.add(lEmpId);
		container.add(lName);
		container.add(lRole);
		container.add(lUserId);
		container.add(lGender);
		container.add(lStatus);
		container.add(bBack);
	}
	
}
