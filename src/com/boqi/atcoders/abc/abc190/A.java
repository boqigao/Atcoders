package com.boqi.atcoders.abc.abc190;

import java.util.Scanner;

public class A {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        String res = "";
        if (c == 0) {
            if (a > b) {
                res = "Takahashi";
            } else {
                res= "Aoki";
            }
        } else {
            if(b > a) {
                res = "Aoki";
            } else {
                res = "Takahashi";
            }
        }
        System.out.println(res);
    }
}
