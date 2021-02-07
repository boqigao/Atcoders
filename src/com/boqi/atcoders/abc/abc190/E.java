package com.boqi.atcoders.abc.abc190;

import java.util.*;

/**
 * 这道题分两步走，第一，求出所有重要节点到其他重要节点的最短距离
 * 这里使用bfs
 *
 * 第二，使用dp计算出长度
 */
public class E {
    long[][] dp;
    long inf = (long)1e15;
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<List<Integer>> G = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            G.add(new ArrayList<>());
        }

        Set<Integer> set = new HashSet<>();

        // 作图
        for(int i = 0; i < m; i++) {
            int a = sc.nextInt()-1;
            int b = sc.nextInt()-1;
            set.add(a);
            set.add(b);
            G.get(a).add(b);
            G.get(b).add(a);
        }

        int k = sc.nextInt();
        int[] c = new int[k];

        for(int i = 0; i < k; i++) {
            c[i] = sc.nextInt()-1;
        }

        long[][] d = new long[k][k];

        // 对于每一个重要节点做bfs
        // 目标是取出这个重要节点到其他重要节点的最小距离
        for(int i = 0; i < k; i++) {
            Queue<Integer> q = new LinkedList<>();
            // 先把当前顶点加入队列
            q.add(c[i]);

            long[] dist = new long[n];

            // ** 初始化以后都是false
            boolean[] visited = new boolean[n];

            visited[c[i]]=true;
            Arrays.fill(dist,Long.MAX_VALUE);

            dist[c[i]] = 0;

            while (!q.isEmpty()) {
                // 对于第一层来说v就是上面的c[i]；
                int v = q.poll();
                // 对顶点V的每一个相连顶点
                for (int to : G.get(v)) {
                    // 如果还没有访问过这个顶点的一些子儿子
                    // 这里特别像二叉树的层次遍历，只不过多了一个visited
                    // 因为二叉树不可能根直接和孙子相连
                    // 但是在图里有可能
                    if (!visited[to]) {
                        // 计算距离
                        dist[to] = Math.min(dist[v] + 1,
                                dist[to]);
                        // 将其入队
                        q.add(to);
                        visited[to] = true;
                    }
                }
            }

            // 当都计算完以后，利用d[i][j]来保存i重要节点
            // 到j重要节点的距离！
            for (int j = 0; j < k; j++) {
                d[i][j] = dist[c[j]];
            }
        }


        // 计算得到d[i][j]之后，开始使用dp
        // 这里dp的意思是：dp[已经访问过的顶点集合][现在所在的顶点]
        // [1<<k]的理由是，比如说第0行就是0000000，都没访问过
        // 最后一行就是 1111111, 全部访问完成

        long[][] dp = new long[1<<k][k];
        long ans = Long.MAX_VALUE;

        for(int i = 0; i< 1<<k; i++ ){
            Arrays.fill(dp[i], Long.MAX_VALUE);
        }

        for(int i = 0 ; i < k ; i++) {
            dp[1<<i][i] = 1;
        }

        for(int S = 0 ; S < 1 << k ; S++) {
            for(int u = 0 ; u < k ; u++) {
                if((S&(1<<u)) == 0) continue;
                for(int v = 0 ; v < k ; v++) {
                    if(!(((S&(1<<v))&1) == 1)) {
                        dp[S|1<<v][v] = Math.min(dp[S|(1<<v)][v], dp[S][u] + d[u][v]);
                    }
                }
            }
        }

        for(int i = 0 ; i < k ; i++) {
            ans = Math.min(ans,dp[(1<<k)-1][i]);
        }
        if(ans == Long.MAX_VALUE) {
            System.out.println(-1);
        }
        else {
            System.out.println(ans);
        }


    }
}
