package com.boqi.atcoders.abc.abc172;

import java.util.Scanner;

public class B {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String s = sc.next();
        String t = sc.next();

        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                ans++;
            }
        }

        System.out.println(ans);
    }
}
