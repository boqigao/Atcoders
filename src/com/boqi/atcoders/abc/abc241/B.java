package com.boqi.atcoders.abc.abc241;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }

        Arrays.sort(a);
        for (int i = 0; i < m; i++) {
            int idx = Arrays.binarySearch(a, b[i]);
            if (idx >= 0) {
                a[idx] = -1;
                Arrays.sort(a);
            } else {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }
}
