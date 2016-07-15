package AirTicket.Dao;

import AirTicket.Data.Job;

public interface JobDao {
	int addJob(Job job);
	int delJob(int id);
	int updateJob(Job job);
}
