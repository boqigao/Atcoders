package com.boqi.atcoders.abc.abc245;

import java.util.Scanner;

public class D {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] a = new int[n + 1];
        int[] b = new int[m + 1];
        int[] c = new int[n + m + 1];
        for (int i = 0; i <= n; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 0; i <= n + m; i++) {
            c[i] = scanner.nextInt();
        }

        for (int i = m; i >= 0; i--) {
            b[i] = c[n + i] / a[n];
            for (int j = n - 1; j >= 0; j--) {
                c[j + i] -= b[i] * a[j];
            }
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i <= m; i++) {
            answer.append(Integer.toString(b[i]));
            if (i < m) {
                answer.append(" ");
            }
        }

        System.out.println(answer.toString());
    }

}
