package com.boqi.atcoders.abc.abc163;

import java.util.Scanner;

public class C {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] a = new int[n-1];
        for(int i = 0; i < n-1; i++){
            a[i] = sc.nextInt();
        }

        int[] res = new int[n];
        for(int i = 0; i < n-1; i++){
            res[a[i]-1]++;
        }

        for(int i = 0; i < n; i++){
            System.out.println(res[i]);
        }
    }
}
