package test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import dao.IEmployeeDao;
import dao.IJobDao;
import dao.ISkillDao;
import daoimpl.EmpDao;
import daoimpl.JobDao;
import daoimpl.SkillDao;
import model.Employee;
import model.Job;
import model.Skill;

public class Testing {
	IJobDao jobDao=null;
	IEmployeeDao empDao=null;
	ISkillDao skillDao=null;

	@Test
	public void testgetJobId() {
		Job jobActual=new Job();
		Job jobExpected=new Job(4,	"HR","Placement Manager","PCS Automation"	,"Kochi","Arrange Placement For Students",	24000, "Active");
		jobActual=jobDao.getJobById(4);
		assertEquals(jobExpected.getJobTitle(), jobActual.getJobTitle());;  
	}

	@Test
	public void testAddEmployee() {
		Employee empActual=new Employee();
		empActual.setFirstName("Whalter");
		empActual.setLastName("White");
		empActual.setUserId("mr.white");
		empActual.setGender("Male");
		empActual.setPassword("wwhite");
		empActual.setRole("PME");
		empDao.addEmployee(empActual);
		
		Employee empExpected=new Employee("Whalter", "White", "mr.white", "wwhite", "Male", "PME");
		assertEquals(empExpected.getFirstName(), empActual.getFirstName());
		assertEquals(empExpected.getUserId(), empActual.getUserId());
	}
	
	@Test
	public void testGetAllEmployees() {
		List<Employee> allEmpList=empDao.getAllEmployee();
		
		assertNotNull(allEmpList);
		
		Employee emp =allEmpList.get(4);
		assertEquals(11, emp.getEmpId());
		
		Employee emp1 =allEmpList.get(4);
		assertEquals("Amy", emp1.getFirstName());

		assertTrue("Is Active ?", emp1.getActive().equals("Active"));
		
		assertThat(allEmpList.size(), is(4));
	}
	@Test
	public void testGetAllSkills() {
		List<Skill> allSkillList=skillDao.getAllSkill();
		
		Skill skill=allSkillList.get(4);
		assertEquals("React", skill.getSkillName());
		
		assertFalse("Is Active ?", skill.getActive().equals("Active"));
		
		assertThat(allSkillList.size(), is(4));
	}

}
