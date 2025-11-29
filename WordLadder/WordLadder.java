import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;


public class WordLadder {

    //Declare private instance variables:
    private String start;
    private String end;
    private Set<String> dictionary;
    private Set<String> usedWords;  
    //DEBUG (set to false), 
    //string start, 
    //string end, 
    //Set (a hashset to store all valid words of the correct length.  Using a set allows for fast O(1) lookup of words.
    //Queue)

    public WordLadder(String start, String end) {
        this.start = start.toLowerCase();
        this.end = end.toLowerCase();
        this.dictionary = new HashSet<>();
        this.usedWords = new HashSet<>();
        
        loadDictionary();
    }

    /** Supply the starting and ending word in the word ladder with a constructor */


    // dictionary method
    /* 
    This private method reads words from a data/dictionary text file
    Uses a scanner and handles potential IOException
    Adds words to the dictionary if they have the same lengths the start word
    Converts all words to lowercase
    */
    private void loadDictionary() {
        try {
            File file = new File("dictionary.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String word = scanner.next().trim().toLowerCase();
                if (word.length() == start.length()) {
                    dictionary.add(word);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: dictionary.txt not found.");
            e.printStackTrace();
        }
    }


    //findLadder method
    public void findLadder() {
        if (!dictionary.contains(start) || !dictionary.contains(end)) {
            System.out.println("No ladder between " + start + " and " + end + " (words not in dictionary).");
            return;
        }

        Queue<Stack<String>> queue = new LinkedList<>();

        Stack<String> initialStack = new Stack<>();
        initialStack.push(start);
        queue.offer(initialStack);
        
        usedWords.add(start);

        while (!queue.isEmpty()) {
            
            Stack<String> currentLadder = queue.poll();
            String currentWord = currentLadder.peek();

            if (currentWord.equals(end)) {
                printLadder(currentLadder);
                return;
            }

            char[] currentChars = currentWord.toCharArray();
            
            for (int i = 0; i < currentChars.length; i++) {
                char originalChar = currentChars[i];

                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == originalChar) continue;

                    currentChars[i] = c;
                    String neighbor = new String(currentChars);

                    if (dictionary.contains(neighbor) && !usedWords.contains(neighbor)) {
                        
                        Stack<String> newLadder = new Stack<>();
                        newLadder.addAll(currentLadder);
                        
                        newLadder.push(neighbor);
                        
                        queue.offer(newLadder);
                        
                        usedWords.add(neighbor);
                    }
                }
                currentChars[i] = originalChar;
            }
        }

        System.out.println("There is no word ladder between " + start + " and " + end);
    }
    /*
    Initial Check:  it first verifies that both the start and end words exist in the loaded dictionary.
    If not print a message and returns
    Use while loop.  The loop continues as long as there are potential ladders to explore in the queue.
    Dequeue the next path to a temp queue
    Goal Check to see you have found a ladder
    If so print result and return
    Explore Neighbors (one letter difference)
    Use a stringbuilder
    Iterate through every character position in the word
    If word is in the dictionary (it’s a valid step)
    Create a new ladder by deep copying the current path
    New laid word is added to the new ladder
    The new ladder is added to the ladders queue for future exploration
    Remove the word from the dictionary so the same word is not used again and ensures the shortest path
    Reset the character back to the original to check the next letter
    No ladder found- while loop finishes and queue is empty, all possible paths have been explored and no ladder was found between the start and end words

    */

    private void printLadder(Stack<String> ladder) {
        System.out.println("Found a ladder! Length " + ladder.size()); 
        System.out.println(ladder.toString());
    }

    public static void main(String[] args) {
        try {
            File inputFile = new File("input.txt");
            Scanner inputScanner = new Scanner(inputFile);

            while (inputScanner.hasNext()) {
                String startWord = inputScanner.next();
                
                if (inputScanner.hasNext()) {
                    String endWord = inputScanner.next();
                    
                    System.out.println("-------------------------");
                    System.out.println("Processing: " + startWord + " -> " + endWord);
                    
                    WordLadder solver = new WordLadder(startWord, endWord);
                    solver.findLadder();
                    
                } else {
                    System.out.println("Error: Odd number of words in input file.");
                }
            }
            inputScanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error: input.txt file not found in the project directory.");
            System.out.println("Please create input.txt with pairs of words (e.g., 'stone money').");
        }
    }
}
