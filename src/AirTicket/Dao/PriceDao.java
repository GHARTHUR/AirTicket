package AirTicket.Dao;

import java.util.List;

import AirTicket.Data.Price;

public interface PriceDao {
	int addPrice(Price price);
	List<Price> findPriceByFromTo(String From,String To);
}
