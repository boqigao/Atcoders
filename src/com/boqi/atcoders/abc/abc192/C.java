package com.boqi.atcoders.abc.abc192;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class C {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String n = sc.next();
        int k = sc.nextInt();

        for (int i = 0; i < k; i++) {
            int a1 = a1(n);
            int a2 = a2(n);
            int tmp = a1 - a2;
            n = tmp + "";
        }
        System.out.println(n);
    }

    private static int a1(String n) {
        char[] c = n.toCharArray();
        Arrays.sort(c);
        char[] cr = reverse(c);
        String s = new String(cr);
        return Integer.parseInt(s);
    }

    private static int a2(String n) {
        char[] c = n.toCharArray();
        Arrays.sort(c);
        String s = new String(c);
        return Integer.parseInt(s);
    }

    private static char[] reverse (char[] validData) {
        for(int i = 0; i < validData.length / 2; i++)
        {
            char temp = validData[i];
            validData[i] = validData[validData.length - i - 1];
            validData[validData.length - i - 1] = temp;
        }
        return validData;
    }
}
