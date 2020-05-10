import java.util.List;
import java.util.*;

public class Solution {

    // Complete the compareTriplets function below.
    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        List<Integer> result = new ArrayList<>();
        int n = a.size() - 1;
        int i = 0;
        int alice_score = 0;
        int bob_score = 0;
        while (i++ < n) {
            if (a.get(i) > b.get(i)) {
                alice_score++;
            }
            if (a.get(i) < b.get(i)) {
                bob_score++;
            }
        }
        return List.of(alice_score, bob_score);
    }

    public static void main(String[] args) {
        // 5 6 7
        // 3 6 10
        List<Integer> list2 = List.of(17, 28, 30);
        List<Integer> list3 = List.of(99, 16, 8);
        System.out.println(compareTriplets(list2, list3));

    }
}