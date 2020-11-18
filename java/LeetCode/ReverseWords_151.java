import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 字符串单词反转
 * 总结：
 * 1. 标准库使用太生疏了，几行代码的事
 * List, Arrays, Collections, String.join
 * trim, 正则表达式
 */
public class ReverseWords_151 {
    public String cankao(String s) {
        s = s.trim();
        List<String> res = Arrays.asList(s.split("\\s+"));
        Collections.reverse(res);
        return String.join(" ", res);
    }

    public String solve(String s) {
        if (s.equals("")) return "";
        String[] arr = s.trim().split("\\s+");
        for (int i = 0; i < arr.length/2; ++i) {
            String tmp = arr[i];
            arr[i] = arr[arr.length-i-1];
            arr[arr.length-i-1] = tmp;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; ++i) {
            sb.append(arr[i]);
            if (i != arr.length-1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] tests = {
            "hello",
            "  hello  ",
            "",
            "     hello  world  ",
            "the sky is blue",
            "a good   example",
            "  Bob    Loves  Alice   ",
            "Alice does not even like bob"
        };
        for (String test : tests) {
            System.out.println(new ReverseWords_151().solve(test));
            System.out.println(new ReverseWords_151().cankao(test));
        }
    }
}
