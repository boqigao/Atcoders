package com.boqi.atcoders.abc.abc249;

import java.util.Scanner;

/**
 *  t中存储的是某个数有几个
 *  尝试 a * b = c
 *  令 M = 2 * 10^5
 *  因为 c <= M
 *  所以 当a为1的时候要尝试 m/1次，当a为2的时候要尝试m/2次
 *
 */
public class D {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        final int inf = (int) 2e5;
        var t = new long[inf + 1];
        for (int i = 0; i < n; i++) {
            t[sc.nextInt()]++;
        }
        long ans = 0;
        for (int i = 0; i <= inf; i++) {
            // 注意，这里 j += i的意思是， 因为j一定要整除i，所以不+=i无意义
            /**
             * 举例 比如 6 2 2 3 3
             * 这时候t为[0 0 2 2 0 0 1]
             * 这样直接乘起来的话就已经计算了所有的组合！非常巧妙1
             */
            for (int j = i; j <= inf; j += i) {
                ans += t[i] * t[j] * t[j / i];
            }
        }
        System.out.println(ans);
    }

}
