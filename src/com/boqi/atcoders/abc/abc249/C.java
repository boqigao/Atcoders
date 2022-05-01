package com.boqi.atcoders.abc.abc249;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int k = sc.nextInt();
        List<String> list = new ArrayList<>();
        String[] s = new String[n];

        for (int i = 0; i < n; i++) {
            s[i] = sc.next();
        }

        int k2 = 1 << n;
        int ans = 0;
        for (int i = 0; i < k2; i++) {
            int[] bucket = new int[26];
            String tmp = Integer.toBinaryString(i);

            for (int j = 0; j < tmp.length(); j++) {
                // 现在选择了第几组
                int tmpPoint = (i >> j) & 1;
                if (tmpPoint == 1) {
                    for (int l = 0; l < s[j].length(); l++) {
                        bucket[s[j].charAt(l) - 'a']++;
                    }
                }
            }
            int max = 0;
            for (int p = 0; p < 26; p++) {
                if (bucket[p] == k) {
                    max++;
                }
            }
            ans = Math.max(ans, max);
        }

        System.out.println(ans);

    }
}
