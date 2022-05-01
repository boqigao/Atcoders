package com.boqi.atcoders.abc.abc247;

import java.util.Objects;
import java.util.Scanner;

public class B {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        String[][] names = new String[n][2];
        for (int i = 0; i < n; i++) {
            names[i][0] = sc.next();
            names[i][1] = sc.next();
        }

        for (int i = 0; i < n; i++) {
            boolean isS = false;
            boolean isT = false;
            for (int j = 0; j < n; j++) {
                if (j == i) {
                    continue;
                }
                if (names[i][0].equals(names[j][0]) || Objects.equals(names[i][0], names[j][1])) {
                    isS = true;
                }
                if (Objects.equals(names[i][1], names[j][0]) || Objects.equals(names[i][1], names[j][1])) {
                    isT = true;
                }
            }
            if (isS && isT) {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }
}
