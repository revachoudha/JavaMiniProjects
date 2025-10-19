import java.util.*;

public class QueueProbs {
    public Queue<Integer> evenFirst(Queue<Integer> nums) {
        Queue<Integer> evens = new LinkedList<>();
        Queue<Integer> odds = new LinkedList<>();

        while (!nums.isEmpty()) {
            int n = nums.poll();
            if (n%2 ==0)
                evens.offer(n);
            else
                odds.offer(n);
        }

        evens.addAll(odds);
        return evens;
    }

    public boolean numPalindrome(Queue<Integer> nums) {
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> temp = new LinkedList<>();

        while (!nums.isEmpty()) {
            int n = nums.poll();
            stack.push(n);
            temp.offer(n);
        }

        boolean palindrome = true;
        while(!temp.isEmpty()) {
            int n = temp.poll();
            if (n != stack.pop()) {
                palindrome = false;
            }
            nums.offer(n);
        }
        return palindrome;
    }

    public Stack<Integer> sieveOfEratosthenes(int n) {
        Queue<Integer> nums = new LinkedList<>();
        Stack<Integer> primes = new Stack<>();

        for (int i = 2; i <= n; i++) {
            nums.offer(i);
        }

        while (!nums.isEmpty()) {
            int p = nums.poll();
            primes.push(p);

            Queue<Integer> temp = new LinkedList<>();
            while (!nums.isEmpty()) {
                int val = nums.poll();
                if (val % p != 0) {
                    temp.offer(val);
                }
            }
            nums = temp;
        }

        return primes;
    }
}
