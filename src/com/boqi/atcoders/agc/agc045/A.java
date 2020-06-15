package com.boqi.atcoders.agc.agc045;

import java.util.Scanner;

public class A {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int t = sc.nextInt();
        StringBuilder ans = new StringBuilder();
        //1人的flag
        boolean flag1 = false;
        //0人的flag
        boolean flag0 = false;
        for(int i = 0; i < t; i++){
            int n = sc.nextInt();
            long[] a = new long[n];
            for(int j = 0; j < n; j++){
                a[j] = sc.nextLong();
            }
            String s = sc.next();
            for(int j = 0; j < n; j++){
                int tmpNum = Integer.parseInt(s.charAt(j)+"");
                if (tmpNum==0){
                    if(a[j] == 1){
                        flag0=true;
                    }
                }
            }

            if(flag0==true){
                ans = ans.append("0\n");
            }else {
                ans = ans.append("1\n");
            }

        }

        System.out.println(ans);
    }
}
