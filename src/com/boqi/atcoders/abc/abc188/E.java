package com.boqi.atcoders.abc.abc188;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// 这道题是一个DAG图: directed acyclic graph。 有向无环图

/**
 * 这道题用dp去做，
 * dp[v]的定义是：不论在哪里买了，走了至少一条路，现在在v时候，支出的最小值
 * 所以结果就是 arr[i]（当前节点卖出的值)-dp[i](到达当前节点时候支出的最小值);
 * 所以我们要求的就是：a[v] - dp[v]的最大值。
 */
public class E {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        // 节点数
        int n = sc.nextInt();
        // 路径数
        int m = sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)arr[i]=sc.nextInt();
        List<Integer>[] adj = new ArrayList[n];

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt()-1, y = sc.nextInt()-1;
            if (adj[x] == null) {
                adj[x] = new ArrayList<>();
            }
            // x节点，有向y节点的路线
            adj[x].add(y);
        }

        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);

        int res = Integer.MIN_VALUE;

        // 遍历所有节点
        for (int i = 0; i < n; i++){
            // 更新结果，取前面节点的最大值和现节点的最大值
            res = Math.max(res, arr[i]-dp[i]);
            if (adj[i]==null) continue;
            for(Integer j : adj[i]) {
                // 实际上这里是 dp[j] = min(dp[j], dp[i], arr[i])
                // 这里的意思是
                // 从 i 城市到了j城市以后
                // 要么i城市的金价最低，要么，（曾经更新过的）j城市金价最低
                // 要么j城市本身的金价最低
                // 这样就可以理解了

                dp[j] = Math.min(dp[j],dp[i]);
                dp[j] = Math.min(dp[j], arr[i]);
            }

        }
        System.out.println(res);
    }
}
