package com.boqi.atcoders.abc.abc192;

import java.util.Scanner;

public class B {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String s = sc.next();
        boolean res = true;
        for (int i = 0; i < s.length(); i++) {
            // 奇数
            if ((i+1)%2 == 1 && s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                res = false;
            }
            // 偶数
            if ((i+1)%2 == 0 && s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                res = false;
            }
        }
        System.out.println(res?"Yes":"No");
    }
}
