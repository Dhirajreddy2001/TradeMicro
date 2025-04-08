package com.TradeMicro.TAM.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TradeMicro.TAM.model.Trade;
import com.TradeMicro.TAM.repository.TradeRepository;

@Service
public class TradeService {
	
	@Autowired
	private TradeRepository tradeRepository;
	
	public List<Trade> getAllTrades() {
		
		return tradeRepository.findAll();
		
	}
	
	public List<Trade> getTradesBySymbol(String symbol)
	{
		return tradeRepository.findBySymbol(symbol);
	}
	public Double getAveragePrice(String symbol)
	{
		return tradeRepository.getAveragePrice(symbol);
	}
	public Long getTotalVolume(String symbol)
	{
		return tradeRepository.getTotalVolume(symbol);
	}
	public Double getTotalProfitLoss(String symbol)
	{
		return tradeRepository.getTotalProfitLoss(symbol);
	}
}
