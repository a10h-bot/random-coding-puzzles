public class isArmStrongNum {
    public static void main(String[] args) {

        // helper(120);
        System.out.println(helper(153.0));
    }

    private static boolean helper(Double num) {
        String numStr = String.valueOf(num);
        int sum = 0;
        int val = 0;
        Double powVal = 0.0;
        int n = numStr.length();
        for (var i = 0; i < n; i++) {
            val = Integer.valueOf(numStr.charAt(i));
            powVal = Math.pow(val, n);
            sum += val;
            System.out.println(sum);

        }
        return val == num;
    }
}