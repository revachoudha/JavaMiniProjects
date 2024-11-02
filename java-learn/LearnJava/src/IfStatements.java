import java.util.Scanner;

public class IfStatements {
    public static void main(String[] args) {
        Scanner scannerTemp = new Scanner(System.in);
        System.out.print("What's the temperature? ");
        int temp = scannerTemp.nextInt();

        if (temp > 30) {
            System.out.println("It's a hot day!");
            System.out.println("Drink plenty of water to stay hydrated!");
        } else if (temp > 20)
            System.out.println("Beautiful day!");
        else
            System.out.println("Cold day");

        int income = 120000;
        boolean hasHighIncome = (income > 100000);
        System.out.println(hasHighIncome);
    }
}
