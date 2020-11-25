
/**
 * 总结：
 * 1. 思路错误，一开始想着怎么枚举、回溯，情况太复杂，推进不下去
 * 2. 状态分解的不清晰
 * 3. 没有dp思维：多状态决策模型，第一步：定义状态，第二步：用之前的状态推导当前的状态
 */
public class MatchParthess {
    public boolean check(String s, int sl, String p, int pl) {
        // char s0 = s.charAt(sl);
        // char p0 = s.charAt(pl);
        // if (s0 == p0) { return check(s, sl+1, p, pl+1); }
        // else if (p0 == '.') {
        //     if (pl != p.length()-1 && p.charAt(pl+1) == '*') {
        //         for (int i = 0; i < p.length()-pl; ++i) {
        //             return check(s, s+i, p, pl);
        //         }

        //     }
        // }
        // else if (p0 == '*') { 
        //     // 前一个字符是否为 . 或和当前的 s0 匹配
        //     if (pl > 0) {
        //         if (p.charAt(pl-1) == s0)
        //     }
        // }

        return true;
    }
    public boolean isMatch(String s, String p) {

        return true;
    }
}
