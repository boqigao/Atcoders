package com.boqi.atcoders.abc.abc187;

import java.util.Scanner;

public class B {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int n = sc.nextInt();
        int[][] points = new int[n][2];

        for(int i=0; i<n; i++) {
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
        }
        if (n == 1) {
            System.out.println(0);
            return;
        }
        int res = 0;
        for(int i = 0; i < n-1; i++){
            for(int j = i+1; j < n; j ++) {
                int dy = points[j][1]-points[i][1];
                int dx = points[j][0]-points[i][0];

                if ( (double)dy/dx <=1 && (double)dy/dx >= -1) {
                    res++;
                }
            }
        }
        System.out.println(res);
    }
}
