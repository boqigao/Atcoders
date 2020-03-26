package com.boqi.atcoders.abc.abc159;

import java.util.Scanner;


public class ATheNumberOfEvenPairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //偶数球
        int m = sc.nextInt(); //奇数球
        System.out.println(choose(n, 2) + choose(m, 2));

    }

    static int choose (int n, int k){
        int ret = 1;
        if(n == k) {
            return 1;
        }else {
            for(int i = 0; i < k; i++){
                ret = ret * (n-i) / (i + 1);
            }
        return ret;}
    }
}
