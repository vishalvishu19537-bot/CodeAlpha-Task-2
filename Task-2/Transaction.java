public class Transaction {

    public static void buy(User user, Stock stock, int qty) {

        double total = stock.getPrice() * qty;

        if (user.deductBalance(total)) {

            user.getPortfolio().buyStock(stock.getSymbol(), qty);

            System.out.println("Stock Purchased Successfully.");

        } else {

            System.out.println("Insufficient Balance.");
        }
    }

    public static void sell(User user, Stock stock, int qty) {

        if (user.getPortfolio().sellStock(stock.getSymbol(), qty)) {

            double total = stock.getPrice() * qty;

            user.addBalance(total);

            System.out.println("Stock Sold Successfully.");

        } else {

            System.out.println("Not enough shares.");
        }
    }
}