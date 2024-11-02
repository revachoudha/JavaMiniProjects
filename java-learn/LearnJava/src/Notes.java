import java.util.*;
public class Notes {
    
}
/*
 * Member ID: 00100844


 C:\Users\revac_lzod\OneDrive\java-learn\LearnJava\src> javac -cp ..\bin -d ..\bin TollwayCustomerDataBase.java

 C:\Users\revac_lzod\OneDrive\java-learn\LearnJava\src> java -cp ..\bin  TollwayCustomerDataBase

 C:\Users\revac_lzod\OneDrive\java-learn\LearnJava\bin> java TollwayCustomerDataBase
 */

 //random letter
 Random r = new Random();
 char c = (char)(r.nextInt(26) + 'a');

 //to end the program
 System.exit(0);

 //Nested Attributes
 coast.address = new HouseAddress(parameters);
 //Calling a method
 coast.address.getAddress();

 //Arrays
 String backpack[] = {"Pencil", "Eraser", "Notebook"};
 System.out.println(backpack[0]);

 String packback[];
 backpack[1] = "Eraser";
 
 System.out.println(backpack.length);

 //ArrayClass
 ArrayList<People> aList = new ArrayList<People>();
 People p1 = new People(parameters);
 aList.add(p1);
 Sysetm.out.println(((People)aList.get(0)).getFirstName());

//toString
 public String toString()
{
    return "blahblahblah";
}

//DecimalFormat
double d = 1234.567;
new DecimalFormat("#.##").format(d);


