package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.SkillController;

public class SetActiveSkill extends JFrame {
	Container container=null;
	JLabel Act;
	JTextField tAct;
	JButton SetAct,SetDeact;
	JFrame f;  
	SkillController skillController=null;
	public SetActiveSkill() throws ClassNotFoundException, SQLException {
		container=getContentPane();
		Act=new JLabel("Enter The Skill ID :");
		tAct=new JTextField();
		f=new JFrame();  
		skillController=new SkillController();
		SetAct=new JButton("Activate");
		SetAct.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				     int SkillId;
					SkillId= Integer.parseInt(tAct.getText());
					
					skillController.activeSkill(SkillId);
					
					JOptionPane.showMessageDialog(f,"Activated.","Activated...!!",JOptionPane.YES_OPTION);  
					dispose();
				
				
			}
		});
		
		SetDeact=new JButton("Deactivate");
		SetDeact.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				     int SkillId;
					SkillId= Integer.parseInt(tAct.getText());
					
					skillController.deactivateSkill(SkillId);
					JOptionPane.showMessageDialog(f,"Deactivated.","Deactivated...!!",JOptionPane.YES_OPTION);  
					dispose();
				
			}
		});
		
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		this.setTitle("HRA Window Screen");
		this.setVisible(true);
		this.setBounds(10,10,500,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}
		
		public void setLayoutManager() {
			container.setLayout(null);
		}
		public void setLocationAndSize() {
			Act.setBounds(20, 100, 300, 30);
			Act.setForeground(Color.blue);
			tAct.setBounds(160, 100, 100, 30);
			SetAct.setBounds(60, 180, 110, 30);
			SetAct.setBackground(Color.green);
			SetDeact.setBounds(260, 180, 110, 30);
			SetDeact.setBackground(Color.red);
		
		}
		public void addComponentsToContainer() {
			container.add(Act);
			container.add(SetAct);
			container.add(tAct);
			container.add(SetDeact);
		}
	
	
}