package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 동적계획법(Dynamic Programming) 문제 */
public class BJ_2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[][] arr = new int[15][15];
        for(int i=0; i<15; i++) {
            arr[i][1] = 1;
            arr[0][i] = i;
        }
        for(int i=1; i<15; i++) {
            for(int j=2; j<15; j++) {
                arr[i][j] = arr[i][j-1] + arr[i-1][j];
            }
        }
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            sb.append(arr[k][n]).append("\n");
        }
        System.out.println(sb);
    }
}
