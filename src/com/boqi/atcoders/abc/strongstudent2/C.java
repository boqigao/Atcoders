package com.boqi.atcoders.abc.strongstudent2;

import java.util.Scanner;

public class C {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int a = sc.nextInt();
        int b = sc.nextInt();

        int start = b - a;
        int res = 0;
        for (int i = start;i >=1; i--) {
            int bTimes = b / i;
            if ( i * (bTimes-1) >= a) {
                System.out.println(i);
                return;
            }
        }
    }
}
