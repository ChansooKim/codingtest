package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* Queue 문제(요세푸스 순열) */
public class BJ_11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        List<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=n; i++) {
            queue.offer(i);
        }
        while(!queue.isEmpty()) {
            for(int i=0; i<k-1; i++) {
                queue.offer(queue.poll());
            }
            list.add(queue.poll());
        }
        sb.append("<");
        for(int i=0; i<list.size(); i++) {
            sb.append(list.get(i));
            if(i != list.size()-1) {
                sb.append(", ");
            }
        }
        sb.append(">");
        System.out.println(sb);
    }
}
