package com.boqi.atcoders.abc.abc167;

import java.util.Scanner;

public class C {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();
        int[][] a = new int[n][m+1];

        for(int i = 0; i < n; i++ ){
            for(int j = 0; j < m+1; j++ ){
                a[i][j] = sc.nextInt();
            }
        }

        int[][]  dp = new int[15][15];


    }
}
