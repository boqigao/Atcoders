package com.boqi.atcoders.abc.abc157;

import java.util.Scanner;

public class Bingo {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[] card = new int[9];
        for(int i = 0; i < 9; i++){
            card[i] = sc.nextInt();
        }
        int num = sc.nextInt();
        for(int i = 0; i< num; i++){
            int b = sc.nextInt();
            for(int j = 0; j < 9; j++){
                if (b == card[j]){
                    card[j] = 0;
                }
            }
        }
        if((card[0]==0 && card[1]==0 && card[2]==0) ||
                (card[0]==0 && card[3]==0 && card[6]==0) ||
                (card[0]==0 && card[4]==0 && card[8]==0) ||
                (card[3]==0 && card[4]==0 && card[5]==0) ||
                (card[6]==0 && card[7]==0 && card[8]==0) ||
                (card[2]==0 && card[4]==0 && card[6]==0) ||
                (card[1]==0 && card[4]==0 && card[7]==0) ||
                (card[2]==0 && card[5]==0 && card[8]==0)
        ){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }

    }
}
