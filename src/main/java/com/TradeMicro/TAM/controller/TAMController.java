package com.TradeMicro.TAM.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.TradeMicro.TAM.model.Trade;
import com.TradeMicro.TAM.service.TradeService;

@RestController
@RequestMapping("api/trades")
public class TAMController {
	
	@Autowired
	private TradeService tradeService;
	
	@GetMapping
	public List<Trade> getAllTrades()
	{
		return tradeService.getAllTrades();
	}
	
	@GetMapping("/symbol/{symbol}")
	public List<Trade> getTradesBySymbol(@PathVariable String symbol)
	{
		return tradeService.getTradesBySymbol(symbol);
		
	}
	
	@GetMapping("/symbol/{symbol}/average-price")
	public Double getAveragePrice(@PathVariable String symbol)
	{
		return tradeService.getAveragePrice(symbol);
	}
	
	@GetMapping("/symbol/{symbol}/volume")
	public Long getTotalVolume(@PathVariable String symbol)
	{
		return tradeService.getTotalVolume(symbol);
	}
	@GetMapping("/symbol/{symbol}/profit-loss")
	public Double getTotalProfitLoss(@PathVariable String symbol)
	{
		return tradeService.getTotalProfitLoss(symbol);
	}
	
	
	
	
	
}
