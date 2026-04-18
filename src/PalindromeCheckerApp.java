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

    // ✅ UC9 — Recursive function
    public static boolean isPalindromeRecursive(String str, int start, int end) {
        if (start >= end) {
            return true;
        }

        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        return isPalindromeRecursive(str, start + 1, end - 1);
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
        // ✅ UC2 — Hardcoded Palindrome
        // ============================================
        String str = "madam";
        String rev = new StringBuilder(str).reverse().toString();

        if (str.equals(rev)) {
            System.out.println("The word '" + str + "' is a Palindrome");
        } else {
            System.out.println("The word '" + str + "' is NOT a Palindrome");
        }

        // ============================================
        // ✅ UC3 & UC4 — User Input + Case-Insensitive
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
        // ✅ UC5 — Stack
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
            System.out.println("UC5 Result: Palindrome (Stack)");
        } else {
            System.out.println("UC5 Result: NOT Palindrome (Stack)");
        }

        // ============================================
        // ✅ UC6 — Queue + Stack
        // ============================================
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        for (char ch : input.toCharArray()) {
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

        System.out.println("UC6 Result: " + (isPalindromeQS ? "Palindrome" : "NOT Palindrome"));

        // ============================================
        // ✅ UC7 — Deque
        // ============================================
        Deque<Character> deque = new ArrayDeque<>();

        for (char ch : input.toCharArray()) {
            deque.addLast(ch);
        }

        boolean isPalindromeDeque = true;

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                isPalindromeDeque = false;
                break;
            }
        }

        System.out.println("UC7 Result: " + (isPalindromeDeque ? "Palindrome" : "NOT Palindrome"));

        // ============================================
        // ✅ UC8 — Linked List
        // ============================================
        Node head = null, tail = null;

        for (char ch : input.toCharArray()) {
            Node newNode = new Node(ch);
            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        Node slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node prev = null, current = slow;

        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        Node first = head, second = prev;
        boolean isPalindromeLL = true;

        while (second != null) {
            if (first.data != second.data) {
                isPalindromeLL = false;
                break;
            }
            first = first.next;
            second = second.next;
        }

        System.out.println("UC8 Result: " + (isPalindromeLL ? "Palindrome (Linked List)" : "NOT Palindrome (Linked List)"));

        // ============================================
        // ✅ UC9 — Recursion
        // ============================================
        boolean isPalindromeRec = isPalindromeRecursive(input, 0, input.length() - 1);

        System.out.println("UC9 Result: " + (isPalindromeRec ? "Palindrome (Recursion)" : "NOT Palindrome (Recursion)"));

        // ============================================
        sc.close();
    }
}