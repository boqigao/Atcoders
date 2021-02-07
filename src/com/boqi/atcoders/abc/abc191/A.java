package com.boqi.atcoders.abc.abc191;

import java.util.*;

public class A {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();
        long x = sc.nextLong();

        List<Long> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            long next = sc.nextLong();
            if(x == next) {
                continue;
            }
            list.add(next);
        }

        if (list.size()==0){
            System.out.println("");
        }

        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}
