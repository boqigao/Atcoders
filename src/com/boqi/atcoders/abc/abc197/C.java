package com.boqi.atcoders.abc.abc197;

import java.util.Scanner;

/**
 * 这道题的核心是如何尝试！
 *
 * 举例：如果一个数列形如
 *
 * 1 5 6 3 5
 * 那么如果要分组的时候，在每两个数之间要么分一组，要么不分
 * 所以一共是 2 ^(n-1)种分组情况，只要将其全部尝试就可以
 */
public class C {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int res = Integer.MAX_VALUE;
        // 尝试所有的分组情况
        for (int s = 0; s < 1<<(n-1); s++) {
            int xored = 0;
            int ored = 0;

            // 对于每一组数字做or判定
            for (int i = 0; i < n; i++) {
                if (i < n) {
                    ored |= a[i];
                }
                // 如果 s的第i位是1的话，那么就相当于分组，所以要使用xored

                if (i == n || (s >> i & 1) ==1) {
                    xored ^= ored;
                    ored = 0;
                }
            }

            res = Math.min(res, xored);
        }
        System.out.println(res);
    }
}
