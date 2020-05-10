import java.util.Arrays;
import java.util.stream.*;

public class varribleTest {

    int x;
    int y;

    static int calSum() {
        int x = 19;
        System.out.println(x);
        return 0;

    }

    public static void main(String[] args) {
        varribleTest.calSum();
    }

    private static void helper(int[] array) {
        Arrays.asList(array).stream().map(e -> 2 * e).forEach(e -> System.out.println(e));
    }
}