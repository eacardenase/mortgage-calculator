import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Principal: ");
        int principal = scanner.nextInt();
        System.out.print("Annual Interest Rate: ");
        double annualInterest = scanner.nextDouble() / PERCENT;
        System.out.print("Period (Years): ");
        int numberOfPayments = scanner.nextInt() * MONTHS_IN_YEAR;

        double monthlyInterest = annualInterest / MONTHS_IN_YEAR;
        double mortgage = principal
                * ((monthlyInterest * Math.pow((double)(1 + monthlyInterest), (double) numberOfPayments))
                / (Math.pow((double)(1 + monthlyInterest), (double) numberOfPayments) - 1));

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
    }
}