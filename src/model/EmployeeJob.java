package model;

public class EmployeeJob {
	private int EJId;
	private int EmployeeId;
	private int JobId;
	private String Recruited;

	public EmployeeJob() {
		
	}

	public EmployeeJob(int eJId, int employeeId, int jobId, String recruited) {
		super();
		EJId = eJId;
		EmployeeId = employeeId;
		JobId = jobId;
		Recruited = recruited;
	}

	public int getEJId() {
		return EJId;
	}

	public void setEJId(int eJId) {
		EJId = eJId;
	}

	public int getEmployeeId() {
		return EmployeeId;
	}

	public void setEmployeeId(int employeeId) {
		EmployeeId = employeeId;
	}

	public int getJobId() {
		return JobId;
	}

	public void setJobId(int jobId) {
		JobId = jobId;
	}

	public String getRecruited() {
		return Recruited;
	}

	public void setRecruited(String recruited) {
		Recruited = recruited;
	}

	@Override
	public String toString() {
		return "EmployeeJob [EJId=" + EJId + ", EmployeeId=" + EmployeeId + ", JobId=" + JobId + ", Recruited="
				+ Recruited + "]";
	}

}
