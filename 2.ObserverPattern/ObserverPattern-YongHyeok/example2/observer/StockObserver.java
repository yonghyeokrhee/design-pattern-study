package example2.observer;

public interface StockObserver {
    void update(String stockSymbol, double stockPrice);
}
