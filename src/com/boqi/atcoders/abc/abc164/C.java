package com.boqi.atcoders.abc.abc164;

import java.util.*;

public class C {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();
        String[] s = new String[n];
        for (int i = 0; i < n; i++){
            s[i] = sc.next();
        }

        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++){
            set.add(s[i]);
        }

        System.out.println(set.size());
    }
}
