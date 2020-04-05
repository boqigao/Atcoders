package com.boqi.atcoders.abc.abc160;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int k = sc.nextInt();

        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i<n; i++){
            a[i] = sc.nextInt();
        }

        int maxDistance = 0;
        maxDistance = Math.max(maxDistance, a[1] - a[0]);
        for(int i = 1; i<n; i++){
            maxDistance = Math.max(maxDistance, a[i] - a[i-1]);
        }

        maxDistance = Math.max(maxDistance, k-a[n-1]+a[0]);

        int ans = 0;
        ans = k-maxDistance;
        System.out.println(ans);

    }
}
