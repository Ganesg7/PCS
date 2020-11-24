package view;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Registrationframe extends JFrame{

	Container container;
	JLabel First_Name,Last_Name, E_Mail, Phone_Number, Address ;
	JButton bSubmit,bReSet;
	public Registrationframe() {
		container=getContentPane();
		First_Name=new JLabel("First Name");
		Last_Name=new JLabel("Last Name");
		E_Mail=new JLabel("E-Mail");
		Phone_Number=new JLabel("Phine Number");
		Address=new JLabel("Address");
		bSubmit=new JButton("Submit");
		bReSet=new JButton("RESET");
		
		
		setLayoutManager();
		setLocationAndSize();
		this.setTitle("Registration Form");
		this.setVisible(true);
		this.setBounds(10,10,500,1600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}
public void setLayoutManager() {
	container.setLayout(null);
}
public void setLocationAndSize() {
	First_Name.setBounds(50, 100, 50, 25);
	Last_Name.setBounds(50, 200, 50, 25);
	E_Mail.setBounds(50, 250, 150, 25);
	Phone_Number.setBounds(100, 300, 150, 25);
	Address.setBounds(200, 300, 150, 25);
	bSubmit.setBounds(100, 400, 100, 25);
	bReSet.setBounds(200,400,100,25);
	
}
public void addComponentsToContainer() {
	container.add(First_Name);
	container.add(Last_Name);
	container.add(Phone_Number);
	container.add(E_Mail);
	container.add(Address);
	container.add(bSubmit);
	container.add(bReSet);
}
}

