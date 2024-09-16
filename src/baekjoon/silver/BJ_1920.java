package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 이진탐색 문제 */
public class BJ_1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[n];
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if(binarySearch(arr, tmp)>=0) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static int binarySearch(int[] arr, int val) {
        int lt = 0;
        int rt = arr.length-1;
        while(lt <= rt) {
            int mid = (lt+rt)/2;
            if(val < arr[mid]) {
                rt = mid-1;
            } else if(val > arr[mid]) {
                lt = mid+1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /* Arrays.binarySearch(int[] arr, int key) API 사용 */
    public static void main2(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[n];
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if(Arrays.binarySearch(arr, tmp)>=0) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }
        System.out.println(sb);
    }
}
