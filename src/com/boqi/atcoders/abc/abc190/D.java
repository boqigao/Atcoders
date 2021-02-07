package com.boqi.atcoders.abc.abc190;

import java.util.Scanner;

/**
 * 等差数列的初项 S， 长度 L
 * 等差数列的合 是 平均* L
 * 平均是（初项+末项） / 2
 * 又因为他定死了公差为1
 * 所以末项 = S+L-1
 * 所以总和：N = (2S+L-1)*L / 2
 * 因此 2N = (2S+L-1) * L
 *
 * 因为要做某种全探索
 * 因为N已知，所以我们考虑尝试所有的L，来使得S是整数
 * 所以
 * s = (2N/L-1L+1)/2
 * 可以知道l是2n的约数
 */
public class D {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int cnt = 0;
        long n = sc.nextLong();
        long n2 = n*2;
        long tmp;
        for (long x = 1; x * x <= n2; x++) {
            tmp = (n2 / x) - (x - 1);
            if (tmp % 2 == 0) {
                cnt++;
            }
        }
        // 这里为什么要*2呢，因为算出的x只是约数的前一半，还需要计算后一半
        System.out.println(cnt*2);
    }
}
