import java.util.HashMap;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        HashMap<String, Integer> map = new HashMap<>();

        int i;
        String temp;
        int a;
        int b;
        for (i = 1; i <= n; i++) {
            temp = String.valueOf(i);
            temp = temp.charAt(0) + temp.substring(temp.length() - 1);
            if (map.containsKey(temp))
                map.put(temp, map.get(temp) + 1);
            else
                map.put(temp, 1);
        }

        long ans = 0;
        for (i = 1; i <= n; i++) {
            temp = String.valueOf(i);
            temp = temp.substring(temp.length() - 1) + temp.charAt(0);
            if (map.containsKey(temp))
                ans += map.get(temp);
        }
        System.out.println(ans);
    }
}
