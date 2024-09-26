package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/* 우선순위큐 사용 문제 */
public class BJ_1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        // 우선순위 큐는 기본적으로 queue에 들어갈 때 오름차순으로 입력됨
        for(int i=0; i<N; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x>0) {
                queue.offer(x);
            } else {
                if(queue.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(queue.poll()).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
