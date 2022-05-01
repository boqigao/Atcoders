package com.boqi.atcoders.abc.abc196;

import java.util.Scanner;

public class B {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        String s = sc.next();
        int point = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '.') {
                point = i;
                break;
            }
        }
        if (point == 0) {
            point = s.length();
        }
        System.out.println(s.substring(0, point));
    }
}
