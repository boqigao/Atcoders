package com.boqi.atcoders.abc.abc246;

import java.util.Scanner;

public class D {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int q = sc.nextInt();
        int[][] qs = new int[q][3];
        for (int i = 0; i < q; i++) {
            qs[i][0] = sc.nextInt();
            qs[i][1] = sc.nextInt();
            qs[i][2] = sc.nextInt();
        }

        int[] ans = new int[q];

        for (int i = 0; i < q; i++) {
            for (int j = qs[i][0] - 1; j <= qs[i][1] - 1; j++) {
                if (a[j] == qs[i][2]) {
                    ans[i]++;
                }
            }
        }

        for (int i = 0; i < q; i++) {
            System.out.println(ans[i]);
        }
    }

}
