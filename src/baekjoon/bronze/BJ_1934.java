package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 유클리드 호제법 */
public class BJ_1934 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            sb.append(a*b/gcd(a, b)).append("\n");  // POINT a*b/최대공약수 = 최소공배수
        }
        System.out.println(sb);
    }

    /**
     * <a href="https://ko.wikipedia.org/wiki/%EC%9C%A0%ED%81%B4%EB%A6%AC%EB%93%9C_%ED%98%B8%EC%A0%9C%EB%B2%95">위키백과</a>
     */
    static int gcd(int a, int b) {
        if(b==0) return a;
        return gcd(b, a%b);
    }
}
