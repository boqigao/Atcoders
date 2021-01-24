package com.boqi.atcoders.abc.abc158;

import java.util.Scanner;

/**
 * 增税
 */
public class TaxIncrease {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int a = sc.nextInt();
        int b = sc.nextInt();

        int ans = -1;
        for (int i = 0; i < 10009; i++) {
            if ((int) (i * 0.08) == a) {
                if ((int) (i * 0.1) == b) {
                    ans = i;
                    break;
                }
            }
        }

        System.out.println(ans);

    }
}
