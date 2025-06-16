
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Stock {

    private String name;
    private double price;
}

interface StockMarketSubject {

    public void subscribe(Stock stock, StockMarketObserver observer);

    public void unsubscribe(StockMarketObserver observer);

    public void notifyObservers();
}

interface StockMarketObserver {

    public void updateStockInfo(Stock stock);
}

// Subject
class StockMarket implements StockMarketSubject {

    private Map<Stock, StockMarketObserver> observers;
    private Map<String, double> stocks;

    public StockMarket(Map<String, double> stocks) {
        this.observers = new HashMap<>();
        this.stocks = stocks;
    }

    @Override
    public void subscribe(Stock stock, StockMarketObserver observer) {
        this.observers.add(observer);
    }

    @Override
    public void unsubscribe(StockMarketObserver observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (StockMarketObserver observer : observers) {
            observer.updateStockInfo(stock);
        }
    }

}

// Observer
class User implements StockMarketObserver {

    private String id;
    private String name;

    @Override
    public void updateStockInfo(Stock stock) {

    }

}

public class Solution {

}
