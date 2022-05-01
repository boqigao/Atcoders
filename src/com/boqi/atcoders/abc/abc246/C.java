package com.boqi.atcoders.abc.abc246;

import java.util.Scanner;

// dp[i][sum] := 数列のi番目まで確定していて、これまでの総和がsumである組み合わせ

/**
 * https://atcoder.jp/contests/abc248/tasks/abc248_c
 * dp能用的原因，是因为在同一行中比如定了前2项，那么对于同一个sum而言，后面是和前面无关的
 * 例子: n = 5, m = 4, k = 20
 * 那么 12 XXX
 * 和 21XXX
 * 的后面都是不受影响的 （这种情况叫dp[2][3] , 2是第二项，3是前2项的sum
 * <p>
 * 这个题为什么这么难理解呢？
 * 因为以前做的dp题，都是定了某个格子以后，就不会再变化了，但是这个题会变化
 * 比如dp[1][1] 会转移到 dp[2][3] 定了2个，sum是3
 * 但是dp[1][2] 也会转移到 dp[2][3] 定了两个， sum是3
 * <p>
 * dp[i + 1][j + nxt] += dp[i][j];
 * 但是这个地方为什么会这么难理解呢，因为比如dp[1][2]转移到 dp[2][3]的时候，从定了定1数字，和为2，到定2数字合为3，我们只能增加一种，也就是[2,1]
 *
 * 再来，我们认为dp[2][3]现在是2，因为有[1,2][2,1]两种，我们再转移到dp[3][4]的时候，我们就只能增加那么一个数字也就是1
 * 【1,2，1][2,1,1]
 * 所以，从dp[2][3]转移到dp[3][4]的时候，我们只能增加一个数字，所以对于dp[3][4]而言，dp[2][3]只贡献了自己的数字
 *
 * https://youtu.be/1F0Qc-M6xv8?t=3250
 * 表格在这里
 */
public class C {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        int[][] dp = new int[51][3010];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                for (int nxt = 1; nxt <= m; k++) {
                    if (j + nxt <= k) {
                        dp[i + 1][j + nxt] += dp[i][j];
                    }
                }
            }
        }

    }
}
