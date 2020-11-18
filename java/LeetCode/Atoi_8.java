/**
 * 字符串转数字，30分钟，https://leetcode-cn.com/problems/string-to-integer-atoi/
 * 总结：
 * 1. Character 的使用不熟练
 * 2. - '0' 的操作 trick
 * 改进：
 * 1. 使用减法来实现（Java Integer.parseInt 的实现），这样可以避免 flag 的判断正负
 * 2. Character.digit(ch, radix) 可以直接转换数字
 * 3. 上下限先除以 radix 就能避免溢出了，用 int
 */
class Atoi_8 {
    public int myAtoi(String s) {
        s = s.trim();
        // s = "-42";
        // s = "4193 with words";
        // s = "-91283472332";
        if (s.equals("")) {return 0;}

        int index = 0;
        int flag = 1;
        if (s.charAt(index) == '-') { flag = -1; index++; }
        else if (s.charAt(index) == '+') { index++; }

        long result = 0;
        while (index < s.length()) {
            if (Character.isDigit(s.charAt(index))) {
                int digit = s.charAt(index++) - '0';
                result = result*10 + digit;
                if (flag == 1 && result >= Integer.MAX_VALUE) { return Integer.MAX_VALUE; }
                else if (flag == -1 && result*-1 <= Integer.MIN_VALUE) { return Integer.MIN_VALUE; }
            } else {
                return (int)result * flag;
            }
        }
        return (int)result * flag;
    }
}