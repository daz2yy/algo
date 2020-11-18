
/**
 * 字符串反转，10分钟，https://leetcode-cn.com/problems/reverse-string/
 * 总结：
 * 1. 数组也是有地址的，只是地址默认为1，所以可以很方便的拿到任意一个元素为之
 * 2. 如果不是数组一样的原理，只是从头到尾的处理，指针的指向
 * 3. 原生数据类型的代码熟练度不够，length 内置成员变量
 */
public class ReverseString_344 {
    public void solve(char[] str) {
        if (str.length <= 1) { return; }
        char tmp;
        for (int i = 0; i < str.length/2; ++i) {
            tmp = str[i];
            str[i] = str[str.length-i-1];
            str[str.length-i-1] = tmp;
        }
    }

    public static void main(String[] args) {
        // char[] str = {'h', 'e', 'l', 'l', 'o'};
        // char[] str = {'h', 'e'};
        char[] str = {'h', 'e', 'l'};
        new ReverseString_344().solve(str);
        System.out.println(str);
    }
}
