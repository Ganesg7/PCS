package test;
import static org.junit.Assert.assertEquals;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.BeforeClass;
import dao.IEmployeeDao;
import daoimpl.EmpDao;
import model.Employee;

public class Test {
	IEmployeeDao empDao=null;
	@Before
	public void setup() {
		try {
			empDao=new EmpDao();
		}
		catch(SQLException ex) {
		
		}
		catch(ClassNotFoundException ex) {
			
		}
	}
	
	@Test
	public void testGetEmployeeById() {
		Employee empActual=new Employee();
		Employee empExpected=new Employee (11,"Amy","Santigo","amy99","amy@99","EMP","Female","Active");
		empActual=(Employee)empDao.getEmployeeById(2);
		
		assertEquals(empExpected.getFirstName(),empActual.getFirstName(),empActual.getUserId(),empActual.getPassword(),empActual.getRole(),empActual.getActive());
		
	}

}