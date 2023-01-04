package academy.learnprogramming.queueschallenge;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        // should return true
        System.out.println(checkForPalindrome("abccba"));
        // should return true
        System.out.println(checkForPalindrome("Was it a car or a cat I saw?"));
        // should return true
        System.out.println(checkForPalindrome("I did, did I?"));
        // should return false
        System.out.println(checkForPalindrome("hello"));
        // should return true
        System.out.println(checkForPalindrome("Don't nod"));
    }

    // Mine
    public static boolean checkForPalindrome(String string) {

        string = correctString(string);
        LinkedList<Character> stack = new LinkedList<Character>();
        LinkedList<Character> queue = new LinkedList<Character>();

        for (int i = 0; i < string.length(); i++) {
            stack.push(string.charAt(i));
            queue.add(string.charAt(i));
        }


        return stack.toString().equals(queue.toString());
    }

    private static String correctString(String string){

        StringBuilder stringNoPunctuation = new StringBuilder(string.length());
        string = string.toLowerCase();

        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (c >= 'a' && c <= 'z') {
                stringNoPunctuation.append(c);
            }
        }

        string = stringNoPunctuation.toString();

        return string;
    }

    /* Teacher's solution
    public static boolean checkForPalindrome(String string) {

        LinkedList<Character> stack = new LinkedList<Character>();
        LinkedList<Character> queue = new LinkedList<Character>();
        String lowerCase = string.toLowerCase();

        for (int i = 0; i < lowerCase.length(); i++) {
            char c = lowerCase.charAt(i);
            if (c >= 'a' && c <= 'z') {
                queue.addLast(c);
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            if (!stack.pop().equals(queue.removeFirst())) {
                return false;
            }
        }

        return true;
    }

     */
}
