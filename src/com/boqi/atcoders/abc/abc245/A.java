package com.boqi.atcoders.abc.abc245;

import java.util.Scanner;

public class A {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c= sc.nextInt();
        int d= sc.nextInt();
        if(a < c) {
            System.out.println("Takahashi");
        } else if (a > c) {
            System.out.println("Aoki");
        } else {
            if (b <= d) {
                System.out.println("Takahashi");
            } else {
                System.out.println("Aoki");
            }
        }
    }
}
