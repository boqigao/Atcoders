package com.boqi.atcoders.abc.abc198;

import java.util.Scanner;

public class B {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String s = sc.next();
        if (isPalindrome(s)) {
            System.out.println("Yes");
            return;
        }

        int i = s.length() - 1;
        for (; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                continue;
            } else {
                break;
            }
        }

        String sub = s.substring(0, i+1);
        if(isPalindrome(sub)) {
            System.out.println("Yes");
            return;
        }

        System.out.println("No");
    }

    private static boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        if (sb.reverse().toString().equals(s)) {
            return true;
        } else {
            return false;
        }
    }
}
