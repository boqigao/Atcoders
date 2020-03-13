package com.boqi.atcoders.companies.hitachi20200308;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;

public class NiceShopping {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int a = sc.nextInt();
        int b = sc.nextInt();
        int m = sc.nextInt();
        int[] priceA = new int[a];
        int[] priceB = new int[b];
        int[][] kupon = new int[m][3];
        for (int i = 0; i< a ; i++ ){
            priceA[i] = sc.nextInt();
        }
        for (int i = 0; i< b ; i++ ){
            priceB[i] = sc.nextInt();
        }
        for (int i = 0; i<m; i++){
            for (int j = 0; j<3; j++){
                kupon[i][j] = sc.nextInt();
            }
        }

        int minValue = Integer.MAX_VALUE;
        int tempValue = 0;
        //先计算kupon的最优价格
        for (int i = 0; i<m; i++){
            tempValue = priceA[kupon[i][0]-1] + priceB[kupon[i][1]-1]-kupon[i][2];
            minValue = Math.min(minValue, tempValue);
        }

        int aMin = Arrays.stream(priceA).min().getAsInt();
        int bMin = Arrays.stream(priceB).min().getAsInt();

        minValue = Math.min(minValue, aMin+bMin);

        System.out.println(minValue);

    }
}

