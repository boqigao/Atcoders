package com.boqi.atcoders.abc.abc196;

import java.util.Scanner;

/**
 * 我他妈太蠢了
 * 分前后两段run就好了，10的12次方不敏感！
 */
public class C {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        long n = sc.nextLong();
        long ans = 0;
        for (long i = 1; ; i++) {
            String s1 = i+"";
            if (Long.parseLong(s1 + s1) > n) {
                ans = i - 1;
                break;
            }
        }
        System.out.println(ans);
    }
}
