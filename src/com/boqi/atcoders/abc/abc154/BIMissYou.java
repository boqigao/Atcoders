package com.boqi.atcoders.abc.abc154;

import java.util.Scanner;

public class BIMissYou {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String  s = sc.next();
        int length = s.length();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<s.length();i++){
            sb.append("x");
        }
        System.out.println(sb);
    }
}
