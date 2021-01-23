package com.boqi.atcoders.abc.abc189;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class C {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception{
        int n = sc.nextInt();
        int[] a = new int[n];

        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        
        int res = 0;

        // 固定左端，for循环右边，
        // ????这就是个很单纯的全循环，我咋没做出来呢
        for(int l=0;l<n;l++){
            int x=a[l];
            for(int r=l;r<n;r++){
                x=Math.min(x,a[r]);
                res=Math.min(res,x*(r-l+1));
            }
        }
        


        System.out.println(res);
    }
}
