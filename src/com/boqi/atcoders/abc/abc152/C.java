package com.boqi.atcoders.abc.abc152;

import javax.swing.text.Style;
import java.util.Arrays;
import java.util.Scanner;

public class C {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] p = new int[n];
        for(int i = 0; i < n; i++){
            p[i] = sc.nextInt();
        }

        int ans = 0;

        int curMin = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            curMin = Math.min(curMin, p[i]);
            if(p[i]== curMin){
                ans++;
            }
        }
        System.out.println(ans);
    }
}
