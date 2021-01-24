package com.boqi.atcoders.edpc;

import java.util.Scanner;

public class ICoins {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] p = new int[n];

        for (int i = 0; i < n; i++) {
            p[i] = sc.nextInt();
        }

        //这个dp的意思是，扔第i个硬币的时候，正面是j枚的概率
        int[][] dp = new int[n + 1][n + 1];

        //初始化
        dp[0][0] = 1;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (j > 0) {
                    dp[i][j] = dp[i - 1][j] * (1 - p[i]) + dp[i - 1][j - 1] * p[i];
                } else {
                    dp[i][j] = dp[i - 1][j] * (1 - p[i]);
                }
            }
        }
        int ans = 0;
        for (int j = n / 2 + 1; j < n + 1; j++) {
            ans += dp[n][j];
        }

        System.out.println(ans);
        //关系式


    }
}
