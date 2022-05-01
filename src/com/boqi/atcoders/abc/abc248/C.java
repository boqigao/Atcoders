package com.boqi.atcoders.abc.abc248;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();
        int k = sc.nextInt();
        int x = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        Arrays.sort(a);
        // 1st round, 结束后可以保证要么票用完，要么a[i]全部比票额小
        for (int i = n-1;i >= 0; i--) {
            while (a[i] >= x && k > 0) {
                a[i] -= x;
                k--;
            }
        }
        // 第一轮结束后没票了
        if (k <= 0) {
            System.out.println(Arrays.stream(a).sum());
        } else {
            // 第一轮结束后还有票
            Arrays.sort(a);
            int sum = 0;
            for (int i = 0; i < n-k; i++) {
                sum += a[i];
            }
            System.out.println(sum);
        }

    }
}
