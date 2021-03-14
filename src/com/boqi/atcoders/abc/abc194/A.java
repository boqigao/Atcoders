package com.boqi.atcoders.abc.abc194;

import java.util.Scanner;

public class A {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int c = sc.nextInt();
        int b = sc.nextInt();
        int a = c + b;

        if (a >= 15 && b >=8) {
            System.out.println(1);
        } else if (a>=10 && b >=3) {
            System.out.println(2);
        } else if (a >=3) {
            System.out.println(3);
        } else {
            System.out.println(4);
        }
    }
}
