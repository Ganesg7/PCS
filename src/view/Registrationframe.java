package view;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.plaf.basic.BasicArrowButton;

import com.mysql.jdbc.PreparedStatement;

import config.JDBCConnection;

public class Registrationframe extends JFrame{

	Container container;
	JLabel lTitel,First_Name,Last_Name, E_Mail, Phone_Number, Address, lGender,lDepartment;
	JTextField tFirst_Name,tLast_Name, tE_Mail, tPhone_Number, tAddress ;
	JFrame f;  
	JPanel Pm;
	JComboBox Gender,Department;
	JButton bSubmit,bReSet,bBack;
	public Registrationframe()  throws ClassNotFoundException, SQLException {
		container=getContentPane();
		First_Name=new JLabel("First Name");
		Last_Name=new JLabel("Last Name");
		E_Mail=new JLabel("E-Mail");
		Phone_Number=new JLabel("Phone Number");
		Address=new JLabel("Address");
		lTitel=new JLabel("Registration Form");
		Pm=new JPanel();
		Pm.add(lTitel);
		  f=new JFrame();  
		tFirst_Name=new JTextField();
		tLast_Name=new JTextField();
		tE_Mail=new JTextField();
		tPhone_Number=new JTextField();
		tAddress=new JTextField();
		lGender=new JLabel("Gender");
		lDepartment=new JLabel("Department");
		Gender= new JComboBox();
		Gender.addItem("Male");
		Gender.addItem("Female");
		 Department=new JComboBox();
		 Department.addItem("HRA");
		 Department.addItem("PME");
		 Department.addItem("EMP");
		bSubmit=new JButton("Submit");
		bReSet=new JButton("RESET");
		bBack=new JButton("Back");
		bSubmit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (tFirst_Name.getText().isEmpty() || tLast_Name.getText().isEmpty() || tE_Mail.getText().isEmpty() || tPhone_Number.getText().isEmpty() || tAddress.getText().isEmpty())  {
					JOptionPane.showMessageDialog(f,"Please Fill The Fields To Contiune","Failed",JOptionPane.YES_OPTION);  
				}
				else {
					 try {
		                    
						 Connection conn = JDBCConnection.getDBConnection();

		                    PreparedStatement pst=(PreparedStatement) conn.prepareStatement("insert into registration(First_Name,Last_Name,E_Mail,Phone_Number,Address,lGender,lDepartment) values(?,?,?,?,?,?,?)");
		        			pst.setString(1,tFirst_Name.getText());
		        			pst.setString(2, tLast_Name.getText());
		        			pst.setString(3, tE_Mail.getText());
		        			pst.setLong(4, Long.parseLong(tPhone_Number.getText()));
		        			pst.setString(5, tAddress.getText());
		        			pst.setString(6, (String) Gender.getSelectedItem());
		        			pst.setString(7, (String) Department.getSelectedItem());
		        			int i=pst.executeUpdate();
		        			if(i==1){
		        				System.out.println("1 record inserted...");
		        			}
		        			else {
		        				System.out.println("insertion failed...");
		        			}
		                    
		                   }catch(SQLException se){
		                    se.printStackTrace();
		                } catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

							JOptionPane.showMessageDialog(f,"Successfully Updated.","updated",JOptionPane.YES_OPTION);  
				}
			}
			

		});
		
		bReSet.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
 
				  
				  tFirst_Name.setText("");
				  tLast_Name.setText("");
				  tE_Mail.setText("");
				  tPhone_Number.setText("");
				  tAddress.setText("");
			}
		
			
		});
		
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
		this.setTitle("Registration Form");
		this.setVisible(true);
		this.setBounds(10,10,500,700);
		
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
	First_Name.setBounds(50, 100, 80, 25);
	Last_Name.setBounds(50, 150, 80, 25);
	E_Mail.setBounds(50, 200, 80, 25);
	Phone_Number.setBounds(50, 250, 80, 25);
	Address.setBounds(50, 300, 80, 25);
	lGender.setBounds(50,350,80,25);
    lDepartment.setBounds(50, 400, 80, 25);
    Gender.setBounds(250,350,80,25);   
    Department.setBounds(250, 400, 80, 25);
	tFirst_Name.setBounds(250, 100, 150, 25);
	tLast_Name.setBounds(250, 150, 150, 25);
	tE_Mail.setBounds(250, 200, 150, 25);
	tPhone_Number.setBounds(250, 250, 150, 25);
	tAddress.setBounds(250, 300, 150, 25);
	Gender.setBackground(Color.orange);
	Department.setBackground(Color.orange);
	bSubmit.setBounds(100, 500, 100, 25);
	bReSet.setBounds(250,500,100,25);
	bBack.setBounds(175, 540, 100, 35);
	bReSet.setBackground(Color.red);
	 bSubmit.setBackground(Color.green);
	 bBack.setBackground(Color.green);
	
}
public void addComponentsToContainer() {
	container.add(Pm);
	container.add(First_Name);
	container.add(tFirst_Name);
	container.add(Last_Name);
	container.add(tLast_Name);
	container.add(Phone_Number);
	container.add(lGender);
	container.add(lDepartment);
	container.add(Gender);
	container.add(Department);
	container.add(tPhone_Number);
	container.add(E_Mail);
	container.add(tE_Mail);
	container.add(Address);
	container.add(tAddress);	
	container.add(bSubmit);
	container.add(bReSet);
	container.add(bBack);
}
}

