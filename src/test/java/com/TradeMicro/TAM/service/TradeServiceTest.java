package com.TradeMicro.TAM.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.TradeMicro.TAM.dto.TradeDTO;
import com.TradeMicro.TAM.model.Trade;
import com.TradeMicro.TAM.repository.TradeRepository;

@ExtendWith(MockitoExtension.class)
public class TradeServiceTest {
	
	@Mock
	private TradeRepository tradeRepository;
	
	@InjectMocks
	private TradeService tradeService;
	
	@Test
	public void testT_Entity2DtoConv()
	{
		Trade trade = new Trade();
		trade.setSymbol("AAPL");
		trade.setPrice(215.30);
		trade.setType("BUY");
		trade.setProfitLoss(90.0);
		trade.setTradeDate(LocalDate.of(2024, 11, 10));
		
		
		Mockito.when(tradeRepository.findPaginated(0, 1)).thenReturn(List.of(trade));
		
		List<TradeDTO> result = tradeService.getPaginatedTrades(0, 1);
		
		assertEquals(1, result.size());
		 TradeDTO dto = result.get(0);
	        assertEquals("AAPL", dto.getSymbol());
	        assertEquals(215.30, dto.getPrice());
	        assertEquals("BUY", dto.getType());
	        assertEquals(90.0, dto.getProfitLoss());
	        assertEquals(LocalDate.of(2024, 11, 10), dto.getTradeDate());
		
	}
		
}
