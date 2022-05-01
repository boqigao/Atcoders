package com.boqi.atcoders.abc.abc190;

import java.util.Scanner;

/**
 * 这道题其实是个bit全探索
 * <p>
 * 举例： 有5人要放盘子
 * 全探索的话， 用0表示给C投票，用1表示给D投票
 * 那么结果就是某个5位的数列
 * 比如 01010就代表下面这种选择
 * <p>
 * C   D
 * 0    0
 * 1        1
 * 2    0
 * 3        1
 * 4    0
 * <p>
 * 那么最后计算结果的时候就用来计算，s的第i位是什么
 * (s>>i) & 1
 */
public class C {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[m];
        int[] b = new int[m];
        // ab是条件
        for (int i = 0; i < m; i++) {
            a[i] = sc.nextInt() - 1;
            b[i] = sc.nextInt() - 1;
        }

        int k = sc.nextInt();
        int[] c = new int[k];
        int[] d = new int[k];

        // cd是放那个盘子
        for (int i = 0; i < k; i++) {
            c[i] = sc.nextInt();
            d[i] = sc.nextInt();
        }

        // 一共有多少种可能性
        int k2 = 1 << k;
        int ans = 0;

        for (int s = 0; s < k2; s++) {
            int[] dish = new int[n + 1];
            // 这个for循环便利每个人到底怎么放他手中的盘子

            // 这里如果把s想象成一个s = s.tobit[]
            //就好理解多了
            for (int i = 0; i < k; i++) {
                // 现在管的是第几位
                int tmp = (s >> i) & 1;
                // 这里就变成了if(s[i]==0) or if (s[i]==1)
                if (tmp == 1)
                    dish[d[i]]++;
                else
                    dish[c[i]]++;
            }
            int now = 0;
            // 艹，看题不仔细，只要有球就行了！！！
            for (int i = 0; i < m; i++) {
                if (dish[a[i]] == 0)
                    continue;
                if (dish[b[i]] == 0)
                    continue;
                now++;
            }
            ans = Math.max(ans, now);
        }
        System.out.println(ans);
    }

    public static int[] copy(int[] array) {
        int n = array.length, l = 0, r = n - 1;
        int newarray[] = new int[n];
        while (l <= r) {
            newarray[l] = array[l];
            newarray[r] = array[r];
            l++;
            r--;
        }
        return newarray;
    }
}
