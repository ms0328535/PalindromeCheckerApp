import java.util.Stack;

public class PalindromeChecker {

    // Encapsulated palindrome logic
    public boolean checkPalindrome(String text) {

        // Remove spaces and convert to lowercase
        text = text.replaceAll("\\s+", "").toLowerCase();

        Stack<Character> stack = new Stack<>();
        // Push characters into stack
        for(int i=0; i<text.length(); i++) {
            stack.push(text.charAt(i));
        }

        // Compare original with reversed using stack
        for(int i=0; i<text.length(); i++) {
            if(text.charAt(i) != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}