package com.boqi.atcoders.abc.abc197;

import java.util.Scanner;

public class A {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String s = sc.next();
        char[] sCh = s.toCharArray();
        char a = sCh[0];
        char b = sCh[1];
        char c = sCh[2];

        char tmp = a;
        sCh[0] = b;
        sCh[1] = c;
        sCh[2] = tmp;

        System.out.println(new String(sCh));
    }
}
