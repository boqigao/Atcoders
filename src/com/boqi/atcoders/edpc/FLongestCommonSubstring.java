package com.boqi.atcoders.edpc;

import java.util.Scanner;

/**
 * 有名的最长子字符串问题
 */
public class FLongestCommonSubstring {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String s = sc.next();
        String t = sc.next();

        //dp的定义是：s在第i位，t在j位时候看到的最长共同部分
        int[][] dp = new int[s.length()+1][t.length()+1];

        for(int i = 1; i < s.length()+1; i++){
            for(int j = 1; j < t.length()+1; j++){
                if(s.charAt(i) == t.charAt(j)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[s.length()][t.length()]);

    }



}
