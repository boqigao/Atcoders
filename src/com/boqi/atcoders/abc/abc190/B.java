package com.boqi.atcoders.abc.abc190;

import java.util.Scanner;

public class B {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();
        long s = sc.nextLong();
        long d = sc.nextLong();

        long[] x = new long[n];
        long[] y = new long[n];

        for (int i = 0; i < n; i++) {
            x[i] = sc.nextLong();
            y[i] = sc.nextLong();
        }

        boolean res = false;

        for (int i = 0; i < n; i++) {
            if (x[i] < s && y[i] > d) {
                res = true;
                break;
            }
        }

        System.out.println(res?"Yes":"No");
    }
}
