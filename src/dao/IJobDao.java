package dao;
import model.Job;
import java.util.List;
public interface IJobDao {

	List<Job> getAllJob();
	void addJob(Job job);
	Job getJobById(int id);
	void updateJob(Job job);
	void deactivatehJob(int id);
	void deleteJob(int id);
}

