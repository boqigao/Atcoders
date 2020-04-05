package com.boqi.atcoders.abc.abc160;

import com.sun.corba.se.impl.orbutil.graph.Graph;
import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

/**
 * 这道题使用bfs来做
 * 使用队列来计算比较方便
 * 另外一定要注意一个东西就是，图要用arraylist来存储！！
 */
public class D {
    static List<Integer> [] Edge;
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();

        //创建一个邻接表
        //隣接リストの作成
        NextList[] arr = new NextList[n];
        for (int i = 0; i < n; i++) {
            NextList nextList = new NextList();
            if (i == 0) {
                nextList.neighbours.add(i + 1);
            } else if (i == n - 1) {
                nextList.neighbours.add(i - 1);
            } else {
                nextList.neighbours.add(i + 1);
                nextList.neighbours.add(i - 1);
            }
            arr[i] = nextList;
        }

        arr[x - 1].neighbours.add(x - 1);
        arr[y - 1].neighbours.add(y - 1);

        int[] ans = new int[n];
        Bfs bfs = new Bfs(n);
        int[] each;
        for(int i = 0; i < n; i++){
            each = bfs.bfsGraph(i, arr, n);
            //这个bfs返回的是一个distance数组
            //遍历
            for(int j = 0; j < each.length; j++){
                //ans[distance[j]]++是什么意思
                //distance[]是i节点到各个邻接节点的最短距离
                //ans[]就是把最短距离都加起来
                //比如最短距离3的话, ans[3]就++

                ans[each[j]]++;
            }
        }

        for(int i = 1; i < n; i++){
            //最后因为会重复计算，所以要除以2
            System.out.println(ans[i]/2);
        }


    }
}

class Bfs{
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    //是否访问过
    boolean[] visited;
    //distance[i]就是start节点到第i个节点的最短距离
    int[] distance;

    /**
     * @param N 顶点数
     */
    public Bfs(int N){
        visited = new boolean[N];
        distance = new int[N];
    }

    /**
     *
     * @param start 从哪个顶点开始
     * @param nl 就是这张图（用邻接表表示）
     * @param N 顶点总数
     * @return
     */
    public int[] bfsGraph(int start, NextList[] nl, int N){

        //把起点放入图中
        pq.offer(start);

        //所有的点都置为未访问
        Arrays.fill(visited, false);

        //起点已经放入队列，因此是已访问
        visited[start] = true;

        //把所有的距离都置为最大值
        Arrays.fill(distance, Integer.MAX_VALUE);

        //起点自己和自己的距离肯定是零
        distance[start] = 0;

        while (pq.size()>0){//当队列中有东西的时候
            //取出队列中的节点
            int loc = pq.poll();
            //遍历邻接表中的邻居
            for(int i : nl[loc].neighbours){
                if(!visited[i]) { //如果还没有访问过这个邻居
                    pq.offer(i); //把此邻居入队
                    visited[i] = true; //此邻居已经访问

                    //这两个邻居是相连的，如果未访问过的话，距离初始节点的距离一定是+1
                    distance[i] = distance[loc] + 1;
                }else {
                    //如果访问过了，但是结果不对
                    //比如已经访问过3节点，4结点在访问时发现距离远了
                    if(distance[i] > distance[loc] + 1){
                        pq.offer(i);
                        distance[i] = distance[loc] + 1;
                    }
                }

            }
        }
        return  distance;
    }
}

/**
 * 一个nextlist就是一个arraylist
 */
class NextList {
    ArrayList<Integer> neighbours = new ArrayList<>();
}
