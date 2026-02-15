package Task_2;

import java.util.*;

class Stock {
    String symbol;
    double price;

    public Stock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }
}

class Portfolio {
    Map<String, Integer> holdings = new HashMap<>();
    double balance = 10000;

    public void buyStock(Stock stock, int quantity) {
        double cost = stock.price * quantity;
        if (cost <= balance) {
            balance -= cost;
            holdings.put(stock.symbol, holdings.getOrDefault(stock.symbol, 0) + quantity);
            System.out.println("Bought " + quantity + " shares of " + stock.symbol);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    public void sellStock(Stock stock, int quantity) {
        if (holdings.getOrDefault(stock.symbol, 0) >= quantity) {
            balance += stock.price * quantity;
            holdings.put(stock.symbol, holdings.get(stock.symbol) - quantity);
            System.out.println("Sold " + quantity + " shares of " + stock.symbol);
        } else {
            System.out.println("Not enough shares!");
        }
    }

    public void displayPortfolio() {
        System.out.println("\n--- Portfolio ---");
        for (String symbol : holdings.keySet()) {
            System.out.println(symbol + " : " + holdings.get(symbol) + " shares");
        }
        System.out.println("Balance: $" + balance);
    }
}

public class StockTradingPlatform {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stock apple = new Stock("AAPL", 180);
        Stock tesla = new Stock("TSLA", 250);

        Portfolio portfolio = new Portfolio();

        while (true) {
            System.out.println("\n1. Buy AAPL\n2. Sell AAPL\n3. Buy TSLA\n4. Sell TSLA\n5. View Portfolio\n6. Exit");
            int choice = sc.nextInt();

            if (choice == 1) portfolio.buyStock(apple, 5);
            else if (choice == 2) portfolio.sellStock(apple, 2);
            else if (choice == 3) portfolio.buyStock(tesla, 3);
            else if (choice == 4) portfolio.sellStock(tesla, 1);
            else if (choice == 5) portfolio.displayPortfolio();
            else break;
        }

        sc.close();
    }
}

