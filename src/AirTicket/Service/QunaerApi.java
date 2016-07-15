package AirTicket.Service;

import java.io.IOException;
import java.net.URLEncoder;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class QunaerApi extends Api{
	
	public QunaerApi() {
		// TODO Auto-generated constructor stub
		baseurl = "http://flight.qunar.com/twell/flight/getLp.jsp";
	}

	@Override
	public int getAirPrice(String time, String From, String To) throws IOException, JSONException {
		// TODO Auto-generated method stub
		HttpClient client = new HttpClient();
		GetMethod getMethod = new GetMethod(baseurl + "?from="+URLEncoder.encode(From, "utf-8")+"&to="+URLEncoder.encode(To, "utf-8")+"&goDate="+time+"&backDate="+time+"&count=1");
		client.getParams().setParameter(
	            HttpMethodParams.HTTP_CONTENT_CHARSET, "utf-8");
	    // 执行并返回状态
	    int status = client.executeMethod(getMethod);
	    String data = getMethod.getResponseBodyAsString();
	    data = new String(data.getBytes("utf-8"));
	    JSONObject gData = new JSONObject(data);
	    JSONObject out = gData.getJSONObject("out");
	    JSONObject price = out.getJSONObject(out.keys().next().toString());
		return price.getInt("pr");
	}
	
}
