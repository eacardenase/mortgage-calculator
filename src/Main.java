import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Principal ($1K - $1M): ");
        int principal = scanner.nextInt();
        while (principal < 1_000 || principal > 1_000_000) {
            System.out.println("Enter a number between 1,000 and 1,000,000");
            principal = scanner.nextInt();
        }

        System.out.print("Annual Interest Rate: ");
        double annualInterest = scanner.nextDouble();
        while (annualInterest <= 0 || annualInterest > 30) {
            System.out.println("Enter a value greater than 0 and less than or equal to 30.");
            annualInterest = scanner.nextDouble();
        }

        System.out.print("Period (Years): ");
        int years = scanner.nextInt();

        while (years < 1 || years > 30) {
            System.out.println("Enter a value between 1 and 30");
            years = scanner.nextInt();
        }

        int numberOfPayments = years * MONTHS_IN_YEAR;

        double monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        double mortgage = principal
                * ((monthlyInterest * Math.pow((1 + monthlyInterest), numberOfPayments))
                / (Math.pow((1 + monthlyInterest), numberOfPayments) - 1));

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
    }
}