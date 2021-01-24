package com.boqi.atcoders.abc.abc189;

import java.util.Scanner;

// 这道题需要注意浮点数的计算

/**
 * 3 13
 * 30 13
 * 35 13
 * 35 13
 * <p>
 * 比如这样的输入例，本身高桥并没有喝高
 * 但是经过浮点数计算以后，结果很有可能发生偏差
 * 所以我们需要双方*100，就可以避免浮点数的计算！！
 */
public class B {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] v = new int[n];
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            v[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }
        int res = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += v[i] * p[i];
            if (sum > x * 100) {
                res = i + 1;
                break;
            }
        }
        if (sum <= x * 100) {
            res = -1;
        }

        System.out.println(res);
    }
}
