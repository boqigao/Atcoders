package com.boqi.atcoders.edpc;

import java.util.Scanner;

public class BFrog2 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] h = new int[n + 1];
        h[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            h[i] = sc.nextInt();
        }

        int[] dp = new int[100005];

        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + Math.abs(h[i - 1] - h[i]);

            for (int j = 2; j < k + 1; j++) {
                if (i - j >= 1) {
                    dp[i] = Math.min(dp[i], dp[i - j] + Math.abs(h[i - j] - h[i]));
                }
            }
        }

        System.out.println(dp[n]);
    }
}
