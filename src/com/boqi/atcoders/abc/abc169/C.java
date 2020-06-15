package com.boqi.atcoders.abc.abc169;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class C {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String a = sc.next();
        String b = sc.next();

        BigDecimal aBig = new BigDecimal(a);
        BigDecimal bBig = new BigDecimal(b);

        BigDecimal floor = aBig.multiply(bBig).setScale(0, RoundingMode.FLOOR);
        System.out.println(floor.toString());
    }
}
