public class Unit4Review {
    public static void main(String[] args) {
        Student ryma = new Student("Ryma Choudha");
        System.out.println(ryma);
        Student adi = new Student("Adi Behre", 7);
        System.out.println(adi);

        System.out.println();

        ryma.setNumClasses(6);
        ryma.increaseNumClasses(3);
        System.out.println(ryma.getName() + " is now in " + ryma.getNumClasses() + " classes.");

        System.out.println("The objects are equal: " + ryma.equals(adi));
    }
}

class Student {
    // Instance Variables
    private String name;
    private int numClasses;
    // Class Variable
    private static int numStudents = 0;
    // Final Variable
    public static final String SCHOOL = "Reedy High School";

    // Constructors
    public Student(String name) {
        this.name = name;
        this.numClasses = 0;
        numStudents++;
    }

    public Student(String name, int numClasses) {
        this.name = name;
        this.numClasses = numClasses;
        numStudents++;
    }

    // toString Method
    public String toString() {
        return name + " is in " + numClasses + " classes and goes to " + SCHOOL;
    }

    // Getter Methods
    public String getName() {
        return name;
    }

    public int getNumClasses() {
        return numClasses;
    }

    public static int getNumStudents() {
        return numStudents;
    }

    // Setter Methods
    public void setName(String name) {
        this.name = name;
    }

    public void setNumClasses(int numClasses) {
        this.numClasses = numClasses;
    }

    // Other Instance Method
    public void increaseNumClasses(int num) {
        numClasses += num;
    }

    // equals method
    public boolean equals(Student other) {
        if ((this.name.equals(other.getName())) && (this.numClasses == other.getNumClasses())) {
            return true;
        }

        else {
            return false;
        }

    }
}