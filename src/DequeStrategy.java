import java.util.ArrayDeque;
import java.util.Deque;

public class DequeStrategy {

    public boolean checkPalindrome(String text) {

        text = text.replaceAll("\\s+","").toLowerCase();

        Deque<Character> deque = new ArrayDeque<>();

        for(char c : text.toCharArray()){
            deque.addLast(c);
        }

        while(deque.size() > 1){
            if(deque.removeFirst() != deque.removeLast()){
                return false;
            }
        }

        return true;
    }
}