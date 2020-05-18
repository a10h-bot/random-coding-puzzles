//int [] a = {-2, -3, 4, -1, -2, 1, 5, -3};

//-2,-3, 4= -1
//4,-1,-2,5 = 6
//windows sliding problem

// Kadane Algorithms

public class largestContiguousSum {
    public static void main(String[] args) {
        int[] a = { -2, -3, 4, -1, -2, 1, 5, -3 };
        System.out.println(helper(a));
    }

    private static int helper(int[] a) {
        int max_ending_here = 0;
        int max_so_far = Integer.MIN_VALUE;
        int n = a.length;
        for (var i = 0; i < n; i++) {
            max_ending_here = max_ending_here + a[i];
            if (max_ending_here > max_so_far) {
                max_so_far = max_ending_here;
            }
            if (max_ending_here < 0) {
                max_ending_here = 0;
            }

        }
        return max_so_far;
    }

}
