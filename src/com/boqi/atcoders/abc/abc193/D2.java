package com.boqi.atcoders.abc.abc193;

import java.util.Scanner;

/**
 * 这道题本质上是一个 部分/整体的题目
 *
 * 举一个非常简单的例子，一开始有8张1-9
 * 然后高桥手上是
 * 2238#
 * 青木手上是
 * 1442#
 * 的话，首先要从他们手上减掉这些已经占有的牌
 * 也就是1张1， 3张2，1张3， 2张4,1张8
 * 然后在剩下的所有牌中，计算所有可能的拿法，然后挑出其中高桥可以赢的部分
 *
 * 用 赢的部分/所有可能的拿法
 *
 * 比如随便举例，高桥拿3，青木拿4的时候高桥能赢
 * 那就是在上述例子中高桥从盛夏的7张3中选了1张，
 * 青木从剩下的6张4中选了1张，所以赢的可能选法是 7 * 6
 *
 * 再比如，高桥拿2，青木也拿2的时候，高桥能赢
 * 那就是高桥在上述的剩下的5张2中选了1张
 * 青木在剩下的4张2中选了1张，所以赢的选法是 5* （5-1）
 *
 */
public class D2 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int k = sc.nextInt();
        String taka = sc.next();
        String aoki = sc.next();

        // 初始化牌组
        long[] cards = new long[10];

        for (int i = 1; i <= 9; i++) {
            cards[i] = k;
        }

        // 从牌组中去掉高桥和青木已经拿到的牌
        // 经过此操作，牌组中的牌就都可以选了
        for (int i = 0; i < 4; i++) {
            cards[taka.charAt(i) - '0']--;
            cards[aoki.charAt(i) - '0']--;
        }

        // 初始化赢得可能性和总可能性
        long win = 0;
        long total = 0;

        //遍历所有数字
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                long cases;
                if (i == j) {
                    cases = cards[i] * (cards[i]-1);
                } else {
                    cases = cards[i] * cards[j];
                }
                if (score(taka, i) > score(aoki, j)) {
                    win += cases;
                }
                total += cases;
            }
        }

        System.out.println((double)win/total);
    }

    static  int score(String s, int x) {
        int[] digits = new int[10];
        // 比如 s = 2238#
        // 那么digits就是
        // [0, 0, 2, 1, 0, 0, 0 ,0 ,1, 0]
        for (int i = 0; i < 4; i++) {
            digits[s.charAt(i)- '0'] ++;
        }

        digits[x]++;
        int score = 0;
        for (int i = 1; i <= 9; i++) {
            int tmp = i;
            // 对于上述digits循环，正好可以翻倍比如
            // 2 = 2*10
            // 20 = 20 *10
            // 正好翻倍2次
            for (int j = 0; j < digits[i]; j++) {
                tmp = tmp * 10;
            }

            score += tmp;
        }
        return score;
    }
}
