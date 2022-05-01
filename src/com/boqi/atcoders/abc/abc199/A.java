package com.boqi.atcoders.abc.abc199;

import java.util.Scanner;

public class A {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        if (a * a + b * b < c * c) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
