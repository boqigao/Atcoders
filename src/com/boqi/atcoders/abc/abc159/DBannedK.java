package com.boqi.atcoders.abc.abc159;

import java.util.Scanner;

public class DBannedK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int res = 0;
        for (int k = 0; k < n; k++) { // 计算被忽略的k
            for (int h = 0; h < n; h++) { // 储存第一个数字
                for (int j = 0; j < n; j++) { // 储存第二个数字
                    if (a[h] == a[j] && h != j && h != k && j != k) {
                        res++;
                    }
                }
            }
            res /= 2;
            System.out.println(res);
            res = 0;
        }
    }
}
