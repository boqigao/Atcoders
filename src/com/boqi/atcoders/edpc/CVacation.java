package com.boqi.atcoders.edpc;

import java.util.Scanner;

public class CVacation {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] a = new int[n + 1];
        a[0] = 0;
        int[] b = new int[n + 1];
        b[0] = 0;
        int[] c = new int[n + 1];
        c[0] = 0;


        for (int i = 1; i < n + 1; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
            c[i] = sc.nextInt();

        }

        int[][] dp = new int[100005][3];
        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[0][2] = 0;
        //dp的三列分别存储在第i天去a，b，c的最大值

        //さっきまでの問題と同じように
        //dp[i]=(i日目までに得られる幸福度の和の最大値)
        //としたいけど、それじゃダメなのだ。例えばa[N]=1,b[N]=1,c[N]=1000だったときには、
        // 最終日にはCを選んだ方が良さそうだけど、前の日にCを選んでたら困るのだ！
        //「2日連続で選べない」という条件は、前の日に何をしたかわかってればどうにかできるから
        //dp[i][j]=(i日目に行動jをして、i日目までに得られる幸福度の和の最大値)
        //を考えれば良さそうなのだ！
        //i日目に行動Aをするには、前日の行動はBかCじゃないとダメだから
        //dp[i][A]=max(dp[i−1][B]+a[i],dp[i−1][C]+a[i])
        //になるのだ！dp[i][B]、dp[i][C]も同様なのだ。
        //最終的な答えは、最終日の行動がどれでもいいから
        //max(dp[N][A],dp[N][B],dp[N][C])
        //なのだ！
        for (int i = 1; i < n + 1; i++) {
            //当这一天选择为去做A事情的时候，前一天只可能做了b事或者c事情
            //因此只要用a【i】加上前一天的b事情或者c事情就行
            dp[i][0] = Math.max(a[i] + dp[i - 1][1], a[i] + dp[i - 1][2]);
            dp[i][1] = Math.max(b[i] + dp[i - 1][0], b[i] + dp[i - 1][2]);
            dp[i][2] = Math.max(c[i] + dp[i - 1][0], c[i] + dp[i - 1][1]);
        }

        System.out.println(Math.max(dp[n][0], Math.max(dp[n][1], dp[n][2])));
    }

}
