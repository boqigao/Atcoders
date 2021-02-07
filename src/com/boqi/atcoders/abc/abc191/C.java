package com.boqi.atcoders.abc.abc191;

import java.util.Scanner;

/**
 * 这道题用一个2*2的格子来扫描整图
 * 由于这道题不会有黑格子被白格子全包围的情况（相反亦如是）
 * 所以扫描到的情况只有以下四种
 *
 * 1. 一个黑色，这说明存在着一个角
 * 黑白
 * 白白
 *
 * 2. 两个黑色，这说明不存在角
 * 黑黑
 * 白白
 *
 * 注意，不存在
 * 黑白
 * 白黑
 * 这种情况
 *
 * 3. 三个黑色，这说明存在一个角
 * 黑白
 * 黑黑
 *
 * 4. 四个黑色，这说明不存在角
 * 黑黑
 * 黑黑
 *
 * 所以，只要扫描到1或者3，答案+1就好了
 */
public class C {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        int h = sc.nextInt();
        int w = sc.nextInt();

        char[][] grid = new char[h][w];
        for(int i = 0; i < h; i++){
            String tmp = sc.next();
            char[] arr = tmp.toCharArray();
            grid[i] = arr;
        }

        int ans = 0;
        for (int i = 0; i < h - 1; i++) {
            for (int j = 0; j < w - 1; j++) {
                int cnt = 0;
                for(int di = 0; di < 2; di++){
                    for(int dj = 0; dj < 2; dj++) {
                        if(grid[i+di][j+dj] == '#') {
                            cnt++;
                        }
                    }
                }
                if(cnt==1 || cnt ==3) {
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }
}
