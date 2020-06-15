package com.boqi.atcoders.abc.abc165;

import java.util.Scanner;

public class B {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        long x = sc.nextLong();
        int ans = 0;
        double r = 0.01;
        double n = 1;
        long sum = 0;
        for(int i = 0; i < 5000; i++){
            sum = (long) (100 * Math.pow(1.01, i));
            if(sum >= x){
                ans = i;
                break;
            }
        }

        System.out.println(ans);
    }
}
