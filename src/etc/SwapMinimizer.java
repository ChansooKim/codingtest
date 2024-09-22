package etc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SwapMinimizer {

    // 각 상태를 담는 클래스
    static class State {
        int[] numbers;
        int swaps;

        State(int[] numbers, int swaps) {
            this.numbers = numbers.clone();  // 배열 복사
            this.swaps = swaps;
        }
    }

    public static int solution(int[] numbers, int k) {
        int n = numbers.length;

        // BFS로 최소 swap 횟수 탐색
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(numbers, 0));  // 초기 상태

        // 방문한 상태를 기록 (배열 상태를 문자열로 변환하여 중복 체크)
        Set<String> visited = new HashSet<>();
        visited.add(Arrays.toString(numbers));

        while (!queue.isEmpty()) {
            State current = queue.poll();
            int[] arr = current.numbers;

            // 현재 배열 상태가 인접한 원소들의 차이가 모두 k 이하인지 체크
            if (isValid(arr, k)) {
                return current.swaps;
            }

            // 배열의 각 인덱스를 돌며 두 원소를 swap하여 상태를 새로 탐색
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    // 두 원소를 swap
                    swap(arr, i, j);
                    String arrString = Arrays.toString(arr);

                    // 새로운 상태가 아직 방문되지 않았다면 큐에 추가
                    if (!visited.contains(arrString)) {
                        queue.add(new State(arr, current.swaps + 1));
                        visited.add(arrString);
                    }

                    // 다시 swap하여 원래대로 복원
                    swap(arr, i, j);
                }
            }
        }

        // 가능한 방법이 없는 경우
        return -1;
    }

    // 배열 상태가 유효한지 체크 (인접한 원소들의 차이가 모두 k 이하인지)
    private static boolean isValid(int[] arr, int k) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (Math.abs(arr[i] - arr[i + 1]) > k) {
                return false;
            }
        }
        return true;
    }

    // 두 원소의 위치를 바꿈
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        // 예시 입력
        int[] numbers1 = {10, 40, 30, 20};
        int k1 = 20;
        System.out.println(solution(numbers1, k1));  // 출력: 1

        int[] numbers2 = {3, 7, 2, 8, 6, 4, 5, 1};
        int k2 = 3;
        System.out.println(solution(numbers2, k2));  // 출력: 2
    }
}