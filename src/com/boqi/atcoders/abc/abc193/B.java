package com.boqi.atcoders.abc.abc193;

import java.util.Scanner;

public class B {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();
        long[][] stores = new long[n][3];

        for (int i = 0; i < n; i++) {
            stores[i][0] = sc.nextLong();
            stores[i][1] = sc.nextLong();
            stores[i][2] = sc.nextLong();
        }

        long res = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (stores[i][2] > stores[i][0]) {
                res = Math.min(stores[i][1], res);
            }
        }

        System.out.println(res==Long.MAX_VALUE?-1:res);
    }
}
