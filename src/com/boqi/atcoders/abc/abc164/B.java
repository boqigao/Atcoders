package com.boqi.atcoders.abc.abc164;

import java.util.Scanner;

public class B {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        while (a>0&&c>0){
            c = c-b;
            a = a-d;
        }
        if(c<=0){
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
