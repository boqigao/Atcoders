package com.boqi.atcoders.abc.abc187;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class C{
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int n = sc.nextInt();
        Set<String> ss = new HashSet<>();
        for (int i = 0; i < n; i++) {
            ss.add(sc.next());
        }
        // 他这个纯粹是利用了集合的特性
        // 感觉真要说多快也不应该呀。。
        // 要记住hashset的contains方法巨快
        for(String s: ss) {
            if(ss.contains("!"+s)) {
                System.out.println(s);
                return;
            }
        }
        System.out.println("satisfiable");
    }
}

/**
class TimeoutC {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int n = sc.nextInt();
        String[] ss = new String[n];

        for(int i = 0; i < n; i++){
            ss[i] = sc.next();
        }

        for(int i = 0; i < n - 1; i++){
            for (int j = i + 1; j < n; j++) {
                if (ss[j].charAt(0) != '!'){
                    continue;
                }

                String tmpI = "!" + ss[i];
                if(tmpI.equals(ss[j])){
                    System.out.println(ss[i]);
                    return;
                }
            }
        }

        System.out.println("satisfiable");
    }
}
*/
