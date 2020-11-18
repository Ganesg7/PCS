package model;

public class Job {
	
	private int JobId;
	private String JobTitle;
	private String JobDescription;
	private String CompanyName;
	private String Location;
	private String KeySkill ;
	private int Salary ;
	private String Active;
 public Job() {
	 
 }
public Job(int jobId, String jobTitle, String jobDescription, String companyName, String location, String keySkill,
		int salary, String active) {
	super();
	JobId = jobId;
	JobTitle = jobTitle;
	JobDescription = jobDescription;
	CompanyName = companyName;
	Location = location;
	KeySkill = keySkill;
	Salary = salary;
	Active = active;
}
public int getJobId() {
	return JobId;
}
public void setJobId(int jobId) {
	JobId = jobId;
}
public String getJobTitle() {
	return JobTitle;
}
public void setJobTitle(String jobTitle) {
	JobTitle = jobTitle;
}
public String getJobDescription() {
	return JobDescription;
}
public void setJobDescription(String jobDescription) {
	JobDescription = jobDescription;
}
public String getCompanyName() {
	return CompanyName;
}
public void setCompanyName(String companyName) {
	CompanyName = companyName;
}
public String getLocation() {
	return Location;
}
public void setLocation(String location) {
	Location = location;
}
public String getKeySkill() {
	return KeySkill;
}
public void setKeySkill(String keySkill) {
	KeySkill = keySkill;
}
public String getSalary() {
	return Salary;
}
public void setSalary(int salary) {
	Salary = salary;
}
public String getActive() {
	return Active;
}
public void setActive(String active) {
	Active = active;
}
@Override
public String toString() {
	return "Job [JobId=" + JobId + ", JobTitle=" + JobTitle + ", JobDescription=" + JobDescription + ", CompanyName="
			+ CompanyName + ", Location=" + Location + ", KeySkill=" + KeySkill + ", Salary=" + Salary + ", Active="
			+ Active + "]";
}

}
