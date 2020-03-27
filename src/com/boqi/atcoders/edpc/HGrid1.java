package com.boqi.atcoders.edpc;

import java.util.ArrayList;
import java.util.Scanner;

public class HGrid1 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int h = sc.nextInt();
        int w = sc.nextInt();
        //ArrayList<String> a = new ArrayList<>();

        String[] a = new String[h];

        for(int i = 0; i < h; i++){
            a[i] = sc.next();
        }

        long res = 0;

        //dp指的是到达h，w坐标的最多数字
        long[][] dp = new long[h+1][w+1];
        for(int i = 0; i < h; i++){
            if(a[i].charAt(0)!='#'){
                dp[i][0]=1;
            }else {
                break;
            }
        }

        for(int j = 0; j < w; j++){
            if(a[0].charAt(j)!='#'){
                dp[0][j]=1;
            }else {
                break;
            }
        }

        for(int i = 1; i < h; i++){
            for(int j = 1; j < w; j++){
                if(a[i].charAt(j) == '#'){//如果这个地方是个砖块，那dp肯定是0
                    dp[i][j] = 0;
                }else {
                    dp[i][j] = (dp[i-1][j] + dp[i][j-1])%1000000007;
                }
            }
        }

        System.out.println(dp[h-1][w-1]);

    }
}
