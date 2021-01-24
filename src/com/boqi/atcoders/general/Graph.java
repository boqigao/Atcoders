package com.boqi.atcoders.general;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.function.BinaryOperator;


public class Graph {
    //static final long mod = 1000000007;
    static final long mod = 998244353;
    static final int INF = 1123456789;
    static final long LINF = 9223372036854775807L;
    static MyScanner sc = new MyScanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);
    static ArrayList<ArrayList<Integer>> g = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        int N = sc.nextInt();
        int M = sc.nextInt();
        long[] A = new long[N];
        for (int i = 0; i < N; i++) A[i] = sc.nextLong();

        for (int i = 0; i < N; i++) g.add(new ArrayList<Integer>());
        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            x--;
            y--;
            g.get(x).add(y);
        }

        long[] dp = new long[N];
        for (int i = 0; i < N; i++) dp[i] = INF; // 買った価格の最小値
        long ans = -LINF;
        for (int i = 0; i < N; i++) {
            int v = i;
            if (dp[i] != INF) ans = Math.max(ans, A[v] - dp[v]);

            dp[v] = Math.min(dp[v], A[v]);

            for (int u : g.get(v)) {
                dp[u] = Math.min(dp[u], dp[v]);
            }
        }

        out.println(ans);

        out.flush();
    }

    static void shuffle(int[] in) {
        for (int i = 0; i < in.length; i++) {
            int idx = (int) (Math.random() * in.length);
            int tmp = in[i];
            in[i] = in[idx];
            in[idx] = tmp;
        }
    }

    static void shuffle(long[] in) {
        for (int i = 0; i < in.length; i++) {
            int idx = (int) (Math.random() * in.length);
            long tmp = in[i];
            in[i] = in[idx];
            in[idx] = tmp;
        }
    }

    // 繰り返し2乗法
    static long pow(long x, long n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n % 2 == 0) {
            long tmp = pow(x, n / 2);
            return tmp * tmp % mod;
        } else {
            return pow(x, n - 1) * x % mod;
        }
    }

    static long powmod(long x, long n, long m) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n % 2 == 0) {
            long tmp = powmod(x, n / 2, m);
            return tmp * tmp % m;
        } else {
            return powmod(x, n - 1, m) * x % m;
        }
    }

    // mod mでの aの逆元を求める
    static long modinv(long a, long m) {
        Pair<Long, Long> tmp = modinv_rec(a, m);
        long res = tmp.a %= m;
        if (res < 0) res += m;
        return res;
    }

    // ax + by = gcd(a,b)の(x,y)を求める 返り値はPair(x,y)
    static Pair<Long, Long> modinv_rec(long a, long b) {
        if (b == 0) {
            long x = 1L;
            long y = 0L;
            return new Pair<Long, Long>(x, y);
        }
        Pair<Long, Long> st = modinv_rec(b, a % b);
        long s = st.a;
        long t = st.b;

        long x = t;
        long y = s - a / b * t;
        return new Pair<Long, Long>(x, y);
    }

    static long gcd(long a, long b) {
        if (b == 0) return a;
        else return gcd(b, a % b);
    }

    static ArrayList<Pair<Long, Long>> prime_factorize(long N) {
        ArrayList<Pair<Long, Long>> res = new ArrayList<>();
        for (long a = 2; a * a <= N; a++) {
            if (N % a != 0) continue;
            long ex = 0;

            while (N % a == 0) {
                ex++;
                N /= a;
            }

            res.add(new Pair(a, ex));
        }

        if (N != 1) {
            res.add(new Pair(N, 1L));
        }
        return res;
    }

    // 標準ライブラリに異なる型を引数に取る二項演算interfaceが用意されていないため、定義
    @FunctionalInterface
    interface MyBinaryOperator<T1, T2> {
        T1 apply(T1 t1, T2 t2);
    }

    public static class SegmentTree<Monoid> {
        final BinaryOperator<Monoid> f;
        final Monoid zero_element;
        int element_size;
        ArrayList<Monoid> node = new ArrayList<Monoid>();

        SegmentTree(int n, BinaryOperator<Monoid> f, Monoid zero_element) {
            this.f = f;
            this.zero_element = zero_element;

            element_size = 1;
            while (element_size < n) {
                element_size *= 2;
            }
            for (int i = 0; i < element_size * 2; i++) node.add(zero_element);
        }

        void set(int k, Monoid x) {
            node.set(element_size + k, x);
        }

        void build() {
            for (int i = element_size - 1; i > 0; i--) {
                node.set(i, f.apply(node.get(i * 2), node.get(i * 2 + 1)));
            }
        }

        // node[k] <- x
        void update(int k, Monoid x) {
            k += element_size;
            node.set(k, x);
            while (k != 1) {
                k /= 2;
                Monoid merged = f.apply(node.get(k * 2), node.get(k * 2 + 1));
                node.set(k, merged);
            }
        }

        // 区間[begin, end)のmerge結果を返す
        Monoid query(int begin, int end) {
            Monoid left_merged = zero_element;
            Monoid right_merged = zero_element;
            begin += element_size;
            end += element_size;
            while (begin < end) {
                if (begin % 2 == 1) {
                    left_merged = f.apply(left_merged, node.get(begin));
                    begin++;
                }

                if (end % 2 == 1) {
                    right_merged = f.apply(node.get(end - 1), right_merged);
                    end--;
                }

                begin /= 2;
                end /= 2;
            }

            return f.apply(left_merged, right_merged);
        }

    }

    public static class LazySegmentTree<Monoid, OperatorMonoid> {

        final BinaryOperator<Monoid> data_merge_func;
        final BinaryOperator<OperatorMonoid> operator_merge_func;
        final MyBinaryOperator<Monoid, OperatorMonoid> operate_func;
        final Monoid data_zero_element;
        final OperatorMonoid operator_zero_element;
        int data_size, tree_height;
        // data: 自分と同じか自分より根の方に零元でない作用素が存在する <-> まだ未確定の値
        ArrayList<Monoid> data = new ArrayList<Monoid>();
        ArrayList<OperatorMonoid> operator = new ArrayList<OperatorMonoid>();


        LazySegmentTree(int data_size, BinaryOperator<Monoid> data_merge_func,
                        BinaryOperator<OperatorMonoid> operator_merge_func,
                        MyBinaryOperator<Monoid, OperatorMonoid> operate_func,
                        Monoid data_zero_element, OperatorMonoid operator_zero_element) {
            this.data_merge_func = data_merge_func;
            this.operator_merge_func = operator_merge_func;
            this.operate_func = operate_func;
            this.data_zero_element = data_zero_element;
            this.operator_zero_element = operator_zero_element;

            this.data_size = 1;
            this.tree_height = 0;
            while (this.data_size < data_size) {
                this.data_size *= 2;
                this.tree_height++;
            }
            for (int i = 0; i < 2 * this.data_size; i++) {
                data.add(data_zero_element);
                operator.add(operator_zero_element);
            }
        }

        void set(int idx, Monoid x) {
            data.set(idx + data_size, x);
        }

        void build() {
            for (int k = data_size - 1; k > 0; k--) {
                Monoid merged = data_merge_func.apply(data.get(2 * k), data.get(2 * k + 1));
                data.set(k, merged);
            }
        }

        // operator[k]から子に作用素を伝搬, data[k]の値も確定
        private void propagete(int k) {
            if (operator.get(k) != operator_zero_element) {
                operator.set(2 * k, operator_merge_func.apply(operator.get(2 * k), operator.get(k)));
                operator.set(2 * k + 1, operator_merge_func.apply(operator.get(2 * k + 1), operator.get(k)));
                data.set(k, reflect(k));
                operator.set(k, operator_zero_element);
            }
        }

        // data[k]を最終確定
        private Monoid reflect(int k) {
            if (operator.get(k) == operator_zero_element) return data.get(k);
            else return operate_func.apply(data.get(k), operator.get(k));
        }

        // 根からoperator[k]まで、値を伝搬
        private void thrust(int k) {
            for (int i = tree_height; i > 0; i--) propagete(k >> i);
        }

        private void recalc(int k) {
            while (k != 1) {
                k /= 2;
                Monoid merged = data_merge_func.apply(reflect(2 * k), reflect(2 * k + 1));
                data.set(k, merged);
            }
        }

        void update(int begin, int end, OperatorMonoid x) {
            begin += data_size;
            end += data_size;
            // 根に近いoperatorに古い更新が残ったままにしないよう、この時点で伝搬
            thrust(begin);
            thrust(end - 1);
            int left = begin, right = end;
            while (left < right) {
                if (left % 2 == 1) {
                    OperatorMonoid merged_operator = operator_merge_func.apply(operator.get(left), x);
                    operator.set(left, merged_operator);
                    left++;
                }

                if (right % 2 == 1) {
                    right--;
                    OperatorMonoid merged_operator = operator_merge_func.apply(operator.get(right), x);
                    operator.set(right, merged_operator);
                }

                left /= 2;
                right /= 2;
            }


            // 遅延させているやつより上のdataへの作用を反映
            recalc(begin);
            recalc(end - 1);
        }

        Monoid query(int begin, int end) {
            begin += data_size;
            end += data_size;
            thrust(begin);
            thrust(end - 1);
            Monoid left_merged = data_zero_element;
            Monoid right_merged = data_zero_element;
            int left = begin, right = end;
            while (left < right) {
                if (left % 2 == 1) {
                    left_merged = data_merge_func.apply(left_merged, reflect(left));
                    left++;
                }
                if (right % 2 == 1) {
                    right--;
                    right_merged = data_merge_func.apply(reflect(right), right_merged);
                }
                left /= 2;
                right /= 2;
            }

            return data_merge_func.apply(left_merged, right_merged);
        }

    }

    static class MyScanner {
        StringTokenizer st;
        BufferedReader br;

        public MyScanner(InputStream system) {
            br = new BufferedReader(new InputStreamReader(system));
        }

        public MyScanner(String file) throws Exception {
            br = new BufferedReader(new FileReader(file));
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public int[] intArr(int n) throws IOException {
            int[] in = new int[n];
            for (int i = 0; i < n; i++) in[i] = nextInt();
            return in;
        }

        public long[] longArr(int n) throws IOException {
            long[] in = new long[n];
            for (int i = 0; i < n; i++) in[i] = nextLong();
            return in;
        }

        public int[] intSortedArr(int n) throws IOException {
            int[] in = new int[n];
            for (int i = 0; i < n; i++) in[i] = nextInt();
            shuffle(in);
            Arrays.sort(in);
            return in;
        }

        public long[] longSortedArr(int n) throws IOException {
            long[] in = new long[n];
            for (int i = 0; i < n; i++) in[i] = nextLong();
            shuffle(in);
            Arrays.sort(in);
            return in;
        }

        public Integer[] IntegerArr(int n) throws IOException {
            Integer[] in = new Integer[n];
            for (int i = 0; i < n; i++) in[i] = nextInt();
            return in;
        }

        public Long[] LongArr(int n) throws IOException {
            Long[] in = new Long[n];
            for (int i = 0; i < n; i++) in[i] = nextLong();
            return in;
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        public char nextChar() throws IOException {
            return next().charAt(0);
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public boolean ready() throws IOException {
            return br.ready();
        }

        public void waitForInput() throws InterruptedException {
            Thread.sleep(3000);
        }
    }

    static class UnionFind {
        ArrayList<Integer> data = new ArrayList<>();

        UnionFind(int data_size) {
            for (int i = 0; i < data_size; i++) data.add(-1);
        }

        boolean unite(int x, int y) {
            x = find(x);
            y = find(y);
            if (x == y) return false;
            if (data.get(x) > data.get(y)) {
                int tmp = x;
                x = y;
                y = tmp;
            }
            data.set(x, data.get(x) + data.get(y));
            data.set(y, x);
            return true;
        }

        boolean same(int x, int y) {
            x = find(x);
            y = find(y);
            return x == y;
        }

        int find(int k) {
            if (data.get(k) < 0) return k;
            int parent = find(data.get(k));
            data.set(k, parent);
            return parent;
        }

        int size_union(int k) {
            return -data.get(find(k));
        }
    }

    static class Pair<T1, T2> {
        T1 a;
        T2 b;

        Pair(T1 a, T2 b) {
            this.a = a;
            this.b = b;
        }

    }

    static class Tuple {
        int a, b, c;

        Tuple(int ta, int tb, int tc) {
            a = ta;
            b = tb;
            c = tc;
        }
    }

    static class Edge {
        int to;
        long weight;

        Edge(int x, long y) {
            this.to = x;
            this.weight = y;
        }
    }

    static public class MyComparator implements Comparator<Pair<Integer, Integer>> {
        @Override
        public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
            //return p1.a < p2.a ? -1 : 1;
            if (p1.a < p2.a) return -1;
            else if (p1.a == p2.a) return 0;
            else return 1;
        }
    }


}
