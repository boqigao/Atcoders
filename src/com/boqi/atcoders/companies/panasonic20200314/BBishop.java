package com.boqi.atcoders.companies.panasonic20200314;

import java.math.BigInteger;
import java.util.Scanner;

public class BBishop {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long h = sc.nextLong();
        long w = sc.nextLong();
        if (h == 1 || w == 1) {
            System.out.println(1);
        } else {
            BigInteger ans = new BigInteger(Long.toString(h / 2));
            ans = ans.multiply(new BigInteger(Long.toString(w)));
            if (h % 2 == 1) {
                ans = ans.add(new BigInteger(Long.toString((w + 1) / 2)));
            }
            System.out.println(ans);


        }
    }
}
