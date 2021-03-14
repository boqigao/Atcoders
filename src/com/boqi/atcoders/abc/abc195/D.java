package com.boqi.atcoders.abc.abc195;

import java.util.*;

/**
 * 贪心算法
 * 从小箱子开始看，
 * 对于每个箱子来说，放进去能融进他最大价值的宝物
 */
public class D {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();
        int[] xm = new int[m];

        //PriorityQueue<Item> pq = new PriorityQueue<>(
        //        new ItemComparator()
        //);

        int[] w = new int[n];
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            xm[i] = sc.nextInt();
        }

        int[] l = new int[q], r = new int[q];

        for (int i = 0; i < q; i++) {
            l[i] = sc.nextInt() - 1;
            r[i] = sc.nextInt() - 1;
        }

        // 处理query
        for (int i = 0; i < q; i++) {
            ArrayList<Integer> box = new ArrayList<>();
            // 如果箱子可用， 就把箱子按照放入，然后按照从小到大排序
            for (int j = 0; j < m; j++) {
                if (j < l[i] || j > r[i]) {
                    box.add(xm[j]);
                }
            }
            Collections.sort(box);

            boolean[] visited = new boolean[n];
            // 从大到小输出的pq
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            long sumV = 0;

            for (int j = 0; j < box.size(); j++) {
                for (int k = 0; k < n; k++) {
                    // 对于每一个箱子来说：
                    // 如果还没有访问过k物品，并且k物品的重量小于j箱子的重量
                    if (!visited[k] && w[k] <= box.get(j)) {
                        // 访问该物品，并且把该物品的价值放入pq
                        visited[k] = true;
                        pq.add(v[k]);
                    }
                }
                // 这里不是while 这里是if，所以只取了一个出来
                if (!pq.isEmpty()) sumV += pq.remove();
            }
            System.out.println(sumV);
        }
    }

    static class Item {
        int weight;
        int value;

        public Item(int weight, int value) {
            this.value = value;
            this.weight = weight;
        }
    }

    /**
     * 如果重量相同就按照value逆排序
     */
    static class ItemComparator implements Comparator<Item> {

        @Override
        public int compare(Item o1, Item o2) {
            if (o1.weight == o2.weight) {
                return o2.value-o1.value;
            }
            return o1.weight - o2.weight;
        }
    }
}
