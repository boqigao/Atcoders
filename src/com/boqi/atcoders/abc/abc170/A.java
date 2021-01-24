package com.boqi.atcoders.abc.abc170;

import java.util.Scanner;

public class A {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[] a = new int[5];
        int ans = 0;
        for (int i = 0; i < 5; i++) {
            a[i] = sc.nextInt();
            if (a[i] == 0) {
                ans = i + 1;
            }
        }
        System.out.println(ans);

    }
}
