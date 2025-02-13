package types;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 이진 탐색(Binary Search):
 *  정렬된 배열에서만 사용 가능. 중간값과 비교하며 절반씩 범위를 줄여가는 방식
 *
 * 시간복잡도: O(log N) (빠름)
 */
class BinarySearch {
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1; // 못 찾은 경우
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(binarySearch(arr, 4)); // 3 출력 (index)
    }
}


/**
 * DFS (깊이 우선 탐색):
 *  갈 수 있는 한 깊이까지 들어가고, 더 이상 못 가면 되돌아옴(백트래킹)
 *
 * 스택(Stack)이나 재귀(Recursive)로 구현
 */
class DFS {
    static boolean[] visited;
    static ArrayList<Integer>[] graph;

    public static void dfs(int node) {
        visited[node] = true;
        System.out.print(node + " ");
        for (int next : graph[node]) {
            if (!visited[next]) dfs(next);
        }
    }

    public static void main(String[] args) {
        graph = new ArrayList[5];
        for (int i = 0; i < 5; i++) graph[i] = new ArrayList<>();

        graph[0].add(1); graph[0].add(2);
        graph[1].add(3); graph[2].add(4);

        visited = new boolean[5];
        dfs(0);  // 0 1 3 2 4 출력
    }
}

/**
 * BFS (너비 우선 탐색):
 *  가까운 것부터 탐색하는 방식
 *
 *  큐(Queue) 사용
 */
class BFS {
    static boolean[] visited;
    static ArrayList<Integer>[] graph;

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");
            for (int next : graph[node]) {
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        graph = new ArrayList[5];
        for (int i = 0; i < 5; i++) graph[i] = new ArrayList<>();

        graph[0].add(1); graph[0].add(2);
        graph[1].add(3); graph[2].add(4);

        visited = new boolean[5];
        bfs(0);  // 0 1 2 3 4 출력
    }
}


/**
 * 그리디 알고리즘 (Greedy Algorithm)
 *  매 순간 최적이라고 생각되는 것을 선택해 나가는 방법
 *
 * 예시 문제: 동전 최소 개수 구하기, 회의실 배정 문제 등
 */
class Greedy {
    public static void main(String[] args) {
        int[] coins = {500, 100, 50, 10};
        int target = 1260;
        int count = 0;

        for (int coin : coins) {
            count += target / coin;
            target %= coin;
        }
        System.out.println(count);  // 6 출력
    }
}


/**
 * 동적 프로그래밍 (DP)
 *  작은 문제를 해결하고, 그 결과를 메모이제이션하여 큰 문제를 해결
 *
 * 대표 문제: 피보나치 수열
 */
class DP {
    static int[] dp = new int[100];

    public static int fibonacci(int n) {
        if (n <= 1) return n;
        if (dp[n] != 0) return dp[n];
        dp[n] = fibonacci(n - 1) + fibonacci(n - 2);
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(10));  // 55 출력
    }
}

