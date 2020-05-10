import java.util.Scanner;

// input =5
// 1
// 1 2
// 1 2 3
// 1 2 3 4
// 1 2 3 4 5
//_______________________________
// 1 2 3 4 5 
// 1 2 3 4 
// 1 2 3 
// 1 2 
// 1 
public class printPattern {
    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        helper(n);
        System.out.println("------------------------------------");
        helper2(n);
    }

    private static void helper(int n) {

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");

            }
            System.out.println();
        }

    }

    private static void helper2(int n) {

        for (int i = 5; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");

            }
            System.out.println();
        }

    }
}