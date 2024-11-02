public class ArithmeticExpressions {
    public static void main(String[] args) {
        // division / will result in a whole number
        // modulus % will result in the remainder of the division
        // to divide regularly, you must convert the numbers to doubles, as shown below:
        double result = (double) 10 / (double) 3;
        System.out.println(result);
        // the increment operator will increase by one
        int x = 1;
        int y = x++;
        // y will be equal to x, x will add one
        y += 2;
        // will add two to y (augmented/compound operator)
        System.out.println(y);
        int power = (int) Math.pow(4, 3);
        System.out.println(power);

        // always remember order or operations!! PEMDAS

    }
}
