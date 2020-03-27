package com.boqi.atcoders.edpc;

import java.util.Scanner;

/**
 *
 */
public class DKnapsack1 {
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

        long[][] dp = new long[105][W+1];

        /**
         * ナップサックDPなのだ！
         * dp[i]=(i番目までの品物を、重さがW以下になるように選んだときの価値の最大値)
         * じゃやっぱりダメで、次の品物を使っていいかどうかがわからないのだ。
         * 次の品物を使っていいかどうかは、前までの重さがわかってればわかりそうな気がするから
         * dp[i][j]=(i番目までの品物を、重さがj以下になるように選んだときの価値の最大値)
         * を考えるのだ。するとdp[i][j]は、
         * i番目の品物を使うとき「i−1番目までで重さがj−w[i]以下の価値の最大値+v[i]」
         * 使わないとき「i−1番目までの重さがj以下の価値の最大値」
         * という2つの場合の大きい方になるのだ
         */

        for(int i = 1; i < N+1; i++){ //遍历所有商品
            for(int j = 0; j < W + 1; j++){ //遍历直到背包中最大大小
                if(j-w[i]>=0) { //如果商品i能够被放入重量为j的背包
                    dp[i][j] = Math.max(dp[i-1][j], v[i] + dp[i-1][j-w[i]]);
                    //这里是背包问题更新的核心
                    //两个要点 dp[i-1][j] 就是不把新的商品放入背包的选项，有可能放了还没有以前价值高
                    //dp[i-1][], 就是放这个商品i前的最大价值
                    //dp[i-1][j-w[i]] 就是重量j抛去了i商品的重量的最大价值
                    //再加上i商品的最大价值，那就是能计算i商品价值的极限了
                }else {//商品i不能放入重量为j的背包
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[N][W]);

    }
}
