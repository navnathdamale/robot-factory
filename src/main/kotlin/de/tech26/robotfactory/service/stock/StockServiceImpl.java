package de.tech26.robotfactory.service.stock;

import de.tech26.robotfactory.entity.Stock;
import de.tech26.robotfactory.repository.StockRepository;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class StockServiceImpl implements StockService {

    @Override
    public Map<String, Stock> getStocks() {
        return StockRepository.STOCK_MAP;
    }

    @Override
    public Stock getStockByCode(final String code) {
        return StockRepository.STOCK_MAP.getOrDefault(code, new Stock());
    }

    @Override
    public Stock updateStock(final String code, final Stock stock) {
        return StockRepository.STOCK_MAP.put(code, stock);
    }

    @Override
    public void updateStock(final Map<String, Stock> stockMap) {
        StockRepository.STOCK_MAP.putAll(stockMap);
    }
}

