package com.boqi.atcoders.abc.abc195;

/**
 * 这道题有点像lc的做游戏的dp问题，果然还是不够熟练
 * 做游戏的问题，基本都是从后开始往前考虑
 *
 * dp[i][j]: 在决定到第i文字的时候mod7是j的时候的胜负
 * 因此dp[n][0] = takahashi
 * dp[n][1-6] = aoki
 *
 * 因此，转移方程是
 *
 *              1. 选择si:dp[i+1][(j + si) mod 7]
 * dp[i][j] =
 *              2. 选择0 dp[i+1][j]
 *
 * 答案是dp[0][0]
 *
 *
 * 倒算的理由我大概想通了！
 * 比如如果数字是 235 字母是 AAAT
 * 我们从最后一位看起，即，我们这个时候当做前面数字都已经确定 则此数字是
 * x 5
 *
 * 因此，我们可以计算，当x%7的余数为3的时候（此时高桥选择5），或者x % 7 的余数为0的时候（此时高桥选择0）
 * 高桥是百分百胜利的
 * 此时dp是[t,f,f,t,f,f,f]
 *
 * 好，让我们继续往前看，前一位数字是3
 * 这时候我们根据后面推出的结果，得到如果青木选3，那么高桥可以选5，如果青木选0，那么高桥可以选3，这样不管青木选啥，高桥都必胜
 * 此时dp是[t,f,f,f,f,f,f]
 *
 * 那如果我们再往前看呢，前一位数字是2
 * 因为我们直到上一轮的结果是[t,f,f,f,f,f,f]
 * 意思就是说，如果我们这一轮导致的余数为0的时候的话，高桥百分百获胜
 * 因此，为了让余数不为0，青木可以选择2，这样余数就不为0了
 * 即：（j * 10 + 2）mod7，所以这一轮过后 dp是
 * [f,f,f,f,f,f,f]
 * 也就是高桥不管一开始怎么选，青木都稳赢
 *
 * 为什么初期只有dp[0] = true 呢，因为最后只有mod7为0的时候，高桥才能赢
 *
 * 为什么结局要看dp[0]呢，因为
 * dp[0]的意思是，在第一轮刚开始预测的胜负，同时，dp[0]还有个意思就是初始数字是0
 *
 */
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;

public class E{
    static InputStream is;
    static PrintWriter out;
    static String INPUT = "";

    static void solve()
    {
        int n = ni();
        char[] s = ns(n);
        char[] at = ns(n);
        boolean[] dp = new boolean[7];
        dp[0] = true;
        for(int i = n-1;i >= 0;i--){
            boolean[] ndp = new boolean[7];
            if(at[i] == 'T'){
                for(int j = 0;j < 7;j++){
                    if(dp[j*10%7] || dp[(j*10+s[i]-'0')%7]){
                        ndp[j] = true;
                    }
                }
            }else{
                for(int j = 0;j < 7;j++){
                    if(dp[j*10%7] && dp[(j*10+s[i]-'0')%7]){
                        ndp[j] = true;
                    }
                }
            }
            dp = ndp;
        }
        out.println(dp[0] ? "Takahashi" : "Aoki");
    }

    public static void main(String[] args) throws Exception
    {
        long S = System.currentTimeMillis();
        is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        out = new PrintWriter(System.out);

        solve();
        out.flush();
        long G = System.currentTimeMillis();
        tr(G-S+"ms");
    }

    private static boolean eof()
    {
        if(lenbuf == -1)return true;
        int lptr = ptrbuf;
        while(lptr < lenbuf)if(!isSpaceChar(inbuf[lptr++]))return false;

        try {
            is.mark(1000);
            while(true){
                int b = is.read();
                if(b == -1){
                    is.reset();
                    return true;
                }else if(!isSpaceChar(b)){
                    is.reset();
                    return false;
                }
            }
        } catch (IOException e) {
            return true;
        }
    }

    private static byte[] inbuf = new byte[1024];
    static int lenbuf = 0, ptrbuf = 0;

    private static int readByte()
    {
        if(lenbuf == -1)throw new InputMismatchException();
        if(ptrbuf >= lenbuf){
            ptrbuf = 0;
            try { lenbuf = is.read(inbuf); } catch (IOException e) { throw new InputMismatchException(); }
            if(lenbuf <= 0)return -1;
        }
        return inbuf[ptrbuf++];
    }

    private static boolean isSpaceChar(int c) { return !(c >= 33 && c <= 126); }
    //	private static boolean isSpaceChar(int c) { return !(c >= 32 && c <= 126); }
    private static int skip() { int b; while((b = readByte()) != -1 && isSpaceChar(b)); return b; }

    private static double nd() { return Double.parseDouble(ns()); }
    private static char nc() { return (char)skip(); }

    private static String ns()
    {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while(!(isSpaceChar(b))){
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    private static char[] ns(int n)
    {
        char[] buf = new char[n];
        int b = skip(), p = 0;
        while(p < n && !(isSpaceChar(b))){
            buf[p++] = (char)b;
            b = readByte();
        }
        return n == p ? buf : Arrays.copyOf(buf, p);
    }

    private static char[][] nm(int n, int m)
    {
        char[][] map = new char[n][];
        for(int i = 0;i < n;i++)map[i] = ns(m);
        return map;
    }

    private static int[] na(int n)
    {
        int[] a = new int[n];
        for(int i = 0;i < n;i++)a[i] = ni();
        return a;
    }

    private static int ni()
    {
        int num = 0, b;
        boolean minus = false;
        while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
        if(b == '-'){
            minus = true;
            b = readByte();
        }

        while(true){
            if(b >= '0' && b <= '9'){
                num = num * 10 + (b - '0');
            }else{
                return minus ? -num : num;
            }
            b = readByte();
        }
    }

    private static long nl()
    {
        long num = 0;
        int b;
        boolean minus = false;
        while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
        if(b == '-'){
            minus = true;
            b = readByte();
        }

        while(true){
            if(b >= '0' && b <= '9'){
                num = num * 10 + (b - '0');
            }else{
                return minus ? -num : num;
            }
            b = readByte();
        }
    }

    private static void tr(Object... o) { if(INPUT.length() != 0)System.out.println(Arrays.deepToString(o)); }
}
