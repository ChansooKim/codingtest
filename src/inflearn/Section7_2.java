package inflearn;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * packageName    : inflearn
 * fileName       : Section7_2
 * author         : KimChansoo
 * date           : 24. 9. 3.
 * description    : 자바 알고리즘 문제풀이 입문 : Recursive, Tree, Graph(DFS, BFS 기초)
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 9. 3.       KimChansoo       최초 생성
 */
public class Section7_2 {

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
    public static void doDfs(String[] args) {
        Section7_2 T = new Section7_2();
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
