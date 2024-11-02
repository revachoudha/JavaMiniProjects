import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {
    public static void main(String[] args) {

        Scanner principalScanner = new Scanner(System.in);
        System.out.print("Principal: ");
        double principal = principalScanner.nextDouble();

        Scanner annualInterestScanner = new Scanner(System.in);
        System.out.print("Annual Interest Rate: ");
        double annualInterest = annualInterestScanner.nextDouble();
        double monthlyInterest = annualInterest / 100 / 12;

        Scanner yearsScanner = new Scanner(System.in);
        System.out.print("Period (Years): ");
        int years = yearsScanner.nextInt();
        double n = years * (double) 12;

        double mortgage = principal * (monthlyInterest * Math.pow(1 + monthlyInterest, n))
                / (Math.pow(1 + monthlyInterest, n) - 1);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);

    }
}
