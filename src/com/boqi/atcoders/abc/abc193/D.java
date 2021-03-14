package com.boqi.atcoders.abc.abc193;

import java.util.*;

/**
 * 这道题要算赢了的 次数/总次数
 */
public class D {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int k = sc.nextInt();
        String taka = sc.next();
        String aoki = sc.next();

        List<List<Integer>> pair = new ArrayList<>();
        pair = large(taka, aoki);

        int win = 0;
    }

    private static List<List<Integer>> large(String taka,
                              String aoki) {
        List<List<Integer>> ret = new ArrayList<>();
        Map<Integer, Integer> takaMap = new HashMap();
        Map<Integer, Integer> aokiMap = new HashMap();

        for (int i = 1; i <= 9; i++) {
            ret.add(new ArrayList<>());
            takaMap.put(i, 0);
            aokiMap.put(i, 0);
        }
        for (int m = 0; m < 4; m++) {
            int curT = taka.charAt(m) - '0';
            takaMap.put(curT, takaMap.get(curT) + 1);
        }

        for (int n = 0; n < 4; n++) {
            int curA = aoki.charAt(n) - '0';
            aokiMap.put(curA, aokiMap.get(curA) + 1);
        }
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <=9; j++) {
                int takaN = 0;
                int aokiN = 0;
                takaMap.put(i, takaMap.get(i) + 1);
                aokiMap.put(j, aokiMap.get(j) + 1);
                for (int k = 1; k <= 9; k++ ) {
                    takaN+=k * Math.pow(10, takaMap.get(k));
                    aokiN+=k * Math.pow(10, aokiMap.get(k));
                }
                if (takaN > aokiN) {
                    ret.get(i).add(j);
                }
            }
        }
        return ret;
    }
}
