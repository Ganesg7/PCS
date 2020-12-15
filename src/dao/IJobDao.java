package dao;
import model.Job;
import java.util.List;
public interface IJobDao {

	List<Job> getAllJob();
	void addJob(Job job);
	Job getJobById(int id);
	void updateJob(Job job);
	void deactivateJob(Job job, String string);
	void deleteJob(int id);
	void activateJob(Job job);
	void deactivateJob(Job job);
	

}

