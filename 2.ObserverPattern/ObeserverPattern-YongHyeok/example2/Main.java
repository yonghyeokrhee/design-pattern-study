package example2;

import example2.observer.Investor;
import example2.observer.StockObserver;
import example2.subject.StockMarket;
import example2.subject.StockMarketImpl;

public class Main {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarketImpl();

        StockObserver investor1 = new Investor("Alice");
        StockObserver investor2 = new Investor("Bob");

        stockMarket.registerObserver(investor1);
        stockMarket.registerObserver(investor2);

        ((StockMarketImpl) stockMarket).setStockPrice("INFY", 1250.0); // Both investors receive updates
        ((StockMarketImpl) stockMarket).setStockPrice("TCS", 2500.0); // Both investors receive updates

        stockMarket.removeObserver(investor1);

        ((StockMarketImpl) stockMarket).setStockPrice("WIPRO", 700.0); // Only investor2 receives the update
    }
}
