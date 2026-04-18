import java.util.Scanner;
import java.util.Stack;

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

        // ✅ UC3 — User Input + Reverse using FOR LOOP
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String reversed = "";

        for (int i = input.length() - 1; i >= 0; i--) {
            reversed = reversed + input.charAt(i);
        }

        if (input.equals(reversed)) {
            System.out.println("Input is a Palindrome");
        } else {
            System.out.println("Input is NOT a Palindrome");
        }

        // ✅ UC4 — Character Array + Two Pointer
        char[] chars = input.toCharArray();
        int start = 0;
        int end = chars.length - 1;
        boolean isPalindrome = true;

        while (start < end) {
            if (chars[start] != chars[end]) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }

        if (isPalindrome) {
            System.out.println("UC4 Result: Palindrome (Two Pointer)");
        } else {
            System.out.println("UC4 Result: NOT a Palindrome (Two Pointer)");
        }

        // ✅ UC5 — Stack Based Palindrome
        Stack<Character> stack = new Stack<>();

        // Push all characters
        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

        boolean isStackPalindrome = true;

        // Pop and compare
        for (int i = 0; i < input.length(); i++) {
            char popped = stack.pop();
            if (input.charAt(i) != popped) {
                isStackPalindrome = false;
                break;
            }
        }

        if (isStackPalindrome) {
            System.out.println("UC5 Result: Palindrome (Stack)");
        } else {
            System.out.println("UC5 Result: NOT a Palindrome (Stack)");
        }

        sc.close();
    }
}