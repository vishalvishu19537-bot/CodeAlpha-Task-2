import java.util.HashMap;

public class Portfolio {

    private HashMap<String, Integer> holdings = new HashMap<>();

    public void buyStock(String symbol, int quantity) {
        holdings.put(symbol, holdings.getOrDefault(symbol, 0) + quantity);
    }

    public boolean sellStock(String symbol, int quantity) {

        if (!holdings.containsKey(symbol))
            return false;

        int current = holdings.get(symbol);

        if (current < quantity)
            return false;

        holdings.put(symbol, current - quantity);

        if (holdings.get(symbol) == 0)
            holdings.remove(symbol);

        return true;
    }

    public void displayPortfolio() {

        if (holdings.isEmpty()) {
            System.out.println("Portfolio Empty.");
            return;
        }

        System.out.println("\nYour Portfolio");

        for (String stock : holdings.keySet()) {
            System.out.println(stock + " : " + holdings.get(stock) + " Shares");
        }
    }
}