package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_2606 {
    static int node, line;
    static boolean[] isVisited;
    static int[][] arr;
    static int cnt = 0;
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        node = Integer.parseInt(br.readLine());
        line = Integer.parseInt(br.readLine());
        isVisited = new boolean[node+1];
        arr = new int[node+1][node+1];
        for(int i=0; i<line; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = arr[b][a] = 1;
        }
        BFS(1);
        System.out.println(cnt);
    }

    static void BFS(int start) {
        q.offer(start);
        isVisited[start] = true;
        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int i=1; i<=node; i++) {
                if(arr[cur][i] == 1 && !isVisited[i]) {
                    q.offer(i);
                    isVisited[i] = true;
                    cnt++;
                }
            }
        }
    }
}
