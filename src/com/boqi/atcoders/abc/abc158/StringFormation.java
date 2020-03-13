package com.boqi.atcoders.abc.abc158;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * 接收消息，然后对字符串做处理
 * @author Boqi Gao
 */
public class StringFormation {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String s = sc.next();
        int numOfOper = sc.nextInt();
        Deque<Character> dq = new ArrayDeque<>();

        for(int i = 0; i < s.length(); i++) {
            dq.addLast(s.charAt(i));
        }

        //此处定义一个逆序flag
        boolean rev = false;

        for(int i = 0; i <numOfOper; i++){
            int oper = sc.nextInt(); //此处接收操作命令
            if (oper == 1){
                rev = !rev; //如果操作命令为1，那么将逆序flag置反
            }else {
                int f = sc.nextInt();//此处接收添加命令。
                                     //如果添加命令为1就在头添加，如果添加命令为2就在末尾添加
                String cs = sc.next();
                Character c = cs.charAt(0);
                //这里是核心，如果添加命令为在头添加
                // 在头部添加的情况：本身在头部添加，或者是到转后在尾部添加
                // 他这样写的原因是因为本身rev他定义的是false
                if((f == 1 && !rev) || (f == 2 && rev)){
                    dq.addFirst(c);
                }else {
                    dq.addLast(c);
                }

            }
        }

        StringBuilder sb = new StringBuilder();

        while (!dq.isEmpty()){
            sb.append(dq.pollFirst());
        }
        System.out.println(rev==false?sb:sb.reverse());
    }
}
