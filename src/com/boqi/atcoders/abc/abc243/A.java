package com.boqi.atcoders.abc.abc243;

import java.util.Scanner;

public class A {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int v = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        while (v >= 0) {
            v -= a;
            if (v < 0) {
                System.out.println("F");
                break;
            }
            v -= b;
            if (v < 0) {
                System.out.println("M");
                break;
            }
            v -= c;
            if (v < 0) {
                System.out.println("T");
                break;
            }
        }
    }
}
