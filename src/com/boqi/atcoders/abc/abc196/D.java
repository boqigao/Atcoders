package com.boqi.atcoders.abc.abc196;

import java.util.Scanner;

public class D {
    static int h, w;
    static boolean[][] used = new boolean[16][16];
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        h = sc.nextInt();
        w = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(dfs(0, 0, a, b));
    }

    /**
     * 其实是个回溯问题
     * @param i
     * @param j
     * @param a
     * @param b
     * @return
     */
    static long dfs (int i, int j, int a, int b) {
        if (a <0 || b <0) {
            return 0;
        }
        if (j == w) {
            j = 0;
            i++;
        }
        if (i == h) {
            return 1;
        }
        if (used[i][j]) {
            return dfs(i, j+1, a, b);
        }

        long res = 0;
        used[i][j] = true;
        res += dfs(i, j+1, a, b-1);

        if (j + 1 < w && !used[i][j + 1]) {
            used[i][j+1] = true;
            res += dfs(i, j + 1, a - 1, b);
            used[i][j + 1] = false;
        }

        if (i + 1< h && !used[i+1][j]) {
            used[i+1][j] = true;
            res += dfs(i, j+1, a-1, b);
            used[i+1][j] = false;
        }
        used[i][j] = false;
        return res;
    }
}
