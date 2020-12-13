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

import controller.EmployeeController;

public class ApplyJob extends JFrame{
	private static final long serialVersionUID = 1L;
	Container container;
	JLabel lRecruited,lEmployeeId,lJobId;
	JTextField tRecruited,tEmployeeId,tJobId;
	JButton bAdd,bReset;
	EmployeeController empController=null;
	JFrame f;
	public ApplyJob() throws ClassNotFoundException, SQLException {
		container=getContentPane();
		empController=new EmployeeController();
		 f = new JFrame();
		lRecruited=new JLabel("Recruited");
		lEmployeeId=new JLabel("Employee ID");
		lJobId=new JLabel("Job ID");
		tRecruited=new JTextField();
		tEmployeeId=new JTextField();
		tJobId=new JTextField();
		
		bAdd=new JButton("Add");
				bAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int empId,jobId;
				String recruited;
				recruited=tRecruited.getText();
				empId=Integer.parseInt(tEmployeeId.getText());
				jobId=Integer.parseInt(tJobId.getText());
				empController.addEmployeeJob(empId, jobId,recruited);
				JOptionPane.showMessageDialog(f,"Successfully Applyed.","Applyed",JOptionPane.YES_OPTION); 
			}
			
		});
				
				bReset=new JButton("Reset");
				bReset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				tEmployeeId.setText("");
				tJobId.setText("");
				tRecruited.setText("");
			}
			
		});
		
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		this.setTitle("Apply Job");
		this.setVisible(true);
		this.setBounds(10,10,500,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
	}


	private void setLayoutManager() {
		container.setLayout(null);
		
	}


	public void setLocationAndSize() {
		lEmployeeId.setBounds(20, 100, 120, 30);
		lJobId.setBounds(20, 150, 120, 30);
		lRecruited.setBounds(20, 200, 120, 30);
		
		tEmployeeId.setBounds(160, 100, 120, 30);
		tJobId.setBounds(160, 150, 120, 30);
		tRecruited.setBounds(160, 200, 120, 30);
		
		bAdd.setBounds(100, 350, 100, 30);
		bAdd.setBackground(Color.green);
		bReset.setBounds(350, 350, 100, 30);
		bReset.setBackground(Color.red);
	}
	
	public void addComponentsToContainer() {
		container.add(lEmployeeId);
		container.add(tEmployeeId);
		container.add(tJobId);
		container.add(lJobId);
		container.add(lRecruited);
		container.add(lJobId);
		container.add(tRecruited);
		container.add(bAdd);
		container.add(bReset);
		
	}
}