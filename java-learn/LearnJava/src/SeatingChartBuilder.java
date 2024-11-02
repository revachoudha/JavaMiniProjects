
import java.io.FileNotFoundException;
import java.io.File;
import java.util.*; 
import java.text.DecimalFormat;

public class SeatingChartBuilder
   {
   //SC1: Creates the scanner object
   static Scanner input = new Scanner(System.in); 
   public static void main (String args [])
      {
          //First prompt text: ""
          System.out.println("How many test students do you want to create?");
          System.out.print("Please enter in a value between 1 and 50: ");
          int numStudents = integerInputManager();
          String studentNames[] = {"Walter","Jones","Rose","Wilson" ,"Jack", "Rodriguez" , "Elizabeth" , "Smith", "Earl", "Carter", "Linda", "Ward", "Christopher", 
         "Turner", "Martin", "Murphy", "Betty", "Garcia", "Shawn", "Taylor","Sean", "Simmons", "Joshua", "Evans", "Norma", "Mitchell", "Brenda", "Johnson", "Donna", 
         "Clark", "Irene", "Diaz","Marilyn", "Coleman","Arthur", "Collins","Henry", "Hall","Howard", "Robinson","Jerry", "Green","Maria", "Price", "Evelyn", "Bell", 
         "Janet", "Moore", "Susan", "Foster"};
         ArrayList<Students> listOfStudents = new ArrayList<Students>();
         listOfStudents = setStudents(listOfStudents, studentNames, numStudents);
         printStudents(listOfStudents);
      
      
      //Student Names
      /*"Walter","Jones","Rose","Wilson" ,"Jack", "Rodriguez" , "Elizabeth" , "Smith", "Earl", "Carter", "Linda", "Ward", "Christopher", 
         "Turner", "Martin", "Murphy", "Betty", "Garcia", "Shawn", "Taylor","Sean", "Simmons", "Joshua", "Evans", "Norma", "Mitchell", "Brenda", "Johnson", "Donna", 
         "Clark", "Irene", "Diaz","Marilyn", "Coleman","Arthur", "Collins","Henry", "Hall","Howard", "Robinson","Jerry", "Green","Maria", "Price", "Evelyn", "Bell", 
         "Janet", "Moore", "Susan", "Foster"  */
         
       
      }


   private static ArrayList<Students> setStudents(ArrayList<Students> stuList, String [] allNames, int nc)
      {
      for (int i = 0; i < nc; i++)
      {
         //SC7:  creates the Random object
         Random r = new Random();
         //SC8: randomly selects student names using Random object and properly checks that objects are not equal
         int randomFirstNameIndex = r.nextInt(49);
         String stuFirstName = allNames[randomFirstNameIndex];
         int randomLastNameIndex = r.nextInt(49);
         while(randomFirstNameIndex == randomLastNameIndex)
         {
         randomLastNameIndex = r.nextInt(49);
         }
         String stuLastName = allNames[randomLastNameIndex];
         //SC9: randomly selects students gradelevels using Random object
         int randomGradeLevel = r.nextInt(12);
         while (randomGradeLevel<9)
         {
            randomGradeLevel = r.nextInt(12);
         }
         //SC10: randomly creates GPA using Random object, and properly formats object using DecimalFormat object
         double randomGPA = r.nextDouble()*10;
         while (randomGPA < 1 || randomGPA > 4)
         {
            randomGPA = r.nextDouble()*10;
         }
         
         Students s1 = new Students(stuFirstName, stuLastName, randomGradeLevel, randomGPA);
         stuList.add(s1);
       }
         
      return stuList;
            }
 
   
   private static void printStudents(ArrayList<Students> students){
      for (int i = 0; i<students.size(); i++) {
         System.out.println(students.get(i).getFirstName() +
          "\t|\t" + students.get(i).getLastName() + "|\t" +
           students.get(i).getGradeLevel() + "|\t" + 
           new DecimalFormat().format(students.get(i).getGPA())
         );
        }
   }
    
        
              
   private static int integerInputManager()
      {
          //SC3: gathers User Input
          int inputNumber = input.nextInt();
          //SC5: detects range violations
          while (inputNumber<1 || inputNumber>50)
          {
          System.out.println();
          System.out.println("Please enter a correct value.");
          System.out.print("Please enter a value between 1 and 50: ");
          inputNumber = input.nextInt();
          }
          return inputNumber;       
      }  
 

   }

//Given
///////////////////////////////////////////////////
class Students
{
   String first_Name;
   String last_Name;
   int grade_Level;
   double GPA;
      
   public Students()
      {
      first_Name = "Dee";
      last_Name =  "Fault";
      grade_Level = 0;
      GPA = 0.0;
      }

   public Students(String fn, String ln, int gl, double gpa)
      {
      first_Name = fn;
      last_Name =  ln;
      grade_Level = gl;
      GPA = gpa;
      }
      
      //last, first
   public String getWholeName()
      {
      return last_Name + ", "+first_Name;
      }
      
   public String getFirstName()
      {
      return first_Name;
      }
      
   public String getLastName()
      {
      return last_Name;
      }
      
   public double getGPA()
      {
      return GPA;
      }
      
   public int getGradeLevel()
      {
      return grade_Level;
      }
      
   public void setFirstName(String fn)
      {
      first_Name = fn;
      }
    
   public void setLastName(String ln)
      {
      last_Name = ln;
      }
      
   }