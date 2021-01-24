package com.boqi.atcoders.companies.panasonic20200314;

import java.util.Scanner;

public class CSqrt {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long c = sc.nextLong();
        if (a + b < c && 2 * a * b + 2 * c * a + 2 * c * b < c * c + b * b + a * a) System.out.println("Yes");
        else System.out.println("No");
    }
}
