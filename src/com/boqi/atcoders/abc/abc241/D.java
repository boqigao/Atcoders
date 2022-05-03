package com.boqi.atcoders.abc.abc241;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class D {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int num = sc.nextInt();
        // map 里存的是这个long作为key， integer的个数
        TreeMap<Long, Integer> map = new TreeMap<>();
        Map.Entry<Long, Integer> e;

        for (int i = 0; i < num; i++) {
            int type = sc.nextInt();

            if (type == 1) {
                long x = sc.nextLong();
                map.put(x, map.getOrDefault(x, 0) + 1);
            } else if (type == 2) {
                long x = sc.nextLong() + 1;
                int k = sc.nextInt();
                long ans = -1;
                while (k > 0 && (e = map.lowerEntry(x)) != null) {
                    if (e.getValue() < k) {
                        k -= e.getValue();
                    } else {
                        ans = e.getKey();
                        break;
                    }
                    x = e.getKey();
                }
                System.out.println(ans);
            } else {
                long x = sc.nextLong() - 1;
                int k = sc.nextInt();
                long ans = -1;
                while (k > 0 && (e = map.higherEntry(x)) != null) {
                    if (e.getValue() < k) {
                        k -= e.getValue();
                    } else {
                        ans = e.getKey();
                        break;
                    }
                    x = e.getKey();
                }
                System.out.println(ans);
            }
        }
    }
}

