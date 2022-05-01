package com.boqi.atcoders.abc.abc243;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 这道题最核心的地方在于，在同一个坐标下，找到最右边的向左走的人，和找到最左边向右走的人
 */
public class C {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];

        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        String s = sc.next();

        Map<Integer, Integer> mapRight = new HashMap<>();
        Map<Integer, Integer> mapLeft = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'R') {
                // 如果这个点往右走 就要找到最左边的向右走的人 min (x, minVal);
                mapRight.put(y[i], Math.min(mapRight.getOrDefault(y[i], Integer.MAX_VALUE), x[i]));
            } else {
                // 如果这个点往左走，就要找到最右边的往左走的人 max (x, maxVal)
                mapLeft.put(y[i], Math.max(mapLeft.getOrDefault(y[i], 0), x[i]));
            }
        }

        // 现在地图里存的都是最右边的向左走的人和最左边的向右走的人


        for (int i = 0; i < n; i++) {
            if (mapRight.containsKey(y[i]) && mapLeft.containsKey(y[i])) {
                if (mapRight.get(y[i]) < mapLeft.get(y[i])) {
                    System.out.println("Yes");
                    return;
                }
            }
        }
        System.out.println("No");

    }
}
