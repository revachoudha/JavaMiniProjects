
import java.util.*;


/**
 *
 * @author Reva Choudha
 */
public class Permutations {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a string to permute: ");
        
        char [] source = scan.nextLine().toCharArray();
        
        printPerm(source, 0);        
    }
    
    public static void printPerm(char[] array, int swapIndex){
        //TODO: INSERT CODE HERE IN THIS RECURSIVE METHOD
        //base case: permutation is complete when swapIndex reaches last index in array
        if(swapIndex == array.length - 1)
        {
            System.out.println(String.valueOf(array));
            return;
        }
        //recursion: iterates from current swapIndex to end of array
        for(int i = swapIndex; i < array.length; i++)
        {
            // swaps current char at swapIndex w/ char at index i
            swap(array, swapIndex, i);
            // uses recursion for next index and locks current position
            printPerm(array, swapIndex+1);
            // backtracking: swaps chars back, restoring original state for next iteration
            swap(array, swapIndex, i);
        }
    }

    private static void swap(char[] array, int swapIndex, int i) {
        char temp = array[swapIndex];
        array[swapIndex] = array[i];
        array[i] = temp;
    }
}
