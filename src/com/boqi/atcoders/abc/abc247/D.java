package com.boqi.atcoders.abc.abc247;

import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * 使用队列，然后编码化，不要真正去实现一个桶
 */
public class D {

    static ArrayDeque<Query> que = new ArrayDeque<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int Q = sc.nextInt();
        while (Q-- > 0) {
            int n = sc.nextInt();
            if (n == 1) {
                long x = sc.nextLong();
                long c = sc.nextLong();
                que.addLast(new Query(x, c));
            } else {
                long c = sc.nextLong();
                printSum(c);
            }
        }
        sc.close();
    }

    static void printSum(long c) {
        long sum = 0;

        while (c > 0) {
            Query q = que.poll();

            sum += q.x * Math.min(c, q.c);

            if (c < q.c)
                que.addFirst(new Query(q.x, q.c - c));

            c -= q.c;
        }

        System.out.println(sum);
    }
}

class Query {
    long x, c;
    Query(long x, long c) {
        this.x = x; this.c = c;
    }
}
