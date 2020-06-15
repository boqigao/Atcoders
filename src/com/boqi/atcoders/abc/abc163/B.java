package com.boqi.atcoders.abc.abc163;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n =sc.nextInt();
        int m = sc.nextInt();

        int[] a = new int[m];
        for(int i = 0; i < m; i++){
            a[i] = sc.nextInt();
        }

        int sum = Arrays.stream(a).sum();
        System.out.println(n>=sum?n-sum:"-1");
    }
}
