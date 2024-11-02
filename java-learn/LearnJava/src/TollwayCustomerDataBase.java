//Contestant Number: 100844

//You can also use other random number generation tactics
import java.util.*;
import java.text.NumberFormat; //You can also use other formatting methodology

public class TollwayCustomerDataBase {
    static Scanner input = new Scanner(System.in);

    public static void main(String args[]) {
        // Pre loaded Address data: pass these into the Customer constructor
        // "Montana","Jose", "Ford", "F150", "ABC-123", 55.00
        Customer cust1 = new Customer("Montana", "Jose", "Ford", "F150", "ABC-123", 55.00);

        // Pre loaded Address data: pass these into the MailingAddress constructor, and
        // this object is stored as a field
        // in the Customer object
        // "3445 Rockhill Rd.", "Santa Fe", "New Mexico", "77777"
        cust1.address = new MailingAddress("3445 Rockhill Rd.", "Santa Fe", "New Mexico", "77777");

        // check if customer record import successful
        if (cust1 != null && cust1.address != null) {
            System.out.println("Customer record import successful.");
        }

        // ask user if they want to submit a record
        String yesOrNo = "";
        while (yesOrNo.equals("yes") == false && yesOrNo.equals("no") == false) {
            System.out.println("Type in \"Yes\" if you want to update this record: ");
            System.out.print("ENTER: Yes or No: ");
            yesOrNo = getUserStringInput();
            if (yesOrNo.equals("yes")) {
                setDepositCustomerRecord(cust1);
                break;
            } else if (yesOrNo.equals("no")) {
                consoleRecordCheck(cust1);
                break;
            }
        }

    }

    // Gets the user input for the yes or no prompts and turns it into LC
    // //////////////////////////////////////
    // helper method
    private static String getUserStringInput() {
        String userStringInput = input.nextLine().toLowerCase();
        return userStringInput;
    }

    // Prompts the user to submit a deposit: calls other helper methods
    // //////////////////////////////////////
    private static void setDepositCustomerRecord(Customer c) {
        System.out.println();
        System.out.println("All records require a new deposit. How much will the customer be depositing?");
        
        double depositAmount = 0.0;
        while ((depositAmount < 1.0) || (depositAmount > 9999.99))
        {
            System.out.print("Please enter a value between $1.00 to $9,999.99: ");
            depositAmount = getUserNumberInput();
            c.setDeposit(depositAmount);
        }
        setReferenceID(c);
        System.out.println(getDepositMessage(c));
        consoleRecordCheck(c);

    }

    // Prints the final record to the console by using data from the object
    // //////////////////////////////////////
    private static void consoleRecordCheck(Customer c) {
        System.out.println();
        String input = "";
        while(input.equals("yes")==false || input.equals("no")==false)
        {
            System.out.println("Do you want to retrieve this record?");
            System.out.print("ENTER: Yes or No: ");
            input = getUserStringInput();
            if (input.equals("yes")) 
            {
                System.out.println(c.getFN() + " " + c.getLN());
                System.out.println(c.address.getAdd());
                String currencyResult = NumberFormat.getCurrencyInstance().format(c.getDeposit());
                System.out.println("Deposit: " + currencyResult);
                System.out.println("Car Information: " + c.getMake() + " " + c.getModel());
                System.out.println("Reference ID: " + c.getReferenceTicket());
                break;
            }
            else if(input.equals("no"))
            {
                System.out.println("Goodbye");
                System.exit(0);
            }

        }
        

    }

    //Gets the user input for the deposit prompt //////////////////////////////////////
    //helper method 
    private static double getUserNumberInput()
    {
        double userNumberInput = input.nextDouble();
        return userNumberInput;
    }

    //Displays the message in console after a successful deposit entry //////////////////////////////////////
    //helper method 
    private static String getDepositMessage(Customer c)
    {
        String currencyResult = NumberFormat.getCurrencyInstance().format(c.getDeposit());
        return "\n" + c.getFN() +" " + c.getLN() + " deposited a total of " + currencyResult + ". \nReference ID: " + c.getReferenceTicket();

    }
    //Creates and stores the reference ID (random letters and numbers) //////////////////////////////////////
    //helper method 
    private static void setReferenceID(Customer c)
    {
        String code = "";
        Random r = new Random();
        for (int i = 0; i < 3; i++)
        {
            char letter = (char)(r.nextInt(26)+'A');
            while (letter == 'O') 
            {
                letter = (char)(r.nextInt(26)+'A');
            }
            code += letter;
        }

        int number = r.nextInt(100000);
        while (number < 10000)
        {
            number = r.nextInt(100000);
        }
        code += number;
        c.setReferenceTicket(code);
    }
}

class Customer1 {
    private String last_Name;
    private String first_Name;
    private String carMake;
    private String carModel;
    private String carLicensePlate;
    private double deposit;
    private String reference = "";

    public MailingAddress address;

    public Customer1(String ln, String fn, String cMa, String cMo, String lp, Double de) {
        this.last_Name = ln;
        this.first_Name = fn;
        this.carMake = cMa;
        this.carModel = cMo;
        this.carLicensePlate = lp;
        this.address = new MailingAddress();
        this.deposit = de;
    }

    public String getLN() {
        return this.last_Name;
    }

    public void setLN(String ln) {
        this.last_Name = ln;
    }

    public String getFN() {
        return this.first_Name;
    }

    public void setFM(String fn) {
        this.first_Name = fn;
    }

    public String getMake() {
        return this.carMake;
    }

    public void setMake(String ma) {
        this.carMake = ma;
    }

    public String getModel() {
        return this.carModel;
    }

    public void setModel(String mo) {
        this.carModel = mo;
    }

    public Double getDeposit() {
        return this.deposit;
    }

    public void setDeposit(Double d) {
        this.deposit = d;
    }

    public String getLicensePlate() {
        return this.carLicensePlate;
    }

    public void setLicensePlate(String lp) {
        this.carLicensePlate = lp;
    }

    public void setReferenceTicket(String d) {
        reference = d;
    }

    public String getReferenceTicket() {
        return reference;
    }

    public String toString() {
        return this.getClass().getName() + "[ " + this.getFN() + " "
                + this.getLN() + "\n" + this.getMake() + " " + this.getModel() +
                "\n" + this.getLicensePlate() + "\n" + this.getDeposit() + "]";
    }
}

class MailingAddress1 {
    private String street;
    private String city;
    private String state;
    private String zipCode;

    public MailingAddress1() {
        this.street = " ";
        this.city = " ";
        this.state = " ";
        this.zipCode = " ";
    }

    public MailingAddress1(String s, String c, String st, String zc) {
        this.street = s;
        this.city = c;
        this.state = st;
        this.zipCode = zc;
    }

    public String getAdd() {
        return this.street + "\n" + this.city + ", " + this.state + " " + this.zipCode;
    }
}