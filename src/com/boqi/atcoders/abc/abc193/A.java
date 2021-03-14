package com.boqi.atcoders.abc.abc193;

import java.util.Scanner;

public class A {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = a-b;
        System.out.println(c/a * 100);
    }
}
