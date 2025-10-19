import java.util.*;

public class QueueProbsRunner {
    public static void main(String[] args) {
        QueueProbs qp = new QueueProbs();

        Queue<Integer> nums = new LinkedList<>(Arrays.asList(3, 5, 4, 17, 6, 83, 1, 84, 16, 37));
        System.out.println("evenFirst: " + qp.evenFirst(nums));

        Queue<Integer> palindromeQueue = new LinkedList<>(Arrays.asList(3, 8, 17, 9, 17, 8, 3));
        System.out.println("numPalindrome: " + qp.numPalindrome(palindromeQueue));

        System.out.println("sieveOfEratosthenes(20): " + qp.sieveOfEratosthenes(20));
    }
}