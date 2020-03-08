package com.boqi.atcoders.abc.abc157;

import java.util.HashMap;
import java.util.Scanner;

public class GuessTheNumber {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int N = sc.nextInt();
        int M = sc.nextInt();
        HashMap<Integer, Character> hm = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<N; i++){
            sb.append("0");
        }
        for (int i = 0; i < M; i++){
            int s = sc.nextInt();
            String c = sc.next();

            char cChar = c.charAt(0);
            if(hm.containsKey(s-1)){
                System.out.println("-1");
                return;
            }else if ((s-1 == 0 && c.equals(0)) ||
                    ((s-1 == 0 && c.equals(0)) && (s-2 == 0 && c.equals(0)))
            ){
                System.out.println("-1");
                return;
            }else {
                sb.setCharAt(s-1, cChar);
            }
        }
        System.out.println(sb);
    }
}
