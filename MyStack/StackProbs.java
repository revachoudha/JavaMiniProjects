import java.util.Stack;

public class StackProbs {
    public Stack<Integer> doubleUp(Stack<Integer> nums) {
        Stack <Integer> temp = new Stack<>();
        Stack<Integer> result = new Stack<>();
        
        while (!nums.isEmpty()) {
            temp.push(nums.pop());
        }
        
        while (!temp.isEmpty()) {
            Integer current = temp.pop();
            result.push(current);
            result.push(current);
        }
        
        return result;
    }
    
    public Stack<Integer> posAndNeg(Stack<Integer> nums) {
        Stack<Integer> temp = new Stack<>();
        Stack<Integer> negatives = new Stack<>();
        Stack<Integer> positives = new Stack<>();
        
        while (!nums.isEmpty()) {
            temp.push(nums.pop());
        }
        
        while (!temp.isEmpty()) {
            Integer current = temp.pop();
            if(current < 0) {
                negatives.push(current);
            }
            else {
                positives.push(current);
            }
        }
        
        while (!negatives.isEmpty()) {
            nums.push(negatives.pop());
        }
        
        while (!positives.isEmpty()) {
            nums.push(negatives.pop());
        }
        
        return nums;
    }
    
    public Stack<Integer> shiftByN(Stack<Integer> nums, int n) {
        Stack<Integer> temp = new Stack<>();
        Stack<Integer> shifted = new Stack<>();
        
        int toPop = nums.size() - n;
        for (int i = 0; i < toPop; i++) {
            temp.push(nums.pop());
        }
        
        while (!nums.isEmpty()) {
            shifted.push(nums.pop());
        }
        
        while(!temp.isEmpty()) {
            shifted.push(temp.pop());
        }
        return shifted;
    }
    
    public String reverseVowels(String str) {
        Stack<Character> vowels = new Stack<>();
        String allVowels = "aeiouAEIOU";
        
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (allVowels.indexOf(c) != -1) {
                vowels.push(c);
            }
        }
        
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (allVowels.indexOf(c) != -1) {
                result.append(vowels.pop());
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }
    
    public static boolean bracketBalance(String s) {
        Stack<Character> brackets = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[') {
                brackets.push(c);
            } else if (c == ')' || c == ']') {
                if (brackets.isEmpty()) {
                    return false;
                }
                char lastBracket = brackets.pop();
                if ((c == ')' && lastBracket != '(') || (c == ']' && lastBracket != '[')) {
                    return false;
                }
            }
        }
        return brackets.isEmpty();
    }
}