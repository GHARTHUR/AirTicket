package AirTicket.Service;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class Api {
	
	protected String baseurl;
	public abstract int getAirPrice(String time,String From,String To) throws IOException, JSONException;
}
