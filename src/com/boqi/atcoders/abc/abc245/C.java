package com.boqi.atcoders.abc.abc245;

import java.util.Scanner;

// dp[i][sum] := 数列のi番目まで確定していて、これまでの総和がsumである組み合わせ

/**
 * dp问题
 * ---
 * dp的定义
 * dp[i] 考虑到xi的时候，使用xi = ai是可以的嘛？
 * ep[i] 考虑到xi的时候，使用xi = bi是可以的嘛？
 * ---
 * dp的初始值
 * dp[1] ： 最开始的时候使用 ai是可以的，所以是true
 * ep[1] : 最开始的时候使用bi是可以的，所以是true
 */
public class C {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n + 1];
        int[] b = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            b[i] = sc.nextInt();
        }
        boolean[] dp = new boolean[n + 1];
        boolean[] ep = new boolean[n + 1];

        dp[1] = true;
        ep[1] = true;


        for (int i = 2; i <= n; i++) {
            if (dp[i - 1] && Math.abs(a[i] - a[i - 1]) <= k) {
                dp[i] = true;
            }

            if (ep[i - 1] && Math.abs(a[i] - b[i - 1]) <= k) {
                dp[i] = true;
            }

            if (dp[i - 1] && Math.abs(b[i] - a[i - 1]) <= k) {
                ep[i] = true;
            }

            if (ep[i - 1] && Math.abs(b[i] - b[i - 1]) <= k) {
                ep[i] = true;
            }
        }
        if (dp[n] || ep[n]) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

    }
}
