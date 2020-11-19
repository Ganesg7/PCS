package daoimpl;
import java.sql.*;

import config.JDBCConnection;


public class EmployeeJobDao implements IEmployeeJobDao {
	Connection conn=null;
	public Employeejob() throws ClassNotFoundExcception,SQLEXception{
		conn=JDBCConnection.getDBConnection();
	}
	public void getAllEmployeeJob() {
		
	}

}
