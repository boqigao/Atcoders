package com.boqi.atcoders.abc.abc154;

import java.util.HashSet;
import java.util.Scanner;

public class CDistinctOrNot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        HashSet<Long> hs = new HashSet<>();
        long a = 0;
        boolean containFlag = false;
        for(int i = 0; i < n; i++){
            a = sc.nextLong();
            if(hs.contains(a)){
                containFlag = true;
            }
            hs.add(a);
        }
        if (!containFlag){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
