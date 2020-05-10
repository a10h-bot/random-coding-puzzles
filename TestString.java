import java.util.Arrays;

public class TestString {

    public static void main(String[] args) {
        String value = "7" + "8";
        System.out.println(value);
        System.out.println(Integer.valueOf(value));
        StringBuffer[] val = { new StringBuffer("90"), new StringBuffer("100"), new StringBuffer("890") };

        System.out.println(Arrays.toString(val));
    }
}