package com.boqi.atcoders.abc.abc161;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();

        Queue<Long> queue = new LinkedList<>();
        for (long i = 1; i <= 9; i++) {
            queue.add(i);
        }
        int i = 0;
        long x = 0;
        long v = 0;
        while (i < K) {
            x = queue.poll();
            i++;
            if (x % 10 != 0) {
                v = 10 * x + (x % 10) - 1;
                queue.add(v);
            }
            v = 10 * x + (x % 10);
            queue.add(v);
            if (x % 10 != 9) {
                v = 10 * x + (x % 10) + 1;
                queue.add(v);
            }
        }
        System.out.println(x);
    }
}
