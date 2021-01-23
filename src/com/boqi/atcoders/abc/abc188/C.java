package com.boqi.atcoders.abc.abc188;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

// 淘汰赛的m回对战的话，会有m-1次对战
// 用队列来做！
// 两个人打完之后，胜者加入到队列末尾，然后再两个人打，然后再加
public class C {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        int n = sc.nextInt();
        int n2 = 1<<n;
        int[] a = new int[n2];

        Queue<Integer> q = new LinkedList<Integer>();

        Map <Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n2; i++) {
            int tmp = sc.nextInt();
            q.offer(tmp);
            map.put(tmp, i+1);
        }

        while(q.size()!=2){
            int player1 = q.poll();
            int player2 = q.poll();
            q.offer(Math.max(player1, player2));
        }

        int player1 = q.poll();
        int player2 = q.poll();
        if (player1>player2){
            System.out.println(map.get(player2));
        } else {
            System.out.println(map.get(player1));
        }
    }
}
