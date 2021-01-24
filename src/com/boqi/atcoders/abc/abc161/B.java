package com.boqi.atcoders.abc.abc161;

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

        int cnt = 0;
        int sum = Arrays.stream(a).sum();
        double temp = 4.0 * m;
        double line = sum / temp;


        for (int i = 0; i < n; i++) {
            if (a[i] >= line) {
                cnt++;
            }
        }

        System.out.println(cnt >= m ? "Yes" : "No");
    }
}
