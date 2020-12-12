package view;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;

import controller.EmployeeController;
import model.Employee;

public class LoginFrame extends JFrame{
	Container container;
	JLabel lUserId, lPassword, lMessage,lMessage1,lTitel;
	JTextField tUserId;
	JFrame f;
	JPanel Pm;
	JPasswordField tPassword;
	JButton bLogin, bRegister;
	 JRadioButton cShowPassword;
	EmployeeController empController=null;
	public LoginFrame() throws ClassNotFoundException, SQLException {
		container=getContentPane();
		lUserId=new JLabel("USERNAME :");
		lPassword=new JLabel("PASSWORD :");
		lMessage=new JLabel();
		lMessage1=new JLabel();
		lTitel=new JLabel("Login Form");
		Pm=new JPanel();
		Pm.add(lTitel);
		 f=new JFrame(); 
		tUserId=new JTextField();
		tPassword=new JPasswordField();
		bLogin=new JButton("LOGIN");
		empController=new EmployeeController();
		//Event handling for Login button
		bLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String userId,password;
				userId=tUserId.getText();
				password=new String(tPassword.getPassword());
				//System.out.println(userId+" "+password);
				Employee emp = empController.checkLogin(userId, password);
				//System.out.println(emp.getActive());
				if(userId.isEmpty()) {
					lMessage.setText("User Id Is Empty...!!");
				}
	
		else if(password.isEmpty()) {
			lMessage1.setText("Password Is Empty...!!");
		}
		
				else {
					if(emp.getActive().equals("Active")) {
						if(emp.getRole().equals("HRA")) {
							new HRwindow();
							dispose();
						}
						else if(emp.getRole().equals("PME")) {
							new PmWindow();
							dispose();
						}
						else {
							new EmployeeWindow(emp);
							dispose();
						}
					}
					else {
						JOptionPane.showMessageDialog(f,"Error..!! Employee NOT Founed","## Error..!! ##",JOptionPane.YES_OPTION); 
					}
				}
				
			}
			
		});
		bRegister=new JButton("REGISTER");
		//Event handling for Register button
		bRegister.addActionListener(new ActionListener() {

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
				      tPassword.setEchoChar((char)0); 
				   } else {
				      tPassword.setEchoChar('*');
				   }
			}
		});
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		this.setTitle("Login Form");
		this.setVisible(true);
		this.setBounds(10,10,500,500);
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
		lMessage.setBounds(250, 170, 300, 30);
		lMessage.setFont(new Font("Verdana", Font.BOLD, 12));
		lMessage.setForeground(Color.red);
		lMessage1.setBounds(250, 270, 300, 30);
		lMessage1.setFont(new Font("Verdana", Font.BOLD, 12));
		lMessage1.setForeground(Color.red);
		lUserId.setBounds(50, 150, 100, 30);
		lPassword.setBounds(50, 250, 100, 30);
		tUserId.setBounds(250, 150, 150, 30);
		tPassword.setBounds(250, 250, 150, 30);
		cShowPassword.setBounds(250, 300, 150, 30);
		bLogin.setBounds(100, 400, 100, 30);
		bRegister.setBounds(250, 400, 100, 30);
		bLogin.setBackground(Color.red);
		bRegister.setBackground(Color.green);
	}
	public void addComponentsToContainer() {
		
		container.add(Pm);
		container.add(lUserId);
		container.add(tUserId);
		container.add(lPassword);
		container.add(tPassword);
		container.add(cShowPassword);
		container.add(bLogin);
		container.add(bRegister);
		container.add(lMessage);
		container.add(lMessage1);
	}
	
}