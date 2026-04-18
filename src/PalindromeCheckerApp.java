import java.util.*;

public class PalindromeCheckerApp {

    // ✅ Node class for UC8 (Linked List)
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {

        // ============================================
        // ✅ UC1 — Application Details
        // ============================================
        System.out.println("====================================");
        System.out.println("     PALINDROME CHECKER APP");
        System.out.println("     Version: 1.0");
        System.out.println("====================================");

        System.out.println("Welcome to the Palindrome Checker Application!");

        // ============================================
        // ✅ UC2 — Hardcoded Palindrome (StringBuilder)
        // ============================================
        String str = "madam";
        String rev = new StringBuilder(str).reverse().toString();

        if (str.equals(rev)) {
            System.out.println("The word '" + str + "' is a Palindrome");
        } else {
            System.out.println("The word '" + str + "' is NOT a Palindrome");
        }

        // ============================================
        // ✅ UC3 & UC4 — User Input + Case-Insensitive + FOR LOOP
        // ============================================
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
        // ✅ UC5 — Stack Based Palindrome Checker
        // ============================================
        Stack<Character> stackUC5 = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            stackUC5.push(input.charAt(i));
        }

        String reversedStack = "";

        while (!stackUC5.isEmpty()) {
            reversedStack += stackUC5.pop();
        }

        if (input.equals(reversedStack)) {
            System.out.println("UC5 Result: Input '" + originalInput + "' is a Palindrome (Stack)");
        } else {
            System.out.println("UC5 Result: Input '" + originalInput + "' is NOT a Palindrome (Stack)");
        }

        // ============================================
        // ✅ UC6 — Queue + Stack Palindrome Check
        // ============================================
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            queue.add(ch);
            stack.push(ch);
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

        // ============================================
        // ✅ UC8 — Linked List Based Palindrome Check
        // ============================================

        // Step 1: Convert string to linked list
        Node head = null, tail = null;

        for (int i = 0; i < input.length(); i++) {
            Node newNode = new Node(input.charAt(i));

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        // Step 2: Find middle (slow & fast pointer)
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 3: Reverse second half
        Node prev = null;
        Node current = slow;

        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        // Step 4: Compare halves
        Node firstHalf = head;
        Node secondHalf = prev;

        boolean isPalindromeUC8 = true;

        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                isPalindromeUC8 = false;
                break;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        if (isPalindromeUC8) {
            System.out.println("UC8 Result: Input '" + originalInput + "' is a Palindrome (Linked List)");
        } else {
            System.out.println("UC8 Result: Input '" + originalInput + "' is NOT a Palindrome (Linked List)");
        }

        // ============================================
        // ✅ Close Scanner
        // ============================================
        sc.close();
    }
}