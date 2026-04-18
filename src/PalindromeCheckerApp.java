public class PalindromeCheckerApp {

    public static void main(String[] args) {

        // ✅ UC1 — Application Details
        System.out.println("====================================");
        System.out.println("     PALINDROME CHECKER APP");
        System.out.println("     Version: 1.0");
        System.out.println("====================================");

        System.out.println("Welcome to the Palindrome Checker Application!");

        // ✅ UC2 — Hardcoded Palindrome
        String str = "madam";

        String rev = new StringBuilder(str).reverse().toString();

        if (str.equals(rev)) {
            System.out.println("The word '" + str + "' is a Palindrome");
        } else {
            System.out.println("The word '" + str + "' is NOT a Palindrome");
        }
    }
}