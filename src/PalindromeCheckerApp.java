import java.util.*;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        // ✅ UC1 — Application Details
        System.out.println("====================================");
        System.out.println("     PALINDROME CHECKER APP");
        System.out.println("     Version: 1.0");
        System.out.println("====================================");

        System.out.println("Welcome to the Palindrome Checker Application!");

        // ✅ UC2 — Hardcoded Palindrome (StringBuilder)
        String str = "madam";
        String rev = new StringBuilder(str).reverse().toString();

        if (str.equals(rev)) {
            System.out.println("The word '" + str + "' is a Palindrome");
        } else {
            System.out.println("The word '" + str + "' is NOT a Palindrome");
        }

        // ✅ UC3 + UC4 — User Input + Case-Insensitive + FOR LOOP
        Scanner sc = new Scanner(System.in);

        System.out.print("\nEnter a string: ");
        String input = sc.nextLine();

        String originalInput = input;
        input = input.toLowerCase();

        String reversed = "";

        for (int i = input.length() - 1; i >= 0; i--) {
            reversed = reversed + input.charAt(i);
        }

        if (input.equals(reversed)) {
            System.out.println("Input '" + originalInput + "' is a Palindrome");
        } else {
            System.out.println("Input '" + originalInput + "' is NOT a Palindrome");
        }

        // ============================================
        // ✅ UC6 — Queue + Stack Palindrome Check
        // ============================================

        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            queue.add(ch);     // FIFO
            stack.push(ch);    // LIFO
        }

        boolean isPalindromeQS = true;

        while (!queue.isEmpty()) {
            if (queue.remove() != stack.pop()) {
                isPalindromeQS = false;
                break;
            }
        }

        if (isPalindromeQS) {
            System.out.println("UC6 Result: Input '" + originalInput + "' is a Palindrome (Queue + Stack)");
        } else {
            System.out.println("UC6 Result: Input '" + originalInput + "' is NOT a Palindrome (Queue + Stack)");
        }

        // ============================================
        // ✅ UC7 — Deque Based Palindrome Check
        // ============================================

        Deque<Character> deque = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            deque.addLast(input.charAt(i));
        }

        boolean isPalindromeDeque = true;

        while (deque.size() > 1) {
            char front = deque.removeFirst();
            char rear = deque.removeLast();

            if (front != rear) {
                isPalindromeDeque = false;
                break;
            }
        }

        if (isPalindromeDeque) {
            System.out.println("UC7 Result: Input '" + originalInput + "' is a Palindrome (Deque)");
        } else {
            System.out.println("UC7 Result: Input '" + originalInput + "' is NOT a Palindrome (Deque)");
        }

        // ✅ Close scanner at the end
        sc.close();
    }
}