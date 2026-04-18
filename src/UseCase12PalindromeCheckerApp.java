import java.util.Scanner;

public class UseCase12PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== UC12 Strategy Pattern Palindrome Checker ===");

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        System.out.println("Choose Strategy:");
        System.out.println("1. Stack Strategy");
        System.out.println("2. Deque Strategy");

        System.out.print("Enter choice: ");
        int choice = sc.nextInt();

        PalindromeStrategy strategy;

        if(choice == 1)
            strategy = new StackStrategy();
        else
            strategy = new DequeStrategy();

        boolean result = strategy.checkPalindrome(input);

        if(result)
            System.out.println(input + " is a Palindrome");
        else
            System.out.println(input + " is NOT a Palindrome");

        sc.close();
    }
}