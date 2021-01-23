package com.boqi.atcoders.abc.abc172;

import java.util.Scanner;

public class C {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        long[] a = new long[n];
        long[] b = new long[m];

        for(int i = 0; i < n; i++){
            a[i] = sc.nextLong();
        }

        for(int i = 0; i < m; i++){
            b[i] = sc.nextLong();
        }

        //总之先把b的读完
        long t = 0;
        for(int i = 0; i < m; i++){
            t+=b[i];
        }

        int ans = 0;
        int j = m;
        for(int i = 0; i < n+1; i++){
            while (j > 0 && t > k){
                --j;
                t -= b[j];
            }

            if(t > k) break;
            ans = Math.max(ans, i+j);
            if(i == n) break;
            t += a[i];
        }

    }
}
