import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Stack;

/**
 * 左右括号匹配，用时：25分钟, https://leetcode-cn.com/problems/valid-parentheses/
 * 问题：
 *  对字符串操作太不熟悉了
 *  对包装类、原生类型的理解不到位
 */
public class IsValid_20 {

    public boolean ans(String src) {
        if (src.length() % 2 == 1) { return false; }
        Stack<Character> stack = new Stack<Character>();

        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        for (int i = 0; i < src.length(); ++i) {
            char ch = src.charAt(i);
            if (map.containsKey(ch)) {
                if (stack.isEmpty() || !stack.peek().equals(map.get(ch))) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        return stack.isEmpty();
    }

    public boolean solve(String src) {
        if (src.length() == 0) {
            return true;
        }
        Stack<Character> target = new Stack<>();

        int index = 0;
        target.push(src.charAt(index));
        ++index;
        while (index < src.length()) {
            char nextStr = src.charAt(index);
            if (")".charAt(0) == nextStr) {
                if (target.isEmpty()) {return false;}
                Character pollStr = target.pop();
                if (!"(".equals(pollStr.toString())) {
                    return false;
                }
            } else if ("]".charAt(0) == nextStr) {
                if (target.isEmpty()) {return false;}
                Character pollStr = target.pop();
                if (!"[".equals(pollStr.toString())) {
                    return false;
                }
            } else if ("}".charAt(0) == nextStr) {
                if (target.isEmpty()) {return false;}
                Character pollStr = target.pop();
                if (!"{".equals(pollStr.toString())) {
                    return false;
                }
            } else {
                target.push(nextStr);
            }
            ++index;
        }
        if (!target.isEmpty()) { return false; }
        return true;
    }

    public static void main(String[] args) {
        String[] strings = {
                "[",
                "{}",
                "[]",
                "()",
                "()[]{}",
                "(]",
                "([)]",
                "{[]}",
                ""
        };
        IsValid_20 check = new IsValid_20();
        for (String str : strings) {
            System.out.println("Result: " + check.solve(str));
        }
    }
}
