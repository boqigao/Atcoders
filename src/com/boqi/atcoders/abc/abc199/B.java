package com.boqi.atcoders.abc.abc199;

import java.util.Arrays;
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

        Arrays.sort(a);
        Arrays.sort(b);
        System.out.println(b[0] - a[n-1] >=0?b[0]-a[n-1] + 1:0);

    }
}
