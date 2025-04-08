package com.TradeMicro.TAM.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.TradeMicro.TAM.model.Trade;

@Repository
public class TradeRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Trade> findAll(){
		
		String sqlRetString = "SELECT * FROM STOCKTRADES";
		return jdbcTemplate.query(sqlRetString, new TradeRowMapper());
		
	}
	public List<Trade>findBySymbol(String symbol) {
		
		String sqlString ="SELECT * FROM STOCKTRADES WHERE SYMBOL = ?";
		
		return jdbcTemplate.query(sqlString,  new TradeRowMapper(),symbol);
		
	}
	public Long getTotalVolume(String symbol)
	{
		String sqlString ="SELECT SUM(QUANTITY) FROM STOCKTRADES WHERE SYMBOL = ?";
		return jdbcTemplate.queryForObject(sqlString,Long.class,symbol);
	}
	public Double getAveragePrice(String symbol) {
		String sqlString = "SELECT AVG(price) FROM STOCKTRADES WHERE symbol = ?";
		return jdbcTemplate.queryForObject(sqlString,Double.class,symbol);
	}
	public Double getTotalProfitLoss(String symbol)
	{
		String sqlString = "SLECT SUM(profitloss) from STOCKTRADES WHERE SYMBOL = ?";
		return jdbcTemplate.queryForObject(sqlString,Double.class,symbol );
	}
	
}
