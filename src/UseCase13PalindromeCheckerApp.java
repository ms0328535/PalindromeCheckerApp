import java.util.Scanner;

public class UseCase13PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== UC13 Performance Comparison ===");

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        StackStrategy stack = new StackStrategy();
        DequeStrategy deque = new DequeStrategy();

        // Stack timing
        long start1 = System.nanoTime();

        boolean result1 = stack.checkPalindrome(input);

        long end1 = System.nanoTime();

        // Deque timing
        long start2 = System.nanoTime();

        boolean result2 = deque.checkPalindrome(input);

        long end2 = System.nanoTime();

        long stackTime = end1 - start1;
        long dequeTime = end2 - start2;

        System.out.println();
        System.out.println("Stack Result : " + result1);
        System.out.println("Stack Time   : " + stackTime + " ns");

        System.out.println();

        System.out.println("Deque Result : " + result2);
        System.out.println("Deque Time   : " + dequeTime + " ns");

        if(stackTime < dequeTime)
            System.out.println("Stack Strategy is faster.");
        else
            System.out.println("Deque Strategy is faster.");

        sc.close();
    }
}