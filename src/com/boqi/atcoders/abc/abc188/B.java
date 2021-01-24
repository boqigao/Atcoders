package com.boqi.atcoders.abc.abc188;

import java.util.Scanner;

public class B {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];

        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for(int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }

        long sum = 0;
        for(int i = 0; i < n; i++) {
            sum += a[i] * b[i];
        }
        
        System.out.println(sum==0?"Yes":"No");
    }
}
