package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

import controller.SkillController;

public class AddSkill extends JFrame{
	Container container=null;
	
	JLabel SkillName,SkillDec,ltitel;
	JTextField tSkillname,tSkillDec;
	JButton bAdd,brest;
	JFrame f; 
	JPanel Pm;
	SkillController skillController=null;
	public AddSkill() throws ClassNotFoundException, SQLException {
		container=getContentPane();
		 f=new JFrame();  
		SkillName=new JLabel("Enter The Skill Name:");
		SkillDec=new JLabel(" Enter The Skill Description:");
		ltitel=new JLabel("Add Skill");
		Pm=new JPanel();
		Pm.add(ltitel);
		tSkillname=new JTextField();
		tSkillDec=new JTextField();
		skillController=new SkillController();
		bAdd=new JButton("Add");
		bAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
					String skillName, skillDec;
					skillName=tSkillname.getText();
					skillDec=tSkillDec.getText();
					skillController.addSkill(skillName, skillDec);
					JOptionPane.showMessageDialog(f,"Skill Added","Successfully Add",JOptionPane.YES_OPTION);  
			         dispose();		
								
			}
		});
		
		brest=new JButton("Reset");
		brest.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				tSkillname.setText("");
				tSkillDec.setText("");
			}
		});
		
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		this.setTitle("HRA Window Screen");
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
		ltitel.setFont(new Font("Verdana", Font.BOLD, 18));
		ltitel.setForeground(Color.white);
		SkillName.setBounds(20, 100, 180, 30);
		SkillDec.setBounds(20, 140, 180, 30);
		tSkillname.setBounds(190, 100, 180, 30);
		tSkillDec.setBounds(190, 140, 180, 30);
		bAdd.setBounds(40, 250, 80, 30);
		brest.setBounds(200, 250, 80, 30);
		bAdd.setBackground(Color.green);
		brest.setBackground(Color.red);
	
	}
	public void addComponentsToContainer() {

		container.add(Pm);
		container.add(SkillName);
		container.add(SkillDec);
		container.add(tSkillDec);
		container.add(tSkillname);
		container.add(bAdd);
		container.add(brest);
	}
}

