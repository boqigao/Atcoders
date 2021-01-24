package com.boqi.atcoders.abc.abc188;

import java.util.Scanner;

/**
 * 这道题是给你一个x，给你一个y
 * 然后x可以（1）增1，（2）减1，（3）翻倍
 * 问怎么样最少步骤能达到y
 * <p>
 * 这道题与其说怎么样达到y，不如说从y怎么达到x，这个步骤消耗是一样的
 * 只要是(y>x)
 * x：A增1，B减1，C除以2 （只有偶数时候）
 * <p>
 * 1. 可以整理出无意义的操作
 * AB，BA：加减后直接增加
 * AAC，BBC：等价于CA或者，CB
 * <p>
 * 2. 由上可知，我们只考虑c的话，会变成
 * （A or B or No 操作）C（ A or B or No操作）C（A or B or No操作）
 * C（AAAAAAORBBBBBB）最后的结果A或者B连续是没问题的
 * <p>
 * 3.所以解法可以得到一个函数
 * f(y) =   if y是偶数：
 * f(y/2)+1
 * or |x-y|
 * else  y是奇数
 * f(y-1)
 * or f(y+1
 */


import java.util.HashMap;
import java.util.Scanner;

public class F {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            long x = sc.nextLong();
            long y = sc.nextLong();

            HashMap<Long, Long> memo = new HashMap<Long, Long>();
            System.out.println(calcX(x, y, memo));
        }
    }

    public static long calcX(long x, long y, HashMap<Long, Long> memo) {
        if (memo.containsKey(y)) {
            return memo.get(y);
        } else if (y <= x) {
            memo.put(y, x - y);
            return (x - y);
        } else {
            if(y%2 == 0) {
                memo.put(y, Math.min(calcX(x, y / 2, memo) + 1 , y - x));
            }else {
                memo.put(y, Math.min(calcX(x, (y-1), memo) + 1 , calcX(x, (y+1), memo) + 1));
            }

            return memo.get(y);
        }
    }
}
