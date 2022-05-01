package com.boqi.atcoders.abc.abc249;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class B {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String s = sc.next();

        char[] chars = s.toCharArray();
        boolean small = false;
        boolean big = false;

        Set<Character> set =new HashSet<>();

        for (Character c : chars) {
            if (set.contains(c)) {
                System.out.println("No");
                return;
            }
            if ('a' <= c && c <= 'z') {
                small = true;
            } else if ('A' <= c && c <= 'Z') {
                big = true;
            }
            set.add(c);
        }

        if (small && big) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
