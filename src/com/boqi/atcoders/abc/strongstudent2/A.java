package com.boqi.atcoders.abc.strongstudent2;

import java.util.Scanner;

public class A {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();

        int g = 0;
        for (g = 0; g < 1000000; g++) {
            if (x * g >= z * y) {
                break;
            }
        }

        System.out.println(g-1);
    }
}
