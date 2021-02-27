package com.boqi.atcoders.abc.abc191;

import java.util.*;

/**
 * 这道题其实就是一个基本的dijkstra
 */
public class E {

    static Scanner sc = new Scanner(System.in);
    static List<List<Edge>> graph;

    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            // 给每个顶点加邻接矩阵
            graph.add(new ArrayList<>());
        }

        // 把每条边填入这个节点的邻接矩阵
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Edge(b, c));
        }

        int[] res = new int[n + 1];
        for (int i = 1; i <= n; i++){
            res[i] = dijkstra(i, n);
        }

        for(int i = 1; i <= n; i++) {
            System.out.println(res[i]);
        }
    }


    /**
     * https://www.youtube.com/watch?v=pVfj6mxhdMw
     * @param i 当前节点的值
     * @param n 总节点数
     * @return
     */
    private static int dijkstra (int i, int n) {
        // dist保存从i节点出发到任意节点的最短距离
        int[] dist = new int[n+1];

        // 最开始的初始化，所有的节点都是无线距离
        Arrays.fill(dist, Integer.MAX_VALUE);

        // pq保存的是到下一个节点的cost，还有最小值
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(o->o.cost));

        // 从自己出发到自己作为0？
        pq.offer(new Edge(i, 0));
        int flag = 0;
        while (!pq.isEmpty()) {
            // 当前节点是距离A最近的节点
            Edge curEdge = pq.poll();
            for (Edge nextEdge: graph.get(curEdge.dest)) {
                // 如果从 i节点 到当前节点已有的cost
                // + 当前节点到下一个节点的cost
                // 比已经记录的距离小，那么就更新距离
                // 如果不存在这个值，说明当前节点的所有子节点已经无法通过当前节点来改善
                // 因此当前节点出队以后，就结束。
                if (curEdge.cost + nextEdge.cost < dist[nextEdge.dest]) {
                    dist[nextEdge.dest] = curEdge.cost + nextEdge.cost;

                    // 如果下个节点为i，也就是说，如果能产生一个从i节点出发的环
                    if (nextEdge.dest == i) {
                        flag = 1;
                    }
                    // 节点更新，这样可以找nextEdge的下一个edge
                    // 同时dist[]数组已经更新过了，那就把新的Edge也放进去
                    // 这个新的Edge中存的是从i节点到达dest节点的最小距离。。
                    // 其实对于Edge这个类是有一种复用的感觉
                    // 他这里的newEdge其实就是一个Vertex
                    // 和shortestDistancefromA的组合
                    // 因为这道题他不需要你记录PreviousVertex
                    pq.offer(new Edge(nextEdge.dest, dist[nextEdge.dest]));
                }
            }
        }

        // 如果flag等于0，说明没找到一个环
        if(flag == 0) {
            return -1;
        }

        // dist[i] 其实就是存的从i到i的最小距离。。这里非常巧妙
        return dist[i];


    }


    static class Edge {
        int dest;
        int cost;

        Edge(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }

        public String toString() {
            return this.dest + " " + this.cost;
        }
    }
}
