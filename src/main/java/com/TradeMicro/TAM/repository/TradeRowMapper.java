package com.TradeMicro.TAM.repository;

import com.TradeMicro.TAM.model.Trade;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;


public class TradeRowMapper implements RowMapper<Trade> {

	@Override
	public Trade mapRow(ResultSet rs,int rowNum) throws SQLException {
		
		Trade trade = new Trade();
		
		trade.setId(rs.getLong("ID"));
		trade.setTradeDate(rs.getDate("TRADE_DATE").toLocalDate());
		trade.setSymbol(rs.getString("SYMBOL"));
		trade.setQuantity(rs.getLong("QUANTITY"));
		trade.setPrice(rs.getDouble("PRICE"));
		trade.setType(rs.getString("TYPE"));
		trade.setProfitLoss(rs.getDouble("PROFIT_LOSS"));
		trade.setCountry(rs.getString("COUNTRY"));
		trade.setIndustryTag(rs.getString("INDUSTRY_TAG"));
		
		return trade;
		
		
		
		
		
	}

}
