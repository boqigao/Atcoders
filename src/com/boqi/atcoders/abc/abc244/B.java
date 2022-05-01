package com.boqi.atcoders.abc.abc244;

import java.util.Scanner;

public class B {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        String s = sc.next();
        int x = 0, y = 0;
        char dir = 'r';
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == 'S') {
                if (dir == 'r')
                    x++;
                else if (dir == 'd')
                    y--;
                else if (dir == 'l')
                    x--;
                else
                    y++;
            }

            if (c == 'R') {
                if (dir == 'r')
                    dir = 'd';
                else if (dir == 'd')
                    dir = 'l';
                else if (dir == 'l')
                    dir = 'u';
                else
                    dir = 'r';
            }
        }
        System.out.println(x + " " + y);
    }
}
