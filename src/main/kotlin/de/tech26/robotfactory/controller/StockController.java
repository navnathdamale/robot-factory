package de.tech26.robotfactory.controller;

import de.tech26.robotfactory.entity.Stock;
import de.tech26.robotfactory.service.stock.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * controller dedicated for managing stocks
 */
@RestController
@RequestMapping("/stocks")
public class StockController {
    private StockService stockService;

    public StockController(@Autowired StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping
    public ResponseEntity<Map<String, Stock>> getStocks() {
        return new ResponseEntity<>(stockService.getStocks(), HttpStatus.OK);
    }

    @PutMapping(value = "/{code}")
    public ResponseEntity<Stock> updateStock(@PathVariable String code, @RequestBody Stock stock) {
        return new ResponseEntity<>(stockService.updateStock(code, stock), HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/{code}")
    public ResponseEntity<Stock> getStock(@PathVariable String code) {
        return new ResponseEntity<>(stockService.getStockByCode(code), HttpStatus.OK);
    }
}
