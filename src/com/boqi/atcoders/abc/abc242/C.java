package com.boqi.atcoders.abc.abc242;

import java.util.Scanner;

/**
 * 这道题用dp来做
 * 做法是比如dp[][j] = dp[d - 1][j-1], dp[d-1][j], dp[d-1][j + 1];
 * https://atcoder.jp/contests/abc242/editorial/3515
 * dp[d][i]的意义是在第d位数字时候，以i结尾的数字的和
 * */
public class C {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int[][] dp = new int[1048576][10];

        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }
        int mod = 998244353;
        for (int d = 2; d <= n; d++) {
            for (int i = 1; i <= 9; i++) {
                for (int j = Math.max(1, i - 1); j < Math.min(9, i + 1); j++) {
                    dp[d][j] += dp[d - 1][i];
                    dp[d][j] %= mod;
                }
            }
        }
        int res = 0;
        for (int i = 1;i <=9; i++) {
            res+=dp[n][i];
            res %= mod;
        }
        System.out.println(res);
    }
}
