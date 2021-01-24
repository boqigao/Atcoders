package com.boqi.atcoders.companies.panasonic20200314;

import java.util.Scanner;

public class DStringEquivalence {
    public static void main(String... args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        calc(n, 0, "");

        scan.close();
    }

    private static void calc(int max, int c, String str) {
        if (str.length() == max) {
            System.out.println(str);
            return;
        }

        for (char i = 0; i < c + 1; i++) {
            String str2 = str + (char) ('a' + i);
            calc(max, Math.max(c, i + 1), str2);
        }
    }
}
