package com.boqi.atcoders.abc.abc158;

import java.util.Scanner;

/**
 * 数球
 * 注意要点
 * 1. 求模
 * 2. Long形
 */
public class CountBalls {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        {
            Long N = sc.nextLong();
            Long A = sc.nextLong();
            Long B = sc.nextLong();

            System.out.println(N/(A+B)*A+Math.min(A, N%(A+B)));
        }
    }
}

