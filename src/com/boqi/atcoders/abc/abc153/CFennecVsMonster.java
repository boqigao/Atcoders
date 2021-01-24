package com.boqi.atcoders.abc.abc153;

import java.util.Arrays;
import java.util.Scanner;

public class CFennecVsMonster {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        long[] h = new long[n];

        for (int i = 0; i < n; i++) {
            h[i] = sc.nextLong();
        }

        long res = 0;
        if (n <= k) {
            System.out.println(0);
        } else {
            Arrays.sort(h);
            for (int i = 0; i < n - k; i++) {
                res += h[i];
            }
            System.out.println(res);
        }
    }
}
