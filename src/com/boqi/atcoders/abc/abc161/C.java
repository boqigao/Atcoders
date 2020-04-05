package com.boqi.atcoders.abc.abc161;

import java.util.Map;
import java.util.Scanner;

public class C {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        long n = sc.nextLong();
        long k = sc.nextLong();

        long res =  n % k;
        long res2 = Math.abs(res-k);
        System.out.println(Math.min(res, res2));

    }
}
