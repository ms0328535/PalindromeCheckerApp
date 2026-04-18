import java.util.Stack;

public class StackStrategy implements PalindromeStrategy {

    public boolean checkPalindrome(String text) {

        text = text.replaceAll("\\s+","").toLowerCase();

        Stack<Character> stack = new Stack<>();

        for(int i=0;i<text.length();i++){
            stack.push(text.charAt(i));
        }

        for(int i=0;i<text.length();i++){
            if(text.charAt(i) != stack.pop()){
                return false;
            }
        }

        return true;
    }
}