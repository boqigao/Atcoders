package com.boqi.atcoders.abc.abc162;

import java.util.Scanner;

public class C {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int k = sc.nextInt();

        int[] abc = new int[3];
        int sum = 0;
        for(int a = 1; a<=k; a++){
            for(int b = 1; b<=k; b++){
                for(int c = 1; c<=k; c++){
                    abc[0] = a;
                    abc[1] = b;
                    abc[2] = c;

                    sum += getMoreBigDiv(abc, 3);

                }
            }
        }

        System.out.println(sum);
    }

    public static int getBigDiv(int a, int b) {// 求两个数的最大公约数
        if (b == 0)
            return a;
        return getBigDiv(b, a % b);
    }

    public static int getSmallMul(int a, int b) {// 求两个数的最小公倍数
        return (a * b) / getBigDiv(a, b);
    }

    public static int getMoreBigDiv(int num[], int n) { // 求多个数的最大公约数
        if (n == 1)
            return num[n - 1];
        return getBigDiv(num[n - 1], getMoreBigDiv(num, n - 1));
    }

    public static int getMoreSmallMul(int num[], int n) {// 求多个数的最小公倍数
        if (n == 1)
            return num[n - 1];
        return getSmallMul(num[n - 1], getMoreSmallMul(num, n - 1));
    }
}
