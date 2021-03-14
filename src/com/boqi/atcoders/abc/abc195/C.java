package com.boqi.atcoders.abc.abc195;

import java.util.Scanner;

public class C {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        long n = sc.nextLong();
        String ns = n + "";
        int len = ns.length();

        if (len <= 3) {
            System.out.println(0);
        } else if (len <= 6) {
            System.out.println(n - 999L);
        } else if (len <= 9) {
            System.out.println((n-999999L) * 2L + 999000L);
        } else if (len <= 12) {
            System.out.println(
                    (n-999999999L) * 3L +
                    1998000000L +
                            999000L
            );
        } else if (len <= 15) {
            System.out.println((n-999999999999L) * 4L +
                    2997000000000L +
                    1998000000L +
                    999000L);
        } else {
            System.out.println(3998998998999000L + 5L);
        }
    }
}
