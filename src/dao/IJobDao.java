package dao;
import model.Job;
public interface IJobDao {

	void getAllJob();
	void addJob(Job job);
	Job getJobById(int id);
	void updateJob(Job job);
	void deactivatehJob(int id);
	void deleteJob(int id);
}

