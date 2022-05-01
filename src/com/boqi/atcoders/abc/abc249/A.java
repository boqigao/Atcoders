package com.boqi.atcoders.abc.abc249;

import java.util.Scanner;

public class A {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int e = sc.nextInt();
        int f = sc.nextInt();
        int x = sc.nextInt();

        // takahashi
        int distT = 0;
        for (int i = 0; i < x; i++) {
            int sum = a + c;
            if (i % sum <= a) {
                distT += b;
            }
        }

        int distA = 0;
        for (int i = 0; i < x; i++) {
            int sum = d + f;
            if (i % sum <= d) {
                distA += e;
            }
        }

        if (distT > distA) {
            System.out.println("Takahashi");
        } else if (distA == distT) {
            System.out.println("Draw");
        } else {
            System.out.println("Aoki");
        }
    }
}
