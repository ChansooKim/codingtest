package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* 그래프, BFS(큐) 문제 */
public class BJ_7576 {
    static int N;
    static int M;
    static int[][] arr;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Queue<tomato> queue = new LinkedList<>();
    static class tomato{
        int x;
        int y;
        int day;

        public tomato(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);
        StringTokenizer st;
        arr = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1) {
                    queue.offer(new tomato(i, j, 0));
                }
            }
        }

        int day = bfs();
        System.out.println(day);
    }

    static int bfs() {
        int day = 0;
        while(!queue.isEmpty()) {
            tomato t = queue.poll();
            day = t.day;

            for(int i=0; i<4; i++) {
                int nx = t.x + dx[i];
                int ny = t.y + dy[i];

                if(0<=nx && nx<N && 0<=ny && ny<M) {
                    if(arr[nx][ny]==0) {
                        arr[nx][ny] = 1;
                        queue.add(new tomato(nx, ny, day+1));
                    }
                }
            }
        }
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(arr[i][j] == 0) {
                    return -1;
                }
            }
        }
        return day;
    }
}