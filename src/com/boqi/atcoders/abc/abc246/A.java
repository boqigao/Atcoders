package com.boqi.atcoders.abc.abc246;

import java.util.Scanner;

public class A {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] x = new int[3][2];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                x[i][j] = sc.nextInt();
            }
        }
        int a, b = 0;
        if (x[0][0] == x[1][0]) {
            a = x[2][0];
        } else if (x[0][0] == x[2][0]) {
            a = x[1][0];
        } else {
            a = x[0][0];
        }

        if (x[0][1] == x[1][1]) {
            b = x[2][1];
        } else if (x[0][1] == x[2][1]) {
            b = x[1][1];
        } else {
            b = x[0][1];
        }
        System.out.println(a);
        System.out.println(b);
    }
}
