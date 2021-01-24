package com.boqi.atcoders.abc.abc156;

import java.util.Arrays;
import java.util.Scanner;

public class Rally {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
        }

        int minX = Arrays.stream(x).min().getAsInt();
        int maxX = Arrays.stream(x).max().getAsInt();

        int minValue = Integer.MAX_VALUE;
        int[] power = new int[n];
        for (int i = minX; i <= maxX; i++) { //i是p可以选择的位置
            for (int j = 0; j < x.length; j++) { //j是x的下标
                power[j] = (x[j] - i) * (x[j] - i);
            }
            minValue = Math.min(minValue, Arrays.stream(power).sum());
        }

        System.out.println(minValue);
    }
}
