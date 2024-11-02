public class MathClass {
    public static void main(String[] args) {
        // to round a double to an integer
        int roundResult = Math.round(1.5F);
        System.out.println(roundResult);
        // ceiling (takes a decimal and finds the closest whole number greater than it)
        int ceilResult = (int) Math.ceil(1.1F);// make sure to excplicitly cast it as an integer, otherwise it will
                                               // expect
                                               // a double
        System.out.println(ceilResult);
        // floor (largest integer that is smaller or equal to the number)
        int floorResult = (int) Math.floor(1.1F);
        System.out.println(floorResult);
        // max (returns the greater of two numbers)
        int maxResult = Math.max(1, 2);
        System.out.println(maxResult);
        // min (results the lesser of two numbers)
        int minResult = Math.min(1, 2);
        System.out.println(minResult);
        // random (returns a random number of a list) (returns a double)
        double randomResult = Math.random();
        System.out.println(randomResult);
        // to get it between one and a hundred
        int randomHundredResult = (int) (Math.random() * 100);
        System.out.println(randomHundredResult);
    }
}
