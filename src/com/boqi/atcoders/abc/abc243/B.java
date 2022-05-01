package com.boqi.atcoders.abc.abc243;

import java.util.Scanner;

public class B {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }

        int same = 0;
        int diff = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == b[i]) {
                same++;
            }
            for (int j = 0; j < n; j++) {
                if (a[i] == b[j] && i != j) {
                    diff++;
                }
            }
        }
        System.out.println(same);
        System.out.println(diff);
    }
}
