package inflearn;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * packageName    : inflearn
 * fileName       : Section7
 * author         : KimChansoo
 * date           : 24. 8. 4.
 * description    : 자바 알고리즘 문제풀이 입문 : Recursive, Tree, Graph(DFS, BFS 기초)
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 8. 4.       KimChansoo       최초 생성
 */
public class Section7 {

    /**
     * 3. 팩토리얼
     * DFS
     */
    public static void question7_3Solve(String[] args) {
        Section7 T = new Section7();

        // 5! = 5*4*3*2*1 = 120
        System.out.println(T.factorial(5));
    }

    // POINT Stack을 생각하면 됨 (DFS(5) -> DFS(4) -> ... )
    // DFS
    public int factorial(int n) {
        if(n==1) return 1;
        else return n*factorial(n-1);     // 5 * (5-1) * (4-1) * (3-1) * (2-1) * 1
    }


    /**
     * 4. 피보나치 수열 (재귀 ver) [속도 상 for문 배열이 성능이 더 좋다]
     * 피보나치 수열 : 앞의 2개의 수를 합하여 다음 숫자가 되는 수열
     * DFS
     * @see Section2 question2_4Solve
     * POINT 코딩인터뷰에 자주 나온다고 함 (배열ver과 재귀ver으로 코딩해봐라)
     */
    public static void question7_4Answer(String[] args) {
        Section7 T = new Section7();
        int n = 10;
        System.out.println(T.fibonacci(n));
        /*for(int i=1; i<=n; i++) {
            System.out.print(T.fibonacci(i)+ " ");  // 1 1 2 3 5 8 13
        }*/
    }


    // POINT 이렇게 사용하면 속도가 너무 느려진다
    public int fibonacci(int n) {
        if(n == 1) return 1;
        else if(n == 2) return 1;
        else return fibonacci(n-2) + fibonacci(n-1);
    }

    /**
     * POINT 속도를 개선하기 위한 방법
     *  큰 숫자를 변수로 넣더라도 전 보다 속도가 빨라짐 (n = 45 기준 약 4,5초)
     */
    static int[] fibo;

    // fibo라는 배열에 저장을 하고 그 값을 리턴하는 형태
    public int fibonacci_fast(int n) {
        if(n == 1) return fibo[n]=1;
        else if(n == 2) return fibo[n]=1;
        else return fibo[n]=fibonacci_fast(n-2) + fibonacci_fast(n-1);    // POINT 재귀 계산 과정을 fibo에 기록한다
    }

    public static void question7_4Answer2(String[] args) {
        Section7 T = new Section7();
        int n = 45;
        fibo = new int[n+1];
        T.fibonacci_fast(n);
        for(int i=1; i<=n; i++) {
            System.out.print(fibo[i]+ " ");  // 1 1 2 3 5 8 13
        }
    }


    /**
     * POINT 메모이제이션을 사용하여 훨씬 더 빠른 속도로 개선 (n = 45 기준 약 1초)
     */
    public static void question7_4Answer3(String[] args) {
        Section7 T = new Section7();
        int n = 45;
        fibo = new int[n+1];
        T.fibonacci_fastest(n);
        for(int i=1; i<=n; i++) {
            System.out.print(fibo[i]+ " ");  // 1 1 2 3 5 8 13
        }
    }

    /**
     * POINT fibo 배열을 선언부에서 초기화하면 기본적으로 빈 배열은 '0'으로 들어가는데
     *  값이 '0'이 아니라면 이미 fibo에 값이 기록된 상태일 것
     */
    public int fibonacci_fastest(int n) {
        // POINT 재귀를 다시 실행하지 않고, 있는 값을 fibo에서 꺼내 사용한다.
        if(fibo[n] > 0) return fibo[n];

        if(n == 1) return fibo[n]=1;
        else if(n == 2) return fibo[n]=1;
        else return fibo[n]=fibonacci_fastest(n-2) + fibonacci_fastest(n-1);
    }


    /**
     * 5. 이진트리순회(DFS : Depth-First Search)
     * 시작은 무조건 루트부터 깊이 탐색
     * 전위순회: 부 - 왼 - 오  1 2 4 5 3 6 7
     * 중위순회: 왼 - 부 - 오  4 2 5 1 6 3 7
     * 후위순회: 왼 - 오 - 부  4 5 2 6 7 3 1
     * @see TreeNode
     */


    /**
     * 13. 경로탐색(인접리스트, ArrayList)
     *
     * 인접 리스트 (정점의 갯수가 많을 때 유리한 방법)
     * 1 -> 2, 3, 4
     * 2 -> 1, 3
     * 3 -> 4
     * 4 -> 2, 5
     * 5 -> null
     * 리스트에 있는 원소의 갯수만 살피면 됨
     */
    static int n, m, answer = 0;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch;
    public void DFS(int v) {
        if(v==n) answer++;
        else {
            for(int nv : graph.get(v)) {
                if(ch[nv] == 0) { // 방문 안했다면
                    ch[nv] = 1;
                    DFS(nv);
                    ch[nv] = 0;
                }
            }
        }
    }
    public static void main(String[] args) {
        Section7 T = new Section7();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        ch = new int[n+1];
        for(int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }
        ch[1] = 1;
        T.DFS(1);
        System.out.println(answer);
    }
}