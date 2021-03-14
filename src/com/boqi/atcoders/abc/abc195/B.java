package com.boqi.atcoders.abc.abc195;


import java.util.Scanner;

/**
 * 为啥我这么笨呢
 *
 * 只要尝试橘子的数量
 * n = 1,2,3,4.。。即可
 *
 * a * n 是n个橘子能够带来重量的最小值
 * b * n 是n个橘子能带来重量的最大值
 * 只要 a * n < w * 1000 < b * n
 * 那么一定可以取到这个结果
 */

public class B {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int a = sc.nextInt();
        int b = sc.nextInt();
        int w = sc.nextInt();
        w = w * 1000;

        int min = Integer.MAX_VALUE;
        int max = 0;
        boolean found = false;
        for (int n = 1; n < w / a + 1; n++) {
            if (n * a <= w && n * b >=w) {
                found = true;
                min = Math.min (n, min);
                max = Math.max(n, max);
            }
        }

        if (found) {
            System.out.println(min);
            System.out.println(max);
        } else  {
            System.out.println("UNSATISFIABLE");
        }


    }
}
