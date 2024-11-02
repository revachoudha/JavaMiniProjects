public class People {
    public static void main(String[] args) {
        Person ryma = new Person("Ryma", 10);
        Person reva = new Person("Reva", 15);

        System.out.println(ryma.getName() + " is " + ryma.getAge());
        System.out.println(reva.getName() + " is " + reva.getAge());

        // one year later
        ryma.setAge(11);
        reva.setAge(16);

        System.out.println(ryma.getName() + " is now " + ryma.getAge());
        System.out.println(reva.getName() + " is now " + reva.getAge());
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
