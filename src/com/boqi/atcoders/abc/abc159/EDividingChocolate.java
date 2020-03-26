package com.boqi.atcoders.abc.abc159;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

/**
 * H <= 10
 * W <= 1000
 */
public class EDividingChocolate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        int k = sc.nextInt();

        String[] s = new String[h];

        for(int i = 0; i< h; i++){
            s[i]= sc.next();
        }
        int ans = Integer.MAX_VALUE;
        //一次分割会产生2个组，一共有2^(h-1)种分割方式
        //理解：每条横线，要么分割，要么不分割，因此有上述结果
        //他最外层的div，便利的是每一种横向切割的方式
        //1<<(h-1), 1 左移 h-1位，相当于2^(h-1)次方
        //因为要暴力探索h-1位的所有可能性
        for (int div = 0; div < 1<<(h-1); div++) {
            int group = 0; //定义从上到下切的是第几组
            int[] id = new int[h]; //储存组号id
            for (int i = 0; i < h; i++) {
                //按照切割方式分配group
                id[i] = group; // 第一行是第一组~第二行是第一组~第三行是第二组~之类
                //div >>  i & 1判定第i位是否是1
                if (((div >> i) & 1) == 1) { //如果到了分割组的那条分割线
                    /**
                     * 这里非常巧妙，他没有考虑十进制的东西，而是全部用2进制在计算
                     * 首先 div < 1<<(h-1) 这个判定条件，他就确定了div最长是
                     * h-1位
                     * 譬如h=7的时候
                     * 当一个div是101011就代表四个有1的位置，切割了
                     * 太巧秒了
                     */
                    group++;//这里的意思是如果切割了，group就要变长了
                }
            }

            int[][] choco = new int[group + 1][w];//现在已经按照组计算了
            //计算每一列，每一组白色巧克力的数量
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    //id[i]就是第几组
                    choco[id[i]][j] += s[i].charAt(j) - '0';
                }
            }

            int num = group;
            int[] now = new int[group + 1];
            for (int col = 0; col < w; col++) {
                if (!add(col, now, choco, k)) {
                    num++;
                    now = new int[group + 1];

                    if (!add(col, now, choco, k)) {
                        num = Integer.MAX_VALUE;
                        break;
                    }
                }
            }
            ans = Math.min(ans, num);
        }
        System.out.println(ans);
    }
    static boolean add(Integer col, int[] now, int[][] choco, int K) {
        for (int i = 0; i < now.length; i++) now[i] += choco[i][col];
        for (int i = 0; i < now.length; i++) if (now[i] > K) return false;
        return true;
    }


}
