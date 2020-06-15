package com.boqi.atcoders.abc.abc162;

import java.util.Scanner;

public class A {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String n = sc.next();
        boolean containFlag = false;
        for(int i = 0; i < n.length(); i++){
            if(n.charAt(i) == '7'){
                containFlag = true;
            }
        }
        System.out.println(containFlag==true?"Yes":"No");
    }
}
