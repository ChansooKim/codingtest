package algorithm;

import java.util.LinkedList;
import java.util.Queue;

/**
 * packageName    : algorithm
 * fileName       : BreadthFirstSearch
 * author         : KimChansoo
 * date           : 24. 9. 6.
 * description    : 이진트리 레벨탐색 알고리즘
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 9. 6.       KimChansoo       최초 생성
 */
class Node{
    int data;
    Node lt, rt;
    public Node(int val) {
        data = val;
        lt=rt=null;
    }
}

public class BreadthFirstSearch {

    Node root;
    public void BFS(Node root) {
        Queue<Node> Q = new LinkedList<>();
        Q.offer(root);      // 루트노드에 root가 들어감
        int L = 0;

        // 큐가 빌 때 까지 반복
        while (!Q.isEmpty()) {
            int len = Q.size();
            System.out.print(L+"레벨: ");
            for(int i=0; i<len; i++) {
                Node cur = Q.poll();    // 현재 node를 꺼냄
                System.out.print(cur.data+" ");

                if(cur.lt != null) Q.offer(cur.lt);
                if(cur.rt != null) Q.offer(cur.rt);
            }
            L++;    // 레벨 증가
            System.out.println();
        }
    }

    public static void main(String[] args) {
        BreadthFirstSearch tree = new BreadthFirstSearch();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);

        tree.BFS(tree.root);
    }

}
