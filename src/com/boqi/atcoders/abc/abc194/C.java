package com.boqi.atcoders.abc.abc194;

import java.util.Scanner;

public class C {
    static Scanner sc = new Scanner(System.in);
    public static void tle(String[] args){
        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        long res = 0;
        for (int i = 0; i < n-1; i++) {
            for (int j = i + 1; j < n; j++) {
                res += (a[i]-a[j]) * (a[i]- a[j]);
            }
        }

        System.out.println(res);
    }

    /**
     * 这道题用到的技巧应该叫桶排序的感觉，因为
     * 所有A的值的限定在 -200 到 200之间
     * 所以我们先统计各个A的个数，利用一个数组cnt
     * @param args
     */
    public static void main (String[] args) {
        int MaxA = 200;

        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int[] cnt = new int[MaxA * 2 + 1];

        for (int i = 0; i < n; i++) {
            // 数组的index必须大于0，所以直接用maxA来做。
            cnt[MaxA + a[i]]++;
        }

        long ans = 0;

        for (int ai = -MaxA; ai <= MaxA; ++ai) {
            for (int aj = -MaxA; aj < ai; ++aj) {
                long x = ai -aj; //取其差值
                /**
                 * 这里实在是非常巧妙，
                 *
                 * 1. 首先，如果一个值没有出现过，那么他的cnt就是0，所以不管怎么
                 * 相乘，都是0.
                 *
                 * 2.
                 * 比如，5 出现 5次，
                 * 8 出现了4次
                 * 那么 数列将是 [5,5,5,5,5,8,8,8,8]
                 * 这样的话，每一个5，将会和4个做计算，也就是
                 * “5” 个 5 和 “4” 个 8的差值平方（3*3）
                 * 那么3 * 3一共出现了 5*4为20次！！
                 *
                 * 这道题做不出来的确活该，不懂就是不懂
                 */
                ans += x * x * cnt[MaxA + ai] * cnt[MaxA + aj];
            }
        }

        System.out.println(ans);
    }
}
