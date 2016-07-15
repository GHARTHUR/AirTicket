package AirTicket.Dao;


import java.util.List;

import AirTicket.Data.Job;

public interface JobDao {
	int addJob(Job job);
	int delJob(int id);
	int updateJob(Job job);
	List<Job> findAll();
}
