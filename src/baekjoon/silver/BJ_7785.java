package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* HashMap vs ArrayList 시간복잡도 */
public class BJ_7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, String> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            String[] input = br.readLine().split(" ");
            String name = input[0];
            String status = input[1];
            if(map.containsKey(name)) {
                map.remove(name);       // POINT Map.containsKey(), Map.put(K, V), Map.remove()는 O(1)의 시간복잡도를 가진다
            } else {
                map.put(name, status);
            }
        }
        List<String> list = new ArrayList<>(map.keySet());
        list.sort(Collections.reverseOrder());  // POINT 리스트의 정렬은 O(nlog(n))의 시간복잡도를 가진다
        for(String x : list) System.out.println(x);
    }

    /* 시간 초과 코드 */
    public static void main2(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            String[] input = br.readLine().split(" ");
            String name = input[0];
            String status = input[1];
            if("enter".equals(status)) {
                list.add(name);
            } else {
                // POINT list.add()는 시간복잡도 O(1)이지만, list.remove()는 시간복잡도 O(n)을 가진다 (삭제 후, 뒤의 원소들을 한 칸씩 당겨야 하므로)
                list.remove(name);
            }
        }
        list.sort(Collections.reverseOrder());  // POINT 리스트의 정렬은 O(nlog(n))의 시간복잡도를 가진다

        for(String x : list) sb.append(x).append("\n");
        System.out.println(sb);
    }
}
