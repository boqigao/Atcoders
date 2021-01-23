package com.boqi.atcoders.abc.abc189;

import java.util.Scanner;

public class A {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception{
        String a = sc.next();
        char tmp = a.charAt(0);
        boolean result = true;
        for (int i = 0; i < a.length(); i++){
            if(a.charAt(i)!=tmp){
                result = false;
            }
        }

        System.out.println(result?"Won":"Lost");
    }
}
