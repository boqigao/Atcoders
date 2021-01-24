package com.boqi.atcoders.abc.abc168;

import java.util.Scanner;

public class C {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        double a = sc.nextInt();
        double b = sc.nextInt();
        double h = sc.nextDouble();
        double m = sc.nextDouble();

        double dig1 = ((h + m / 60) / 12.0) * 2 * Math.PI;
        double dig2 = m / 60.0 * 2 * Math.PI;
        double cos = Math.cos(Math.abs(dig1 - dig2));


        System.out.println(
                Math.sqrt(a * a + b * b - 2 * a * b * cos)
        );

    }
}
