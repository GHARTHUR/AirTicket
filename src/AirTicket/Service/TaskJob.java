package AirTicket.Service;


import java.io.IOException;
import java.security.GeneralSecurityException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.json.JSONException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import AirTicket.Dao.JobDao;
import AirTicket.Dao.PriceDao;
import AirTicket.Dao.UserDao;
import AirTicket.Data.Job;
import AirTicket.Data.Price;

@Component("taskJob")  
public class TaskJob {

	@Resource
	QunaerApi qapi;
	@Resource
	JobDao jobdao;
	@Resource
	PriceDao pricedao;
	@Resource
	UserDao userdao;
	@Resource
	Mail mail;
	
    @Scheduled(cron = "0 * * * * ?")//0 0/30 * * * ?  
    public void job1() throws IOException, JSONException, GeneralSecurityException {  
    	List<Job> job = jobdao.findAll();
    	for(Job temp : job){
    		if(temp.getAirdate().before(new Date())){
    			jobdao.delJob(temp.getId());
    		}
    		int price = qapi.getAirPrice(DateFormat.getDateInstance().format(temp.getAirdate()), temp.getAirfrom(), temp.getAirto());
    		if(temp.getLmoney()>price){
    			temp.setLmoney(price);
    			mail.mainto(temp,userdao.findById(temp.getUserid()));
    			jobdao.updateJob(temp);
    		}
    		Timestamp currentDate = new Timestamp(System.currentTimeMillis());
    		Price pc = new Price();
    		pc.setAirfrom(temp.getAirfrom());
    		pc.setAirtime(currentDate);
    		pc.setAirdate(temp.getAirdate());
    		pc.setAirto(temp.getAirto());
    		pc.setPrice(price);
    		pricedao.addPrice(pc);
    	}
        System.out.println("完成一次机票信息采集");  
    }  
}  