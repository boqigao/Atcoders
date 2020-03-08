package com.boqi.atcoders.abc.abc157;

import java.util.Scanner;

public class DuplexPrinting {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int N = sc.nextInt();
        int ans = 0;
        if(N%2==0){
            System.out.println(N/2);
        } else {
            System.out.println((N/2)+1);
        }

    }
}
