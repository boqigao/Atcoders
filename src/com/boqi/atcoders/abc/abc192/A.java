package com.boqi.atcoders.abc.abc192;

import java.util.Scanner;

public class A {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int x = sc.nextInt();
        int coin = x % 100;
        System.out.println(coin==0?100:100-coin);
    }
}
