package com.boqi.atcoders.abc.abc191;

import java.util.Scanner;

public class B {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int v = sc.nextInt();
        int t = sc.nextInt();
        int s = sc.nextInt();
        int d = sc.nextInt();

        int safe1 = v * t;
        int safe2 = v * s;
        if(d>=safe1 && d<=safe2) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }
    }
}
