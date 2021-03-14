package com.boqi.atcoders.abc.abc193;

import java.util.*;

public class C2 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        long n =sc.nextLong();
        long ans = n;
        Set<Long> memo = new HashSet<>();
        for (int i = 2; i < 100000; i++) {
            for (int j = 2; j < 100; j++) {
                long tmp = (long)Math.pow(i, j);
                if (tmp <= n && !memo.contains(tmp)) {
                    ans--;
                    memo.add(tmp);
                } else {
                    break;
                }
            }

        }
        System.out.println(ans);
    }
}
