package com.boqi.atcoders.abc.abc247;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        String ans = "1";
        if (n == 1) {
            System.out.println(ans);
            return;
        }

        for (int i = 2; i <= n; i++) {
            ans = createString(ans, i);
        }
        System.out.println(ans);
    }

    private static String createString(String prevString, int n) {
        return prevString +" "+n + " "+ prevString;
    }
}
