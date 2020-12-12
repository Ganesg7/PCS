package entry;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


import view.LoginFrame;
import view.Registrationframe;

public class FrameTest extends JFrame
{
JButton b1;
JLabel l1;
public FrameTest()
{
setTitle("NIIT Portal");
setSize(400,400);
setLocationRelativeTo(null);
setDefaultCloseOperation(EXIT_ON_CLOSE);
setVisible(true);


setLayout(new BorderLayout());
JLabel background=new JLabel(new ImageIcon

("F:\\javaworkspace\\NIIT.jpg"));
add(background);
background.setLayout(new FlowLayout());
l1=new JLabel(" For Login (or) Registration");
b1=new JButton("<< Click Here >>");
b1.addActionListener(new ActionListener() {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			new LoginFrame();
	    dispose();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
	
});
background.add(b1);
background.add(l1);

setSize(399,399);
setSize(500,500);
}
 
	public static void main(String[] args)  {
			new FrameTest();
		
		//new LoginFrame();
		//new Registrationframe();


	}


}
