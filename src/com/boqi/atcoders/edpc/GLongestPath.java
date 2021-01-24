package com.boqi.atcoders.edpc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 有向图的最长子路径
 * （此有向图不包含闭路）
 */
public class GLongestPath {
    static Scanner sc = new Scanner(System.in);

    static ArrayList<Integer>[] adj; //这是一个Arraylist的数组
    static int[] memo;

    /**
     * adj中存储了全部的邻接节点比如
     * 1 有2,3两个后继节点， 2 有3,4 两个后继节点
     * 那么这个adj的形状就是这样
     * 1 [2, 3]
     * 2 [3, 4]
     *
     * @param u 顶点的编号
     * @return 顶点【u】的最长子序列
     */
    public static int dp(int u) {
        int ans = 0;
        if (memo[u] != -1) return memo[u];
        for (int v : adj[u]) {
            //对于adj中的每一个节点，他去找后一个节点的最长路径
            //比如 adj[1] 中储存的是1号节点的所有后继节点
            // 则他遍历所有后继节点，找到最长路径，存入memo[1]中
            ans = Math.max(ans, 1 + dp(v));
        }
        return memo[u] = ans;
    }

    public static void main(String[] args) throws Exception {
        int n = sc.nextInt();
        int m = sc.nextInt();
        //邻接矩阵的顶点集合
        adj = new ArrayList[n];

        //
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            adj[a].add(b);//在a号arraylist中添加了b数字
        }

        //从顶点i出发的最长路径
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == -1) {
                ans = Math.max(ans, dp(i));
            }
        }

        System.out.println(ans);
    }

}
