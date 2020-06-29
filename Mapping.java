// This problem was asked by Bloomberg.

// Determine whether there exists a one-to-one character mapping from one string s1 to another s2.

// For example, given s1 = abc and s2 = bcd, return true since we can map a to b, b to c, and c to d.

// Given s1 = foo and s2 = bar, return false since the o cannot map to two characters.

public class Mapping {
    public static void main(String[] args) {
        System.out.println(map("abc", "bcd"));
        System.out.println(map("foo", "bcd"));

    }

    private static boolean map(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        boolean res = false;
        for (var i = 0; i < s1.length(); i++) {
            if ((char) (s1.charAt(i) + 1) == (char) (s2.charAt(i))) {
                res = true;
            }
        }
        return res;
    }
}
