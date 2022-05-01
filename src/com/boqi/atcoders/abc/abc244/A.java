package com.boqi.atcoders.abc.abc244;

import java.util.Scanner;

public class A {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        String s = sc.next();
        System.out.println(s.charAt(n-1));
    }
}
