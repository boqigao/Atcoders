package com.boqi.atcoders.abc.abc245;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class B {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            set.add(sc.nextInt());
        }

        for (int i = 0; i < 2000; i++) {
            if(!set.contains(i)) {
                System.out.println(i);
                return;
            }
        }
    }
}
