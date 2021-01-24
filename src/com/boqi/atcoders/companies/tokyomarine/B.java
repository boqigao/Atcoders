package com.boqi.atcoders.companies.tokyomarine;

import java.util.Scanner;

public class B {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        long a = sc.nextLong();
        long v = sc.nextLong();
        long b = sc.nextLong();
        long w = sc.nextLong();
        long t = sc.nextLong();

        if (a == b && v == w) {
            System.out.println("YES");
            return;
        }

        double dis = Math.abs((a - b) * 1.0);
        double speedDiff = (v - w) * 1.0;
        if (speedDiff <= 0 && dis != 0) {
            System.out.println("NO");
        } else {
            System.out.println(dis / speedDiff > t ? "NO" : "YES");
        }
    }
}
