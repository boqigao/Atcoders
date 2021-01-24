package com.boqi.atcoders.agc.agc043;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 反色
 */
public class ARangeFlipFindRoute {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        int[][] maze = new int[h][w];
        String temp = "";
        ArrayList<String> mazeS = new ArrayList<>();


        for (int i = 0; i < h; i++) {
            mazeS.add(sc.next());
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < h; j++) {
                if (mazeS.get(i).charAt(j) == '#') {
                    maze[i][j] = 1;
                } else {
                    maze[i][j] = 0;
                }
            }
        }

        if (setWay(maze, 0, 0, h, w)) {
            System.out.println(0);
        }
    }

    public static boolean setWay(int[][] map, int i, int j, int h, int w) {
        if (map[h - 1][w - 1] == 2) { //说明通路已经找到了

            return true;
        } else {
            if (map[i][j] == 0) {//如果当前这个点等于0
                //按照策略玩一把！下->右->上->左
                map[i][j] = 2; //假定该点是可以走通的
                if (setWay(map, i + 1, j, h, w)) { //向下走能走通

                    return true;
                } else if (setWay(map, i, j + 1, h, w)) {

                    return true;
                } else {
                    /*
                    上下左右都走不通的时候，说明这个点就走不通
                    然后回溯回到上面一个栈，将其置为false，然后上面一个栈如果所有的走走完了
                    那再回到上上一个栈也只为false，因此结果会倒着从最后走不通的路开始
                    一路else的false回溯上去。
                     */

                    map[i][j] = 3;
                    return false;
                }
            } else { //如果当前探测的这个点不等于0，可能是1：墙,2：走过了,
                //3. 已经走过了，但是不能走
                return false;
            }
        }
    }
}
