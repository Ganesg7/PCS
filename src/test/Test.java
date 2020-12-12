package test;

import java.sql.SQLException;

import org.junit.Before;

import model.Employee;

public class Test {
	@Before
	public static setUpClass() {
	
		try {
		IEmployeeDao empDao=new EmployeeDao();
	}
		catch(SQLException ex) {
			
		}
		cathc(ClassNotFoundException ex){
			
		}
	}
	
		
	@Test
	public void testGetEmployeeById() {
	
	Employee empAcutal=new Employee();
	Employee empExpected=new Employee("Ganesh","Pandi E","Ganesh7","Ganesh@7","HRA","Male");
	empAcutal=empDao.getEmployeeById(8);
	assertEquals(empExpected,empActual);
	}

}
