import java.util.Map;
import java.util.Stack;

public class balanceParanthesis {
    public static void main(String[] args) {
        String exp = "[()]{}{[()()]()}";
        System.out.println(helper(exp));
    }

    public static String helper(String exp) {
        // create a map to store the opening and closing paranthesis
        final Map<Character, Character> map = Map.of('[', ']', '{', '}', '(', ')');
        // create a stack to temprorarily store the paranthsesis while iteraing over the
        // expression
        final Stack<Character> stack = new Stack<>();
        // result to be stored as boolean in res
        stack.push(exp.charAt(0));
        while (!stack.empty()) {
            for (int i = 1; i < exp.length(); i++) {
                Character c = stack.peek();
                if (map.get(c) == exp.charAt(i)) {
                    stack.pop();
                } else {
                    stack.push(exp.charAt(i));
                }
            }
        }
        if (stack.empty())
            return "YES";
        else
            return "NO";

    }
}
