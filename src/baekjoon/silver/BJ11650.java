package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for(int i=0; i<n; i++) {
            String[] input = br.readLine().split(" ");
            for(int j=0; j<2; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }
        Arrays.sort(arr, (arr1, arr2)->{
            if(arr1[0] == arr2[0]) {
                return arr1[1] - arr2[1];
            } else {
                return arr1[0] - arr2[0];
            }
        });
        // ** 아래의 경우 시간복잡도가 O(n^2)이기때문에, 시간초과가 발생하여 시간복잡도가 O(nlog(n))인 Arrays.sort()를 사용한다 **
        //    Arrays.sort()는 최악의 경우 O(n^2)이 될 수 있어, 이보다 더 빠른 시간복잡도를 가져가려면
        //    최악의 경우에도 O(nlog(n))을 가지는 Collections.sort()를 사용한다
        /*for(int i=0; i<n; i++) {
            int[] tmp = arr[i];
            int x = tmp[0];
            int y = tmp[1];
            for(int j=i+1; j<n; j++) {
                int[] tmp2 = arr[j];
                int x2 = tmp2[0];
                int y2 = tmp2[1];
                if(x > x2 || x == x2 && y > y2) {
                    arr[i][0] = x2;
                    arr[i][1] = y2;
                    arr[j][0] = x;
                    arr[j][1] = y;
                    x = arr[i][0];
                    y = arr[i][1];
                }
            }
        }*/
        for(int[] x : arr) System.out.println(x[0]+" "+x[1]);
        br.close();
    }
}
