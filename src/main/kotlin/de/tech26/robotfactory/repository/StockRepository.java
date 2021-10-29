package de.tech26.robotfactory.repository;

import de.tech26.robotfactory.entity.Stock;

import java.util.HashMap;
import java.util.Map;

/**
 * central repo to maintain current stock
 */
public class StockRepository {
    public static Map<String, Stock> STOCK_MAP = new HashMap<>() {{
        put("A", new Stock(10.28, 9, "Humanoid Face", "Face"));
        put("B", new Stock(24.07, 7, "LCD Face", "Face"));
        put("C", new Stock(13.30, 0, "Steampunk Face", "Face"));
        put("D", new Stock(28.94, 1, "Arms with Hands", "Arms"));
        put("E", new Stock(12.39, 3, "Arms with Grippers", "Arms"));
        put("F", new Stock(30.77, 2, "Mobility with Wheels", "Mobility"));
        put("G", new Stock(55.13, 15, "Mobility with Legs", "Mobility"));
        put("H", new Stock(50.00, 7, "Mobility with Tracks", "Mobility"));
        put("I", new Stock(90.12, 92, "Material Bioplastic", "Material"));
        put("J", new Stock(82.31, 15, "Material Metallic", "Material"));
    }};
}