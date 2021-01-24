package com.boqi.atcoders.edpc;

import java.util.Scanner;

public class AFrog1 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] h = new int[n + 1];
        h[1] = 0;
        for (int i = 1; i < n + 1; i++) {
            h[i] = sc.nextInt();
        }

        int[] dp = new int[n + 1];
        /**
         * dp的核心是类似于数学归纳法
         * 数学方面的东西想清楚是关键
         * 在第n步和之前的步数的关系向好最关键
         *
         * 这个青蛙问题，其实就是你跳到第i个坑的时候，
         * 只和前面的第i-1个坑或者第i-2个坑有关
         * 所以你调到第i个坑的时候，只要求到
         * min（第[i-1]个坑到i个坑， 第【i-2】个坑到第i）个坑哪个消耗大就行了
         */
        for (int i = 2; i < n + 1; i++) {
            if (i - 2 >= 1) {
                dp[i] = Math.min(dp[i - 1] + Math.abs(h[i - 1] - h[i]), dp[i - 2] + Math.abs(h[i - 2] - h[i]));
            } else { //i-2比1小的时候是没有i-2这个坑的
                dp[i] = dp[i - 1] + Math.abs(h[i - 1] - h[i]);
            }
        }

        System.out.println(dp[n]);
    }
}
