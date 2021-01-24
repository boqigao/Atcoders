package com.boqi.atcoders.abc.abc162;

import java.util.ArrayList;
import java.util.Scanner;

public class D {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        String s = sc.next();

        int ans = 0;
        ArrayList<Integer> r = new ArrayList<>();
        ArrayList<Integer> g = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();


        //0R, 1G, 2B

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R') {
                r.add(i);
            }
            if (s.charAt(i) == 'G') {
                g.add(i);
            }
            if (s.charAt(i) == 'B') {
                b.add(i);
            }
        }

        for (int i = 0; i < r.size(); i++) {
            for (int j = 0; j < g.size(); j++) {
                for (int k = 0; k < b.size(); k++) {
                    if ((r.get(i) < g.get(j) &&
                            g.get(j) < b.get(k) &&
                            r.get(j) - g.get(i) != b.get(k) - g.get(j)) ||
                            (r.get(j) < g.get(i) &&
                                    g.get(i) < b.get(k) &&
                                    r.get(i) - g.get(j) != b.get(k) - g.get(i)) ||
                            (r.get(k) < g.get(j) &&
                                    g.get(j) < b.get(i) &&
                                    r.get(j) - g.get(k) != b.get(i) - g.get(j))

                    ) {
                        ans++;
                    }
                }
            }
        }

        System.out.println(ans);

    }
}
