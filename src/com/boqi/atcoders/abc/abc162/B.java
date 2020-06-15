package com.boqi.atcoders.abc.abc162;

import java.util.Scanner;

public class B {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        long sum = 0;
        for(int i = 0; i <=n; i++){
            if(!(i%3==0||i%5==0)){
                //System.out.print(i+"\t");
                sum+=i;
            }
        }
        System.out.println(sum);
    }
}
