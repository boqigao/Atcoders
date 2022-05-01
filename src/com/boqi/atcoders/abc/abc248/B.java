package com.boqi.atcoders.abc.abc248;

import java.util.Scanner;

public class B {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int a = sc.nextInt();
        int b = sc.nextInt();
        double c = Math.sqrt(a*a + b *b);

        System.out.println((double) a / c);
        System.out.println((double) b / c);
    }

}
