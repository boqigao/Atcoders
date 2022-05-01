package com.boqi.atcoders.abc.strongstudent2;

import java.util.*;

public class B {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(sc.nextInt());
        }

        for (int i = 0; i < m; i++) {
            int b = sc.nextInt();
            if (pq.contains(b)) {
                pq.remove(b);
            } else {
                pq.add(b);
            }
        }
        if (pq.isEmpty()) {
            System.out.println("");
        }
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}
