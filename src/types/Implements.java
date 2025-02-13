package types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 문자열 처리 (String Manipulation)
 * 유형 예시: 문자열 뒤집기, 특정 문자 개수 세기, 문자열 압축, 정규표현식 활용
 * 자주 사용 메서드: `charAt(), substring(), split(), replace(), toCharArray()`
 * 예시 문제: 문자열에서 가장 많이 등장한 문자 찾기
 */
class MostFrequentChar {
    public static void main(String[] args) {
        String str = "hello world";
        Map<Character, Integer> map = new HashMap<>();

        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        char maxChar = ' ';
        int maxCount = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxChar = entry.getKey();
                maxCount = entry.getValue();
            }
        }
        System.out.println("가장 많이 등장한 문자: " + maxChar + " (" + maxCount + ")");
    }
}

/**
 * 시뮬레이션 (Simulation)
 * 유형 예시: 2차원 배열에서 이동(상하좌우), 주사위 굴리기, 게임 구현
 *  Tip: 방향 벡터 dx, dy를 사용하면 구현이 훨씬 깔끔해짐.
 * 예시 문제: N×N 격자에서 주어진 명령어(위, 아래, 왼쪽, 오른쪽) 수행
 */
class MoveSimulation {
    public static void main(String[] args) {
        int N = 5;
        int x = 1, y = 1;
        String[] commands = {"R", "R", "U", "L", "D"};

        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        String[] directions = {"R", "L", "U", "D"};

        for (String cmd : commands) {
            for (int i = 0; i < 4; i++) {
                if (cmd.equals(directions[i])) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (nx >= 1 && ny >= 1 && nx <= N && ny <= N) {
                        x = nx; y = ny;
                    }
                }
            }
        }
        System.out.println("최종 위치: (" + x + ", " + y + ")");
    }
}

/**
 * 그리디 (Greedy)
 * 유형 예시: 잔돈 거스름돈 문제, 회의실 배정, 최대/최소값 만들기
 * 예시 문제: 동전 개수 최소화
 */
class CoinChange {
    public static void main(String[] args) {
        int[] coins = {500, 100, 50, 10};
        int amount = 1260, count = 0;

        for (int coin : coins) {
            count += amount / coin;
            amount %= coin;
        }
        System.out.println("최소 동전 개수: " + count);
    }
}

/**
 * 자료구조 활용 (Stack, Queue, Deque)
 * 유형 예시: 괄호 문자열 검사(스택), 프린터 큐, 카드 게임(큐)
 * 자주 쓰는 자료구조: Stack<E>, Queue<E>, Deque<E> (Java LinkedList로 Deque 사용 가능)
 * 예시 문제: 올바른 괄호 문자열인지 확인
 */
class ValidParentheses {
    public static void main(String[] args) {
        String s = "()()((()))";
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(c);
            else {
                if (stack.isEmpty()) {
                    System.out.println("올바르지 않음");
                    return;
                }
                stack.pop();
            }
        }
        System.out.println(stack.isEmpty() ? "올바름" : "올바르지 않음");
    }
}


/**
 * 완전 탐색 (Brute Force)
 * 유형 예시: N중 for문, 모든 경우의 수 탐색, 순열/조합
 * 예시 문제: 3개의 숫자를 골라 합이 가장 큰 경우 찾기
 */
class BruteForce {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int maxSum = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    maxSum = Math.max(maxSum, arr[i] + arr[j] + arr[k]);
                }
            }
        }
        System.out.println("최대 합: " + maxSum);
    }
}

/**
 * 백트래킹 (Backtracking)
 * 유형 예시: N-Queen 문제, 순열 생성, 특정 조건 만족하는 경로 찾기
 * 예시 문제: 1~N까지의 숫자로 M자리 순열 생성
 */
class Backtracking {
    static int N = 3, M = 2;
    static boolean[] visited = new boolean[N + 1];
    static ArrayList<Integer> result = new ArrayList<>();

    public static void backtrack(int depth) {
        if (depth == M) {
            System.out.println(result);
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result.add(i);
                backtrack(depth + 1);
                visited[i] = false;
                result.remove(result.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        backtrack(0);
    }
}
