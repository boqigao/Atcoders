package com.boqi.atcoders.abc.abc198;

import java.util.Scanner;

public class C {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        double r = sc.nextDouble();
        double x = sc.nextDouble();
        double y = sc.nextDouble();

        double dist = Math.sqrt(x * x + y * y);

        if (dist == r) {
            System.out.println(1);
        }
        else if (dist <= r+r) {
            System.out.println(2);
        } else {
            System.out.println((int)Math.ceil(dist/r));
        }
    }
}
