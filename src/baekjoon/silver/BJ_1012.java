package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/* 그래프탐색 문제 */
class xy{
    int x;
    int y;
    public xy(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class BJ_1012 {
    static boolean[][] arr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while(T-- >0) {
            String[] input = br.readLine().split(" ");
            int M = Integer.parseInt(input[0]);     // 가로
            int N = Integer.parseInt(input[1]);     // 세로
            int K = Integer.parseInt(input[2]);     // 배추 위치의 갯수
            arr = new boolean[N][M];
            for(int i=0; i<K; i++) {
                String[] inputs = br.readLine().split(" ");
                int X = Integer.parseInt(inputs[0]);
                int Y = Integer.parseInt(inputs[1]);
                arr[Y][X] = true;
            }
            int cnt = 0;
            for(int i=0; i<arr.length; i++) {
                for(int j=0; j<arr[0].length; j++) {
                    if(arr[i][j]) {
                        searchBFS(i, j, M, N);
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    static void searchBFS(int i, int j, int M, int N) {
        Stack<xy> stack = new Stack<>();
        stack.push(new xy(i, j));
        while(!stack.isEmpty()) {
            xy s = stack.pop();
            for(int x = 0; x <4; x++) {
                int nx = s.x+dx[x];
                int ny = s.y+dy[x];
                if(0<=nx && nx<N && ny>=0 && ny<M) {
                    if(arr[nx][ny]) {
                        arr[nx][ny] = false;
                        stack.push(new xy(nx, ny));
                    }
                }
            }
        }
    }
}
