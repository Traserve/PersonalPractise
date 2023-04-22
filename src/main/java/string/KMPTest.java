package string;

import com.alibaba.fastjson.JSON;

public class KMPTest {

    public static void main(String[] args) {
        System.out.print(StrContains("ababcaababcaabc", "ababcaabc"));
        System.out.print(StrContains("aabaaabaaac", "aabaaac"));
    }

    public static int StrContains(String ts, String ps) {
        int[] next = buildNext(ps);
        System.out.println(JSON.toJSONString(next));
        int i = 0, j = 0;
        for (; i < ts.length(); i++) {
            while (j < ps.length()) {
                if (ts.charAt(i) == ps.charAt(j)) {
                    j++;
                    break;
                } else if (j == 0) {
                    break;
                } else {
                    j = next[j - 1];
                }
            }
            if (j == ps.length()) {
                break;
            }
        }
        if (j == ps.length()) {
            return i - ps.length() + 1;
        }
        return -1;
    }

    public static int[] buildNext(String s) {
        int[] next = new int[s.length()];
        next[0] = 0;
        int p = 0;
        for (int i = 1; i < next.length; i++) {
            p = next[i - 1];
            while (p >= 0) {
                if (s.charAt(i) == s.charAt(p)) {
                    next[i] = p + 1;
                    break;
                } else if (p == 0) {
                    break;
                } else {
                    p = next[p - 1];
                }
            }
        }
        return next;
    }
}
