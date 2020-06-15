package com.boqi.atcoders.companies.nomura20200530;

import java.util.Scanner;

public class A {
    static Scanner sc =new Scanner(System.in);
    public static void main(String[] args) {
        int h1 = sc.nextInt();
        int m1 = sc.nextInt();
        int h2 = sc.nextInt();
        int m2 = sc.nextInt();
        int k = sc.nextInt();

        int startTime = h1 * 60  + m1;
        int endTime = h2 * 60 + m2;

        int wakeUp = endTime - startTime;

        int sleepTime = wakeUp - k;

        System.out.println(sleepTime);

    }
}
