package com.boqi.atcoders.abc.abc244;

import java.util.Scanner;

public class C {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        System.out.println(n + 1);
        int k = 2 * n;

        while (k >= 0){
            int cur = sc.nextInt();
            System.out.println(2 * n + 1 - cur + 1);
        }
    }
}
