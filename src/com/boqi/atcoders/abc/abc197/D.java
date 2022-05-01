package com.boqi.atcoders.abc.abc197;

import java.util.Scanner;

public class D {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();
        double x0 = sc.nextDouble();
        double y0 = sc.nextDouble();
        double x2n = sc.nextDouble();
        double y2n = sc.nextDouble();

        double d = Math.sqrt( (y2n- y0) * (y2n- y0) + (x2n- x0) * (x2n- x0));
        double r = d/2;

        double[] movement = new double[2];

        movement[0] = x0;
        movement[1] = y0 + d/2;

        double sin = (x2n - x0) / d;
        double cos = (y0 - y2n) / d;

        double oriX = r * Math.cos(Math.PI + 2 * Math.PI / n);
        double oriY = r * Math.sin(Math.PI/2 + 2 * Math.PI / n);

        double tmpx = oriX;
        double newx = tmpx * cos - oriY * sin + x0 - r;
        double newy = tmpx * sin + oriY * cos + y0;

        System.out.println(newx);
        System.out.println(newy);
    }
}

class Point {
    double x;
    double y;

    Point (double x, double  y) {
        this.x = x;
        this.y = y;
    }
}
