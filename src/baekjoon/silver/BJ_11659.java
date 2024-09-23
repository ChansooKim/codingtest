package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 구간합 문제 */
public class BJ_11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arrSum = new int[N+1];
        for(int i=1; i<=N; i++) {
            arrSum[i] = arrSum[i-1]+Integer.parseInt(st.nextToken());
        }
        for(int x=0; x<M; x++) {
            // 단순히 더하기만 하면 O(n^2)의 시간복잡도가 소요되기 때문에, 입력받을때 미리 구간합을 받아서 저장한다
            String[] section = br.readLine().split(" ");
            int i = Integer.parseInt(section[0]);
            int j = Integer.parseInt(section[1]);
            int sum = arrSum[j]-arrSum[i-1];
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
