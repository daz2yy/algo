import java.util.*;

/**
 * 匹配最长的合法括号，返回长度
 */
public class LongestValidParentheses_32 {

    public int solve(String str) {
        if (str.length() == 0) { return 0; }
        Stack<Character> stack = new Stack<>();
        int maxLength = 0;
        int curLength = 0;
        int preMax = 0;
        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) == '(') {
                if (stack.isEmpty()) { curLength = 0; }
                stack.push(str.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    curLength = 0;
                    preMax = 0;
                } else {
                    stack.pop();
                    curLength += 2;
                    if (stack.isEmpty()) {
                        preMax += curLength;
                        if (preMax > maxLength) { maxLength = preMax; }
                    }
                }
            }
        }
        if (!stack.isEmpty() && maxLength == 0 && curLength != 0) { maxLength = 2; }
        return maxLength;
    }

    public static void main(String[] args) {
        String[] cases = {
                "()",           // =====> 2
                "(",            // =====> 0
                ")",            // =====> 0
                ")()()(",       // =====> 4
                ")()()()",      // =====> 6
                "()())",        // =====> 4
                "(()()()()",    // =====> 8
                "()()())",      // =====> 6
                "()()()(",      // =====> 6
                "(((()",        // =====> 2
                "()(()",        // =====> 2
                "(()(((()",     // =====> 2
                "(()(((()()(((",     // =====> 2
        };
        for (String str : cases) {
            System.out.println(new LongestValidParentheses_32().solve(str));
        }
    }
}
