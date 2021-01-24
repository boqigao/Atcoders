package com.boqi.atcoders.abc.abc187;

import java.util.Scanner;

public class A {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        String a = sc.next();
        String b = sc.next();

        int sumA=0, sumB=0;

        for (int i = 0; i < 3; i++) {
            sumA += a.charAt(i) - 48;
            sumB += b.charAt(i) - 48;
        }

        System.out.println(sumA>sumB?sumA:sumB);
    }
}
