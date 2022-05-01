package com.boqi.atcoders.abc.abc246;

import java.util.Scanner;

public class B {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        long a = sc.nextLong();
        long b = sc.nextLong();
        long k = sc.nextLong();

        long times = 0;
        for (times = 0; times < 10000000000L; times++) {
            if (a >= b) {
                break;
            }
            a = a * k;
        }
        System.out.println(times);
    }
}
