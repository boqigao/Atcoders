package com.boqi.atcoders.abc.abc153;

import java.util.Scanner;

public class ECrestedIbisVsMonster {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int h = sc.nextInt();
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        int[][] arr = new int[n][2];
        int[] dp = new int[h+10001];


        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
            arr[i][0] = a[i];
            arr[i][1] = b[i];
        }

        for(int i = 0; i < h+1; i++){
            dp[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j<arr[i][0]; j++){
                dp[j] = Math.min(dp[j], arr[i][1]);
            }
            for (int j = arr[i][0]; j<h+1; j++){
                dp[j] = Math.min(dp[j], dp[j-arr[i][0]] + arr[i][1]);
            }
        }

        System.out.println(dp[h-1]);
    }
}
