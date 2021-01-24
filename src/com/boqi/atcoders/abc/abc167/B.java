package com.boqi.atcoders.abc.abc167;

import java.util.Scanner;

public class B {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int k = sc.nextInt();

        if (k <= a) {
            System.out.println(k);
        } else if (k <= a + b) {
            System.out.println(a);
        } else {
            System.out.println(a + b * 0 - (k - a - b));
        }
    }

}
