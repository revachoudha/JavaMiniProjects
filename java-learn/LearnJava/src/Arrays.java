public class Arrays {
    public static void main(String[] args) {
        int[] numbers = { 2, 3, 5, 1, 4 };
        // to print the array
        System.out.println(java.util.Arrays.toString(numbers));
        // to print the length of the array
        System.out.println(numbers.length);
        // to sort the array
        java.util.Arrays.sort(numbers);
        System.out.println(java.util.Arrays.toString(numbers));

        // Multidimensional Array
        int[][] twod = new int[2][3];
        twod[0][0] = 1;
        twod[1][0] = 2;
        twod[0][1] = 3;
        System.out.println(java.util.Arrays.deepToString(twod));
        // the curly braces syntax (the new good one)
        int[][] curly = { { 1, 2, 3 }, { 4, 5, 6 } };
        System.out.println(java.util.Arrays.deepToString(curly));

    }
}
