package view;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import controller.SkillController;
import model.Skill;

import javax.swing.JScrollPane;

public class ViewAllSkill extends JFrame{
	
	JTable table;
	SkillController skillController=null;
	DefaultTableModel tableModel=null;
	
	public ViewAllSkill() 
	{
		try {
			
			skillController=new SkillController();
			List<Skill> skilll= skillController.getAllSkill();
			
			tableModel=new DefaultTableModel();
			JTable table=new JTable(tableModel);
			table.setPreferredScrollableViewportSize(table.getPreferredSize());
			
			tableModel.addColumn("Skill Id");
			tableModel.addColumn("Skill Name");
			tableModel.addColumn("Skill Description");

			tableModel.addColumn("Active");
			
			for (Skill skill:skilll) {
				tableModel.insertRow(0, new Object[] { skill.getSkillId(), skill.getSkillName(), skill.getSkillDescription(), skill.getActive() });	
			
			}
			 
			this.add(new JScrollPane(table));
			table=new JTable();
			this.setTitle("All Skill Details");
			this.setBounds(10,10,900,250);
			this.setVisible(true);
			this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			
	} catch (Exception e) {
		e.printStackTrace();
	}
		
	}  
	
	
}