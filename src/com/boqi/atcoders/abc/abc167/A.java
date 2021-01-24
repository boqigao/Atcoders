package com.boqi.atcoders.abc.abc167;

import java.util.Scanner;

public class A {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String s = sc.next();
        String t = sc.next();

        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                flag = false;
            }
        }

        System.out.println(flag ? "Yes" : "No");
    }
}
