package com.boqi.atcoders.abc.abc194;

import java.util.Scanner;

public class B {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int n = sc.nextInt();
        int[][] ab = new int[n][2];
        for (int i = 0; i < n; i++) {
            ab[i][0] = sc.nextInt();
            ab[i][1] = sc.nextInt();
        }

        int res = Integer.MAX_VALUE;
        // tmp1 2 分别记录a的最小值和index
        int tmp1 = Integer.MAX_VALUE;
        int index1 = 0;
        int index2 = 0;
        // tmp1 2 分别记录b的最小值和index
        int tmp2 =  Integer.MAX_VALUE;
        int tmp3 = Integer.MAX_VALUE;
        int tmp4  =Integer.MAX_VALUE;
        int index3=0, index4=0;

        for (int i = 0; i < n; i++) {
            res = Math.min(res, ab[i][0] + ab[i][1]);
        }

        for (int i = 0; i < n; i++) {
            if (ab[i][0] < tmp1) {
                index2 = index1;
                tmp2 =tmp1;
                index1 = i;
                tmp1 = ab[i][0];
            }
        }

        for (int i = 0; i < n; i++) {
            if (ab[i][1] < tmp3) {
                index4 = index3;
                tmp4 =tmp3;
                index3 = i;
                tmp3 = ab[i][1];
            }
        }

        if (index1 != index3){
            int tmp = Math.max(tmp1, tmp3);
            res = Math.min(res, tmp);
        } else {
            int tmp5 = Math.max(tmp1,tmp4);
            int tmp6 = Math.max(tmp2, tmp3);
            int tmp = Math.min(tmp5, tmp6);
            res = Math.min(res, tmp);
        }



        System.out.println(res);
    }
}
