package com.boqi.atcoders.abc.abc154;

import java.util.Scanner;

public class DDiceInLine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        double[] dice = new double[n];
        for (int i = 0; i < n; i++) {
            dice[i] = ExpectOfEachDice(sc.nextInt());
        }
        //System.out.println(Arrays.toString(dice));

        double maxExpect = 0;
        double tempExpect = 0;


        for (int i = 0; i < n; i++) {
            if (i < k) {
                maxExpect += dice[i];
                tempExpect += dice[i];
                continue;
            }
            tempExpect += dice[i];
            tempExpect -= dice[i - k];
            maxExpect = Math.max(tempExpect, maxExpect);

        }

        System.out.println(maxExpect);
    }

    public static double ExpectOfEachDice(int n) {
        if (n % 2 == 1) {
            return ((n / 2) + 1.0);
        } else {
            return ((n / 2.0) + 0.5);
        }
    }
}
