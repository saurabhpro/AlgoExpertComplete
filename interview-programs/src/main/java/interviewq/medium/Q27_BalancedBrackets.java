package interviewq.medium;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Q27_BalancedBrackets {

    public static boolean balancedBrackets(String str) {
        System.out.println(str);
        Deque<Character> stack = new LinkedList<>();
        List<Character> open = List.of('{', '(', '[');
        List<Character> closed = List.of('}', ')', ']');

        for (char c : str.toCharArray()) {
            if (open.contains(c)) {
                stack.push(c);
            } else if (closed.contains(c)) {
                // base case illegal char
                if (stack.isEmpty()) {
                    return false;
                }

                char popped = stack.pop();
                //if popped char is legal it should be a valid open
                if (open.indexOf(popped) != closed.indexOf(c)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
