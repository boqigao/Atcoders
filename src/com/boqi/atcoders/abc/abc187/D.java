package com.boqi.atcoders.abc.abc187;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 定义X=高桥的得票数-青木的得票数
 * 因此在i号的城市宣讲的话，
 * X会增加2Ai(本身给青木投票的跑去给高桥投票了)+Bi（高桥派本身也来投票了）
 *
 * 同时，当X大于0的时候，高桥就能赢了
 * 所以，在x》0之前，2Ai+Bi更大的顺序演讲即可
 */
public class D {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int n = sc.nextInt();
        long[] voteAfterSpeech = new long[n];
        long voteDiff = 0;

        for (int i = 0; i < n; i++) {
            long a = sc.nextLong();
            long b = sc.nextLong();

            // 因为
            //不演讲的话，a反而给青木投票，所以需要减少一个a
            voteDiff -= a;
            // 对于i城镇来说，voteAfterSpeech会增加a+a+b
            voteAfterSpeech[i] = a + a + b;
        }

        Arrays.sort(voteAfterSpeech);
        int res = 0;
        for (int i = voteAfterSpeech.length-1; i >= 0; i--){
            if(voteDiff <= 0) {
                voteDiff+=voteAfterSpeech[i];
                res++;
            } else {
                break;
            }
        }

        System.out.println(res);

    }

}
