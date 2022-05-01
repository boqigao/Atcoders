package com.boqi.atcoders.abc.abc243;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class D {
    public static int n;
    public static long x;
    public static Stack<String> seq = new Stack<String>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        x = Long.parseLong(st.nextToken());
        String[] temp = br.readLine().split("");
        for (int i = 0; i < n; i++) {
            if (temp[i].equals("U")) {
                if (!seq.isEmpty()) {
                    if (seq.peek().equals("R") || seq.peek().equals("L")) {
                        seq.pop();
                        continue;
                    }
                }
            }
            seq.add(temp[i]);
        }
        for (String s : seq) {
            if (s.equals("U"))
                x /= 2;
            else if (s.equals("L"))
                x *= 2;
            else if (s.equals("R"))
                x = 2 * x + 1;
        }
        pw.println(x);
        pw.flush();
        pw.close();
    }
}
