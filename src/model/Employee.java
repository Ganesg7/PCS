package model;

public class Employee {
	private int EmployeeId ;
	private String FirstName; 
	private String LastName ;
	private int UserId; 
	private String Password; 
	private String Gender ;
	private String   Role;
	private String Active;
public Employee() {
	
}
public Employee(int employeeId, String firstName, String lastName, int userId, String password, String gender,
		String role, String active) {
	super();
	EmployeeId = employeeId;
	FirstName = firstName;
	LastName = lastName;
	UserId = userId;
	Password = password;
	Gender = gender;
	Role = role;
	Active = active;
}
public int getEmployeeId() {
	return EmployeeId;
}
public void setEmployeeId(int employeeId) {
	EmployeeId = employeeId;
}
public String getFirstName() {
	return FirstName;
}
public void setFirstName(String firstName) {
	FirstName = firstName;
}
public String getLastName() {
	return LastName;
}
public void setLastName(String lastName) {
	LastName = lastName;
}
public int getUserId() {
	return UserId;
}
public void setUserId(int userId) {
	UserId = userId;
}
public String getPassword() {
	return Password;
}
public void setPassword(String password) {
	Password = password;
}
public String getGender() {
	return Gender;
}
public void setGender(String gender) {
	Gender = gender;
}
public String getRole() {
	return Role;
}
public void setRole(String role) {
	Role = role;
}
public String getActive() {
	return Active;
}
public void setActive(String active) {
	Active = active;
}
@Override
public String toString() {
	return "Employee [EmployeeId=" + EmployeeId + ", FirstName=" + FirstName + ", LastName=" + LastName + ", UserId="
			+ UserId + ", Password=" + Password + ", Gender=" + Gender + ", Role=" + Role + ", Active=" + Active + "]";
}


}

