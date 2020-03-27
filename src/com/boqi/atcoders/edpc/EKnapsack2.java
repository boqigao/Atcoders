package com.boqi.atcoders.edpc;

import java.util.Scanner;

public class EKnapsack2 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int N = sc.nextInt();
        int W = sc.nextInt();
        int[] w = new int[N+1];
        w[0] = 0;
        int[] v = new int[N+1];
        v[0] = 0;
        for (int i = 1; i < N+1; i++){
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }

        //因为这道题的背包巨大10^9，因此用老方法，按照重量从前往后遍历是不行的
        //所以需要按照价值，从前往后遍历

        //dp[][]的意思是：第i个物品之前，价值在价值在j以上的可选的最小的重量
        int[][] dp = new int[105][100001];
        for(int i = 0; i< N+1; i++){
            for(int j = 0; j < 100001; j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        dp[0][0] = 0;
        for(int i = 0; i< N+1; i++){
            for(int j = 0; j < 100001; j++){
                if(j-v[i]>=0){ //如果j比当前物品的价值大，意思是可以把j放进去
                    //这个是重量，所以要逆着计算
                    dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-v[i]]+w[i]);
                }else {
                    dp[i][j] = dp[i-1][j]; //这个i号商品是不能用的，因为价格超出了
                }
            }
        }

        int ans = 100000;
        while (dp[N][ans]>W){ //相当于说找到正好dp[N][ans] < W
            //的那个dp， 为什么呢？
            //因为ans是第i个物品，价值在j的可选的最小重量
            ans--;
        }

        System.out.println(ans);
    }
}
