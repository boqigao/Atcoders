package com.boqi.atcoders.abc.abc152;

import java.util.Scanner;

public class B {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int a = sc.nextInt();
        int b = sc.nextInt();

        int ai = a;


        StringBuilder sb = new StringBuilder();

        if (a >= b) {
            for (int i = 0; i < a; i++) {
                sb.append(b);
            }
        } else {
            for (int i = 0; i < b; i++) {
                sb.append(a);
            }
        }

        System.out.println(sb);
    }
}
