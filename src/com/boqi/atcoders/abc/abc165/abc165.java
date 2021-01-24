package com.boqi.atcoders.abc.abc165;

import java.util.Scanner;

public class abc165 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int k = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();

        boolean flag = false;
        for (int i = a; i <= b; i++) {
            if (i % k == 0) {
                flag = true;
            }
        }

        System.out.println(flag ? "OK" : "NG");
    }
}
