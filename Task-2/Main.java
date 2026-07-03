import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Stock[] market = {

                new Stock("TCS", "Tata Consultancy", 3500),
                new Stock("INFY", "Infosys", 1600),
                new Stock("RELI", "Reliance", 2800),
                new Stock("HDFC", "HDFC Bank", 1700)

        };

        User user = new User("Vishal", 100000);

        while (true) {

            System.out.println("\n====== STOCK TRADING PLATFORM ======");

            System.out.println("1. View Market");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. Balance");
            System.out.println("6. Exit");

            System.out.print("Choice : ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    for (int i = 0; i < market.length; i++) {
                        System.out.println((i + 1) + ". "
                                + market[i].getSymbol()
                                + "  Rs." + market[i].getPrice());
                    }

                    break;

                case 2:

                    System.out.print("Stock Number : ");
                    int b = sc.nextInt();

                    System.out.print("Quantity : ");
                    int q = sc.nextInt();

                    Transaction.buy(user, market[b - 1], q);

                    break;

                case 3:

                    System.out.print("Stock Number : ");
                    int s = sc.nextInt();

                    System.out.print("Quantity : ");
                    int q2 = sc.nextInt();

                    Transaction.sell(user, market[s - 1], q2);

                    break;

                case 4:

                    user.getPortfolio().displayPortfolio();

                    break;

                case 5:

                    System.out.println("Balance : Rs." + user.getBalance());

                    break;

                case 6:

                    System.out.println("Thank You!");
                    return;

                default:

                    System.out.println("Invalid Choice.");
            }
        }
    }
}