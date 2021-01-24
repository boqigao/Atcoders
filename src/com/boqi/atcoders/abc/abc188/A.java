package com.boqi.atcoders.abc.abc188;

import java.util.Scanner;

public class A {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int x = sc.nextInt();
        int y = sc.nextInt();

        if(x >= y+3 || y >= x+3) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }
    }
}
