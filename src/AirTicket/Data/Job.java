package AirTicket.Data;

import java.sql.Date;

public class Job {
	private int id,userid,lmoney;
	private String airfrom,airto;
	private Date airdate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getAirfrom() {
		return airfrom;
	}
	public void setAirfrom(String airfrom) {
		this.airfrom = airfrom;
	}
	public String getAirto() {
		return airto;
	}
	public void setAirto(String airto) {
		this.airto = airto;
	}
	public int getLmoney() {
		return lmoney;
	}
	public void setLmoney(int lmoney) {
		this.lmoney = lmoney;
	}
	public Date getAirdate() {
		return airdate;
	}
	public void setAirdate(Date airdate) {
		this.airdate = airdate;
	}
	
}
