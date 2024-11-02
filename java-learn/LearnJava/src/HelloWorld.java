import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class HelloWorld {

    static Scanner sc = new Scanner(System.in); 
    public static void main(String[] args) {
        System.out.println("Hello World!");

        System.out.println(new DecimalFormat("#.##").format(123.456));

        String[] studentNames = {"Walter","Jones","Rose","Wilson" ,"Jack", "Rodriguez" , "Elizabeth" , "Smith", "Earl", "Carter", "Linda", "Ward", "Christopher", 
        "Turner", "Martin", "Murphy", "Betty", "Garcia", "Shawn", "Taylor","Sean", "Simmons", "Joshua", "Evans", "Norma", "Mitchell", "Brenda", "Johnson", "Donna", 
        "Clark", "Irene", "Diaz","Marilyn", "Coleman","Arthur", "Collins","Henry", "Hall","Howard", "Robinson","Jerry", "Green","Maria", "Price", "Evelyn", "Bell", 
        "Janet", "Moore", "Susan", "Foster"};

        ArrayList aList = new ArrayList();
    
        Students s1 = new Students();
        Students s2 = new Students("Ryma", "Choudha", 5, 5.0);

        aList.add(s1);
        aList.add(s2);

        Students ryma = (Students)aList.get(1);

        System.out.println(ryma.getWholeName());

        System.out.println("How many students");
        int stuCount = sc.nextInt();

       ArrayList answerList = setStudents(aList, studentNames, stuCount);

       System.out.println(answerList);


       System.out.println(((Students)answerList.get(0)).getFirstName());

       for (Object student : answerList) {
        System.out.println(((Students)student).getWholeName());
       }


    }


    private static ArrayList setStudents(ArrayList stuList, String[] allNames, int nc) {

        nc = nc*2;
        stuList = new ArrayList<>();
        for (int i = 0; i < nc; i++) {

            System.out.println("Enter grade level for " +allNames[i] + allNames[i+1]);
            int gradeLevel = sc.nextInt();
            System.out.println("Enter gpa for " +allNames[i] + allNames[i+1]);
            double gpa = sc.nextDouble();
            Students student = new Students(allNames[i], allNames[i+1], gradeLevel, gpa);
            stuList.add(student);
            i=i+1;
        }

        return stuList;
    }

    private static void printStudents(ArrayList<Students> students) {

    System.out.println(students);


    }


    

    //private static int integerInputManager() {

    //}
}

class Students {
    String first_Name;
    String last_Name;
    int grade_Level;
    double GPA;

    public Students() {
        first_Name = "Dee";
        last_Name = "Fault";
        grade_Level = 0;
        GPA = 0.0;
    }

    public Students(String fn, String ln, int gl, double gpa) {
        first_Name = fn;
        last_Name = ln;
        grade_Level = gl;
        GPA = gpa;
    }

    // last, first
    public String getWholeName() {
        return last_Name + ", " + first_Name;
    }

    public String toString() {
        return last_Name + ", " + first_Name;
    }

    public String getFirstName() {
        return first_Name;
    }

    public String getLastName() {
        return last_Name;
    }

    public double getGPA() {
        return GPA;
    }

    public int getGradeLevel() {
        return grade_Level;
    }

    public void setFirstName(String fn) {
        first_Name = fn;
    }

    public void setLastName(String ln) {
        last_Name = ln;
    }

}