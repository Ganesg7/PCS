package daoimpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import config.JDBCConnection;
import dao.IEmployeeDao;
import model.Employee;



public class EmpDao implements IEmployeeDao{

	Connection conn=null;
	public EmpDao() throws ClassNotFoundException, SQLException{
		//Opened connection
		conn=JDBCConnection.getDBConnection();
	}
	public Employee checkLogin(String userId, String password) {
		Employee emp=new Employee();
		try{
			PreparedStatement pst=conn.prepareStatement("select * from Employee where userId=? and password=?");
			pst.setString(1, userId);
			pst.setString(2, password);
			ResultSet rst=pst.executeQuery();
			if(rst!=null) {
				if(rst.next()) {
					emp.setEmpId(rst.getInt(1));
					emp.setFirstName(rst.getString(2));
					emp.setLastName(rst.getString(3));
					emp.setUserId(rst.getString(4));
					emp.setPassword(rst.getString(5));
					emp.setGender(rst.getString(6));
					emp.setRole(rst.getString(7));	
					emp.setActive(rst.getString(8));
					
				}
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return emp; 
	}
	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> allEmpList=new ArrayList<Employee>();
		try{
			Statement stmt=conn.createStatement();
			ResultSet rst=stmt.executeQuery("select * from Employee");
			
			if(rst!=null) {
				Employee emp= null;
				while(rst.next()) {
					emp=new Employee();
					emp.setEmpId(rst.getInt(1));
					emp.setFirstName(rst.getString(2));
					emp.setLastName(rst.getString(3));
					emp.setUserId(rst.getString(4));
					emp.setPassword(rst.getString(5)) ;
					emp.setGender(rst.getString(6));
					
					emp.setRole(rst.getString(7));
					emp.setActive(rst.getString(8));
					allEmpList.add(emp);
				}
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		return allEmpList;
	}

	@Override
	public void addEmployee(Employee emp){
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("insert into Employee(FirstName,LastName,UserId,Password,Gender,Role,Active) values(?,?,?,?,?,?,?)");
			pst.setString(1, emp.getFirstName());
			pst.setString(2, emp.getLastName());
			pst.setString(3, emp.getUserId());
			pst.setString(4, emp.getPassword());
			pst.setString(5, emp.getGender());
			pst.setString(6, emp.getRole());
			pst.setString(7, emp.getActive());
			int i=pst.executeUpdate();
			if(i==1){
				System.out.println("1 record inserted...");
			}
			else {
				System.out.println("insertion failed...");
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
	}

 
	@Override
	public Employee getEmployeeById(int id) {
		
		Employee emp=new Employee();
		try{
			PreparedStatement pst=conn.prepareStatement("select * from Employee where EmployeeId=?");
			pst.setInt(1, id);
			ResultSet rst=pst.executeQuery();
			if(rst!=null) {
				if(rst.next()) {
					emp.setEmpId(rst.getInt(1));
					emp.setFirstName(rst.getString(2));
					emp.setLastName(rst.getString(3));
					emp.setUserId(rst.getString(4));
					emp.setPassword(rst.getString(5));
					emp.setGender(rst.getString(6));
					emp.setRole(rst.getString(7));
					emp.setActive(rst.getString(8));
				}
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		return emp;
	}

	@Override
	public void updateEmployee(Employee emp) {
		
		try
		{
			PreparedStatement pst=conn.prepareStatement("update  Employee set Password=? where EmployeeId=?");
		
  
		pst.setString(1, emp.getPassword());
		pst.setInt(2, emp.getEmpId());
		int i=pst.executeUpdate();
		if(i==1) {
			System.out.println("1 Record Updated....");
		}
		else {
			System.out.println("Updation failed...");
		}
	}
	catch(SQLException ex) {
		System.out.println(ex.getMessage());
	}
	}
	@Override
	public void deactivateEmployee(Employee emp) {
		
		try {
		PreparedStatement pst=conn.prepareStatement("Update Employee set Active=? where EmployeeId=?");
	    pst.setString(1, "Deactive");
	    pst.setInt(2, emp.getEmpId());
	    int i=pst.executeUpdate();
	  
	    
	}
	catch(SQLException ex) {
		System.out.println(ex.getMessage());
	}
		
	}

	@Override
	public void deleteEmployee(int id) {
		try{
			PreparedStatement pst=conn.prepareStatement("delete from Employee where EmployeeId=?");
		
		pst.setInt(1, id);
		int i=pst.executeUpdate();
		if(i==1) {
			System.out.println("Employee Deleted....");
		}
		else {
		    System.out.println("Deletion Failed...");	
		}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}
	@Override
	public void activateEmployee(Employee emp) {
		try {
		PreparedStatement pst=conn.prepareStatement("Update Employee set Active=? where EmployeeId=?");
	    pst.setString(1, "Active");
	    pst.setInt(2, emp.getEmpId());
	    int i=pst.executeUpdate();
	    
	    
	}
	catch(SQLException ex) {
		System.out.println(ex.getMessage());
	}
		
	}
	

	
}