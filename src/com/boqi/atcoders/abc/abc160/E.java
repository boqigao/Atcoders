package com.boqi.atcoders.abc.abc160;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class E {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int x = sc.nextInt(), y = sc.nextInt(), a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
        Long[] red = new Long[a], green = new Long[b], cless = new Long[c];
        for (int i = 0; i < a; i++) red[i] = sc.nextLong();
        for (int i = 0; i < b; i++) green[i] = sc.nextLong();
        for (int i = 0; i < c; i++) cless[i] = sc.nextLong();
        Arrays.sort(red, Comparator.reverseOrder());
        Arrays.sort(green, Comparator.reverseOrder());
        ArrayList<Long> arr = new ArrayList<>();
        arr.addAll(Arrays.asList(red).subList(0, x));
        arr.addAll(Arrays.asList(green).subList(0, y));
        arr.addAll(Arrays.asList(cless));
        arr.sort(Comparator.reverseOrder());
        long res = 0;
        for (int i = 0; i < x + y; i++) res += arr.get(i);
        System.out.println(res);
    }
}

class Mycomparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {

        if (o1 > o2) // 默认是o1 < o2时返回-1， 一下同理
            return -1;
        if (o1 < o2)
            return 1;
        return 0;
    }
}
