package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 에라토스테네스의 체 문제 */
/**
 * <a href="https://ko.wikipedia.org/wiki/%EC%97%90%EB%9D%BC%ED%86%A0%EC%8A%A4%ED%85%8C%EB%84%A4%EC%8A%A4%EC%9D%98_%EC%B2%B4">에라토스테네스의 체</a>
 */
public class BJ_1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int M = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);
        StringBuilder sb = new StringBuilder();
        boolean[] isPrime = new boolean[N+1];
        for(int i=2; i<=N; i++) {
            // 2 ~ N 까지 소수로 설정
            isPrime[i] = true;
        }
        // 2 ~ i*i<=n
        // 각각의 배수들을 지워간다
        for(int i=2; i*i<=N; i++) {
            if(isPrime[i]) {
                for(int j=i*i; j<=N; j+=i) {
                    // i*i 미만은 이미 처리되었으므로 j의 시작값은 i*i로 최적화
                    isPrime[j] = false;
                }
            }
        }
        for(int i=M; i<isPrime.length; i++) {
            if(isPrime[i]) sb.append(i).append("\n");
        }
        System.out.println(sb);
    }

    /* 일반적인 방법(시간초과) */
    public static void main2(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int M = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);
        StringBuilder sb = new StringBuilder();
        for(int i=M; i<=N; i++) {
            boolean isPrime = true;
            for(int j=2; j<i; j++) {
                if(i%j==0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) sb.append(i).append("\n");
        }
        System.out.println(sb);
    }
}
