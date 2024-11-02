public class Strings {
    public static void main(String[] args) {
        String message = "  This is a String" + "!";
        System.out.println(message);
        // check to see if the string starts/ends with a certain character/sequnce of
        // characters (returns true or false)
        System.out.println(message.endsWith("!"));
        System.out.println(message.startsWith("!"));
        // check the length of the string
        System.out.println(message.length());
        // check to see the index of (what number it is)
        int index = message.indexOf('i', 0) + 1;
        System.out.println(index);
        // replace a letter
        System.out.println(message.replace("!", ":"));
        // make a message all caps/lowercase
        System.out.println(message.toLowerCase());
        System.out.println(message.toUpperCase());
        // remove the spaces before or after a message
        System.out.println(message.trim());
    }
}
