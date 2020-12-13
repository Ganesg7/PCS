package view;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;

import controller.EmployeeController;
import model.Employee;

public class UpdateProfile extends JFrame{
	Container container;
	JLabel loldpass, lnewPassword; 
	JTextField  tOldPassword;
	JFrame f;
	
	JPasswordField tNewPassword;
	JButton bUpdate, bReset;
	 JRadioButton cShowPassword;
	EmployeeController empController=null;
	public UpdateProfile(Employee emp) throws ClassNotFoundException, SQLException {
		container=getContentPane();
		loldpass=new JLabel("Enter Old Password:");
		lnewPassword=new JLabel("Enter New Password :");		

		 f=new JFrame(); 
		tOldPassword=new JTextField();
		tNewPassword=new JPasswordField();
		bUpdate=new JButton("Update");
		empController=new EmployeeController();
		//Event handling for Login button
		bUpdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String newpassword;
				
				newpassword =new String(tNewPassword.getPassword());
				
				empController.updateEmployee(newpassword,emp.getEmpId());

	
					
						JOptionPane.showMessageDialog(f,"Error..!! Employee NOT Founed","## Error..!! ##",JOptionPane.YES_OPTION); 
						}
		});
	
		bReset=new JButton("Reset");

		bReset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					new Registrationframe();
					dispose();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		});
		cShowPassword=new  JRadioButton("Show Password");
		
		cShowPassword.addActionListener(new ActionListener() {
		

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (cShowPassword.isSelected()) {
				      tNewPassword.setEchoChar((char)0); 
				   } else {
				      tNewPassword.setEchoChar('*');
				   }
			}
		});
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		this.setTitle("Update Profile");
		this.setVisible(true);
		this.setBounds(10,10,500,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}
	public void setLayoutManager() {
		container.setLayout(null);
	}
	public void setLocationAndSize() {
		
		loldpass.setBounds(50, 100, 150, 30);
		lnewPassword.setBounds(50, 200, 150, 30);
		tOldPassword.setBounds(250, 100, 150, 30);
		tNewPassword.setBounds(250, 200, 150, 30);
		cShowPassword.setBounds(250, 250, 150, 30);
		bUpdate.setBounds(100, 300, 100, 30);
		bReset.setBounds(250, 300, 100, 30);
		bUpdate.setBackground(Color.red);
		bReset.setBackground(Color.green);
	}
	public void addComponentsToContainer() {
		
		
		container.add(lnewPassword);
		container.add(tOldPassword);
		container.add(loldpass);
		container.add(tNewPassword);
		container.add(cShowPassword);
		container.add(bUpdate);
		container.add(bReset);
			}
	
}