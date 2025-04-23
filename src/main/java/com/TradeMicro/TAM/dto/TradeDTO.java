package com.TradeMicro.TAM.dto;

import java.time.LocalDate;

public class TradeDTO {
	
	private String symbol;
	private Double price;
	private String type;
	private Double profitLoss;
	private LocalDate tradeDate;
	
	public String getSymbol() {return symbol;}
	public void setSymbol(String symbol) { this.symbol = symbol; }
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Double getProfitLoss() {
		return profitLoss;
	}
	public void setProfitLoss(Double profitLoss) {
		this.profitLoss = profitLoss;
	}
	public LocalDate getTradeDate() {
		return tradeDate;
	}
	public void setTradeDate(LocalDate tradeDate) {
		this.tradeDate = tradeDate;
	}
	
	
	

}
