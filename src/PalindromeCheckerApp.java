import java.util.Scanner;

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

        // 🔁 Reverse using for loop
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed = reversed + input.charAt(i);
        }

        // 🔍 Compare strings
        if (input.equals(reversed)) {
            System.out.println("Input is a Palindrome");
        } else {
            System.out.println("Input is NOT a Palindrome");
        }

        sc.close();
    }
}