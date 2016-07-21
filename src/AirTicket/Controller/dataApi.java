package AirTicket.Controller;

import java.util.List;

import javax.annotation.Resource;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import AirTicket.Dao.JobDao;
import AirTicket.Dao.PriceDao;
import AirTicket.Dao.UserDao;
import AirTicket.Data.Job;
import AirTicket.Data.Price;

@Controller
public class dataApi {
	@Resource
	private PriceDao priceDao;
	@Resource
	private JobDao jobdao;
	@Resource
	private UserDao userdao;
	
	
	@ResponseBody
	@RequestMapping(value="price",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	public String getPrice(Integer userid) throws JSONException{
		JSONArray totol = new JSONArray();
		if(userid == null ) return "ERROR";
		List<Job> job = jobdao.findByUserId(userid);
		for(Job dd : job){
			JSONArray ans = new JSONArray();
			List<Price> data = priceDao.findPriceByFromTo(dd.getAirfrom(), dd.getAirto());
			data = data.subList(data.size()-20>=0?data.size()-20:0, data.size());
			for(Price temp : data){
				JSONObject js = new JSONObject();
				js.put("price", temp.getPrice());
				js.put("time", temp.getAirtime());
				js.put("from", temp.getAirfrom());
				js.put("to", temp.getAirto());
				ans.put(js);
			}
			totol.put(ans);
		}
		
		return totol.toString();
	}
}
