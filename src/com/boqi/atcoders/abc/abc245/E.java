package com.boqi.atcoders.abc.abc245;

import java.util.*;

public class E {
    static Scanner sc = new Scanner(System.in);
    static Map<Integer, List<Edge>> graph;
    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] c = new int[n];
        for (int i =0 ; i < n; i++) {
            c[i] = sc.nextInt();
        }

        graph = new HashMap<>();

        // 这里如果不给所有的边都加上的话，后面会报nullPointer的错
        for (int i = 0; i < n; i++){
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = 1;
            graph.get(u-1).add(new Edge(v-1, w));
            graph.get(v-1).add(new Edge(u-1, w));
        }

        for (int i = 0; i < n; i++) {
            int[] dist = dijkstra(0, i);
        }

    }


    static private int[] dijkstra(int k, int n) {
        // new一个节点来保存n
        int[] dist = new int[n];

        // 将所有值定义为最大值
        Arrays.fill(dist,Integer.MAX_VALUE);

        // 初始节点自己到自己的距离设置为0
        dist[k] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(o->o.value));

        pq.offer(new Edge(k, 0));

        while (!pq.isEmpty()) {
            Edge curEdge = pq.poll();

            for (Edge neighbors : graph.get(curEdge.vertices)) {
                // 如果通过当前最小边到达的节点能更近
                if (neighbors.value + curEdge.value
                        < dist[neighbors.vertices]) {
                    dist[neighbors.vertices] = neighbors.value
                            +curEdge.value;
                    pq.offer(new Edge(neighbors.vertices, dist[neighbors.vertices]));
                }
            }
        }

        return dist;

    }

    static class Edge {
        int vertices;
        int value;

        public Edge(int Vertices, int value) {
            this.vertices = Vertices;
            this.value = value;
        }
    }
}
