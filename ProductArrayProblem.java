import java.util.Arrays;

// Given an array of integers, return a new array such that each element 
// at index i of the new array is the product of all the numbers in the
//  original array except the one at i.

// For example, if our input was [1, 2, 3, 4, 5], 
// the expected output would be [120, 60, 40, 30, 24]. 
// If our input was [3, 2, 1], the expected output would be [2, 3, 6].

// Approach -> 1). loop over every item of the array and replace current item with 
// all other items product in the array.

public class ProductArrayProblem {
    public static void main(final String[] args) {
        final int[] input = new int[] { 1, 2, 3, 4, 5 };
        // Arrays.stream(input).forEach(e -> System.out.println(e));
        // Arrays.stream(helper(input)).forEach(e -> System.out.println(e));
        Arrays.stream(helper1(input)).forEach(e -> System.out.println(e));
        // helper(input);
    }

    // failed attempt
    private static int[] helper(final int[] a) {
        int index = 0;
        int prodSum = 1;
        for (int i = 0; i < a.length; i++) {

            for (int j = i + 1; j < a.length; j++) {
                prodSum *= a[j];
                if (i != 0) {
                    prodSum *= a[j - 1];
                } // System.out.println(prodSum);
            }
            a[index++] = prodSum;
            prodSum = 1;

        }
        return a;
    }

    // failed attempt
    // [1, 2, 3, 4, 5],
    private static int[] helper1(final int[] a) {
        int j = a.length - 1;
        int k = 0;
        int index = 0;
        int prodSum = 1;
        for (int i = 0; i < a.length; i++) {
            if (i == 0) {
                while (i != j) {
                    prodSum *= a[i + 1];
                    i++;
                }
                a[index++] = prodSum;
                prodSum = 1;
            }
            if (i != 0) {
                while (k < i || j > i) {
                    prodSum *= a[k++];
                    prodSum *= a[j--];
                }
                a[index++] = prodSum;
            }
        }
        return a;

    }
}