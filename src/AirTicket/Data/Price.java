package AirTicket.Data;

import java.sql.Date;
import java.sql.Timestamp;

public class Price {
	private int id,price;
	private String airfrom,airto;
	private Date airdate;
	private Timestamp airtime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
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
	public Date getAirdate() {
		return airdate;
	}
	public void setAirdate(Date airdate) {
		this.airdate = airdate;
	}
	public Timestamp getAirtime() {
		return airtime;
	}
	public void setAirtime(Timestamp airtime) {
		this.airtime = airtime;
	}
	
}
