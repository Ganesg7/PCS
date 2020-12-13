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

public class AddEmployee extends JFrame{

	Container container;
	JLabel lTitel,First_Name,Last_Name, UserId, Password,  lGender,lRole;
	JTextField tFirst_Name,tLast_Name, tUserId, tPassword;
	JFrame f;  
	JPanel Pm;
	JComboBox Gender,Role;
	JButton bSubmit,bReSet,bBack;
	public AddEmployee()  throws ClassNotFoundException, SQLException {
		container=getContentPane();
		First_Name=new JLabel("First Name");
		Last_Name=new JLabel("Last Name");
		UserId=new JLabel("User ID");
		Password=new JLabel("Password");
		
		lTitel=new JLabel("Add Employee");
		Pm=new JPanel();
		Pm.add(lTitel);
		  f=new JFrame();  
		tFirst_Name=new JTextField();
		tLast_Name=new JTextField();
		tUserId=new JTextField();
		tPassword=new JTextField();
		lGender=new JLabel("Gender");
		lRole=new JLabel("Role");
		Gender= new JComboBox();
		Gender.addItem("Male");
		Gender.addItem("Female");
		 Role=new JComboBox();
		 Role.addItem("HRA");
		 Role.addItem("PME");
		 Role.addItem("EMP");
		bSubmit=new JButton("Submit");
		bReSet=new JButton("RESET");
		bBack=new JButton("Back");
		bSubmit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (tFirst_Name.getText().isEmpty() || tLast_Name.getText().isEmpty() || tUserId.getText().isEmpty() || tPassword.getText().isEmpty() )  {
					JOptionPane.showMessageDialog(f,"Please Fill The Fields To Contiune","Failed",JOptionPane.YES_OPTION);  
				}
				else {
					 try {
		                    
						 Connection conn = JDBCConnection.getDBConnection();

		                    PreparedStatement pst=(PreparedStatement) conn.prepareStatement("insert into Employee(FirstName,LastName,UserId,Password,Gender,Role) values(?,?,?,?,?,?)");
		        			pst.setString(1,tFirst_Name.getText());
		        			pst.setString(2, tLast_Name.getText());
		        			pst.setString(3, tUserId.getText());
		        			pst.setString(4, tPassword.getText());
		        			
		        			pst.setString(5, (String) Gender.getSelectedItem());
		        			pst.setString(6, (String) Role.getSelectedItem());
		        			
		        			int i=pst.executeUpdate();
		        			
		                   }catch(SQLException se){
		                    se.printStackTrace();
		                } catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

							JOptionPane.showMessageDialog(f,"Successfully Added.","updated",JOptionPane.YES_OPTION);  
				}
			}
			

		});
		
		bReSet.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
 
				  
				  tFirst_Name.setText("");
				  tLast_Name.setText("");
				  tUserId.setText("");
				  tPassword.setText("");
				  			}
		
			
		});
		
		bBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new PmWindow();
				dispose();
 
			}
			
		});
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		this.setTitle("Add Employee");
		this.setVisible(true);
		this.setBounds(10,10,500,600);
		
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
	UserId.setBounds(50, 200, 80, 25);
	Password.setBounds(50, 250, 80, 25);
	
	lGender.setBounds(50,300,80,25);
    lRole.setBounds(50, 350, 80, 25);
    Gender.setBounds(250,300,80,25);   
    Role.setBounds(250, 350, 80, 25);
	tFirst_Name.setBounds(250, 100, 150, 25);
	tLast_Name.setBounds(250, 150, 150, 25);
	tUserId.setBounds(250, 200, 150, 25);
	tPassword.setBounds(250, 250, 150, 25);
	
	Gender.setBackground(Color.orange);
	Role.setBackground(Color.orange);
	bSubmit.setBounds(100, 400, 100, 25);
	bReSet.setBounds(250,400,100,25);
	bBack.setBounds(175, 440, 100, 35);
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
	container.add(Password);
	container.add(lGender);
	container.add(lRole);
	container.add(Gender);
	container.add(Role);
	container.add(tPassword);
	container.add(UserId);
	container.add(tUserId);
	
	container.add(bSubmit);
	container.add(bReSet);
	container.add(bBack);
}
}

