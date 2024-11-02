public class Casting {
    public static void main(String[] args) {
        // implicit casting
        // byte > short > int > long > float > double
        short w = 1;
        double x = 1.8;
        double y = x + w + 2;
        System.out.println(y);
        // explicit casting
        int z = (int) x + 2; // this will convert x to an integer, so it will drop the decimal
        System.out.println(z);
        // string to number
        String s = "1";
        Integer.parseInt(s);
        Short.parseShort(s);
        Float.parseFloat(s);
        int g = Integer.parseInt(s) + 2;
        System.out.println(g);
    }
}
