package com.boqi.atcoders.abc.abc248;

import java.util.*;

public class A {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String s = sc.next();
        char[] sChar = s.toCharArray();
        int[] bucket = new int[10];

        for (char c : sChar) {
            bucket[c - '0']++;
        }

        for (int i = 0; i < 10; i++) {
            if (bucket[i] == 0) {
                System.out.println(i);
            }
        }
    }
}
