package com.boqi.atcoders.abc.abc192;

import javax.xml.stream.events.EntityDeclaration;
import java.util.*;

/**
 * 这道题是最短路径问题加了一个条件。。
 * 直接懵逼
 *
 * 这道题的重点是需要理解x在每个点需要等到e.k的倍数
 *
 * e.k的倍数怎么算呢
 * (distance[now] + path.k - 1) / path.k * path.k
 */
public class E {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt() - 1;
        int y = sc.nextInt() - 1;
        Map< Integer, List<Edge>> graph = new HashMap<>();

        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1, b = sc.nextInt() - 1;
            long t = sc.nextInt(), k = sc.nextInt();
            graph.get(a).add(new Edge(b, t, k));
            graph.get(b).add(new Edge(a, t, k));
        }

        long[] dist = dijkstra(graph, x, n);
        System.out.println(dist[y] == Long.MAX_VALUE?-1:dist[y]);
    }

    private static long[] dijkstra(Map< Integer, List<Edge>> graph, int x, int n) {
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        pq.add(new Edge(x, 0L, 0L));

        dist[x] = 0L;

        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            int now = e.to;
            // 如果到now点的距离已经更新过
            if(dist[now] == e.cost) {
                for (Edge edge : graph.get(now)) {
                    if (dist[edge.to] > (dist[now] + edge.k - 1) / edge.k * edge.k + edge.cost) {
                        dist[edge.to] = (dist[now] + edge.k - 1) / edge.k * edge.k + edge.cost;
                        // 这里k取0指的是从这里可以瞬间出发吧
                        pq.add(new Edge(edge.to, dist[edge.to], 0L));
                    }
                }

            }
        }
        return dist;
    }

    static class Edge implements Comparable<Edge> {
        /** 終了ノード */
        int to;
        /** 移動コスト */
        long cost;
        /** 発車時刻 */
        long k;

        Edge(int to, long cost, long k) {
            super();
            this.to = to;
            this.cost = cost;
            this.k = k;
        }

        @Override
        public int compareTo(Edge path) {
            return Long.compare(cost, path.cost);
        }
    }
}
