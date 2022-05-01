package com.boqi.atcoders.abc.abc197;

import java.util.Scanner;

public class B {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int h = sc.nextInt();
        int w = sc.nextInt();
        int x = sc.nextInt() - 1;
        int y = sc.nextInt() - 1;

        char[][] grid = new char[h][w];

        for (int i = 0; i < h; i++) {
            String cur = sc.next();
            char[] curC = cur.toCharArray();
            grid[i] = curC;
        }

        int res = 1;


        for (int i = x - 1; i >= 0; i--) {
            if (grid[i][y] == '.') {
                res++;
            } else {
                break;
            }
        }

        for (int i = x + 1; i < h; i++) {
            if (grid[i][y] == '.') {
                res++;
            } else {
                break;
            }
        }

        for (int j = y - 1; j >=0; j--) {
            if (grid[x][j] == '.') {
                res ++;
            } else {
                break;
            }
        }

        for (int j = y + 1; j < w; j++) {
            if (grid[x][j] == '.') {
                res ++;
            } else {
                break;
            }
        }

        System.out.println(res);
    }
}
