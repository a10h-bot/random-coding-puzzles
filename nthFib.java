//package MayCodingPractice;
// calculate nth fibonacci number

import java.util.Arrays;
import java.util.Scanner;

public class nthFib {
    public static void main(final String[] args) {
        final Scanner sc = new Scanner(System.in);
        final int n = sc.nextInt();
        // System.out.println(fibHelper(n));
        System.out.println(fibHelper3(n));
    }

    // 1, 1 , 2, 3, 5, 8, 13, 21, 34
    private static int fibHelper(final int n) {

        if (n == 0 || n == 1)
            return 1;
        return fibHelper(n - 1) + fibHelper(n - 2);
    }

    private static int fibHelper2(final int n) {
        final int[] buffer = new int[n + 1];
        Arrays.fill(buffer, 0);
        if (n == 0 || n == 1)
            return 1;

        if (buffer[n] != 0) {
            return buffer[n];
        }
        buffer[n] = fibHelper2(n - 1) + fibHelper2(n - 2);
        return buffer[n];
    }

    private static int fibHelper3(final int n) {
        final int[] buffer = new int[n + 1];
        // Arrays.fill(buffer, 0);
        if (n == 0 || n == 1)
            return 1;
        buffer[0] = 1;
        buffer[1] = 1;
        for (int i = 2; i <= n; i++) {
            buffer[i] = buffer[i - 1] + buffer[i - 2];
        }
        return buffer[n];
    }
}