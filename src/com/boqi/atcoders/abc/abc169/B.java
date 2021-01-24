package com.boqi.atcoders.abc.abc169;

import java.math.BigInteger;
import java.util.Scanner;

public class B {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.next();
            if (a[i].equals("0")) {
                System.out.println("0");
                return;
            }
        }

        BigInteger ans = new BigInteger("1");
        BigInteger val = new BigInteger("1000000000000000000");
        for (int i = 0; i < n; i++) {

            BigInteger mul1 = new BigInteger(a[i]);

            ans = ans.multiply(mul1);

            if (ans.compareTo(val) == 1) {
                System.out.println("-1");
                return;
            }
        }

        System.out.println(ans.toString());

    }
}
