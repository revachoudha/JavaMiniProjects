import java.util.Scanner;

public class ReadingInput {
    public static void main(String[] args) {
        // Ask for age (byte)
        Scanner ageScanner = new Scanner(System.in);
        System.out.print("Age: ");
        byte age = ageScanner.nextByte();
        System.out.println("You are " + age);
        // Ask for first name (String)
        Scanner nameScanner = new Scanner(System.in);
        System.out.print("Name: ");
        String name = nameScanner.next();
        System.out.println("You are " + name);
        // Ask for Full Name
        Scanner fullNameScanner = new Scanner(System.in);
        System.out.print("Full Name: ");
        String fullName = fullNameScanner.nextLine().trim();
        System.out.println("You are " + fullName);
    }
}