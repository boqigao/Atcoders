package com.boqi.atcoders.abc.abc248;

import java.util.*;

/**
 * 这道题先做一个index 然后用二分
 */
public class D {
    static Scanner sc = new Scanner(System.in);

    public static int lowerBound(List<Integer> A, int X) {
        int low = 0, high = A.size();
        while (low < high) {
            int mid = (high + low) / 2;
            if (A.get(mid) < X) low = mid + 1;
            else high = mid;
        }
        return low;
    }

    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Map<Integer, List<Integer>> index = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!index.containsKey(a[i])) {
                List<Integer> arr = new ArrayList<>();
                arr.add(i);
                index.put(a[i], arr);
            } else {
                index.get(a[i]).add(i);
            }
        }

        int q = sc.nextInt();
        int[] answer = new int[q];
        for (int i = 0; i < q; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            int x = sc.nextInt();
            answer[i] = lowerBound(index.get(x), r) - lowerBound(index.get(x), l);
        }
        for(int ans : answer) {
            System.out.println(ans);
        }
    }

}
