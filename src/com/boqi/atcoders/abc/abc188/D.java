package com.boqi.atcoders.abc.abc188;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


// 这道题的问题是，没有那么长的数列来保存。。
// 所以需要一个map来保存所有的日期时间
public class D {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int n = sc.nextInt();
        int cost = sc.nextInt();

        int a, b, c;
        // 这个用来保存他想要参加的销售活动
        // event[a] 的时候增加一个
        // event[b] 的时候减少一个
        Map<Integer, Long> events = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();

            // 如果events里面已经有a这个天数，那就需要把这个天数对应的价格表上加上c
            // 他这个a-1估计是为了方便计算

            // 如果在别的活动已经有a这个数字了，那么需要将其取出再加上 c
            if (events.containsKey(a - 1)) {
                events.put(a - 1, events.get(a - 1) + c);
            } else {
                events.put(a - 1, (long) c);
            }
            // 在这个活动结束的时候，需要减去c
            if (events.containsKey(b)) {
                events.put(b, events.get(b) - c);
            } else {
                events.put(b, (long) -c);
            }
        }

        // 经过上述for循环，我们已经用了一个map来记录下了所有的活动的金钱
        // 然后我们需要对比每一天用这个是不是划算

        // s是当前这天，参加event的总价格
        long s = 0;
        // total 是总共需要的金钱
        long total = 0;
        // pre 是当前的天数
        int pre = 0;

        // 这里有个知识是map是按照顺序排序的
        for (Map.Entry<Integer, Long> event : events.entrySet()) {
            // 从第一个a开始，前面全是0
            // 要记住 map的key是日期，value是价格
            total += Math.min(cost, s) * (event.getKey() - pre);
            // 从第一个a开始，s加上这个a日期的价格
            s += event.getValue();
            // 记录下 a的时间
            pre = event.getKey();
        }
        // 比如只有a-》b的情况的话
        // 那就是 价格 * b-a的时间就对了嘛。

        System.out.println(total);
    }
}
