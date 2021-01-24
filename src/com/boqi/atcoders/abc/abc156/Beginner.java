package com.boqi.atcoders.abc.abc156;

import java.util.Scanner;

public class Beginner {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        //int n = sc.nextInt();
        //int r = sc.nextInt();
        solve(22, 3051);
    }

    public static void solve(int n, int r) {
        int res = 0;
        res = (n >= 10 ? 0 : 100 * (10 - n)) + r;
        System.out.println(res);
    }
}
