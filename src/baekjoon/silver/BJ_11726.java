package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* DP 점화식 문제 */
public class BJ_11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[1001];
        arr[1] = 1;
        arr[2] = 2;
        /*arr[3] = 3;
        arr[4] = 5;
        arr[5] = 8;
        arr[6] = 13;
        arr[7] = 21;
        arr[8] = 34;
        arr[9] = 55;*/
        for(int i=3; i<=n; i++) {
            arr[i] = (arr[i-1] + arr[i-2])%10007;
        }
        System.out.println(arr[n]);
    }
}
