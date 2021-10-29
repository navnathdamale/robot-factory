package de.tech26.robotfactory.service.stock;

import de.tech26.robotfactory.entity.Stock;

import java.util.Map;

public interface StockService {
    Stock getStockByCode(final String code);

    Stock updateStock(final String code, final Stock stock);

    void updateStock(final Map<String, Stock> stockMap);

    Map<String, Stock> getStocks();
}
