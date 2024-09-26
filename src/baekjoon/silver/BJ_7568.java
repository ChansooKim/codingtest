package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 브루트포스 문제 */
public class BJ_7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        int[] scores = new int[N];
        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            arr[i][0] = x;
            arr[i][1] = p;
        }
        for(int i=0; i<arr.length; i++) {
            int x = arr[i][0];
            int p = arr[i][1];
            int score = 1;
            for(int j=0; j<arr.length; j++) {
                if(i!=j) {
                    int tmpX = arr[j][0];
                    int tmpP = arr[j][1];
                    // 비교군의 값이 더 크면 등수+1
                    if(x < tmpX && p < tmpP) {
                        score++;
                    }
                }
            }
            scores[i] = score;
        }
        for(int x : scores) System.out.print(x+" ");
    }
}
