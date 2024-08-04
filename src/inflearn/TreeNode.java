package inflearn;

/**
 * packageName    : inflearn
 * fileName       : TreeNode
 * author         : KimChansoo
 * date           : 24. 8. 4.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 8. 4.       KimChansoo       최초 생성
 */
class eNode{
    int data;
    eNode lt;
    eNode rt;
    public eNode(int n){
        data = n;
        lt = rt = null;
    }
}

/**
 * 5. 이진트리순회(DFS : Depth-First Search)
 * 시작은 무조건 루트부터 깊이 탐색
 * 전위순회: 부 - 왼 - 오  1 2 4 5 3 6 7
 * 중위순회: 왼 - 부 - 오  4 2 5 1 6 3 7
 * 후위순회: 왼 - 오 - 부  4 5 2 6 7 3 1
 */
public class TreeNode{
    public void DFS(eNode root){
        if(root == null)
            return;
        else{
            // POINT 순서에 따라 전위, 중위, 후위가 나눠진다
            // 1. 전위순회
            System.out.print(root.data + " ");
            DFS(root.lt);
            DFS(root.rt);

            // 2. 중위순회
            DFS(root.lt);
            System.out.print(root.data + " ");
            DFS(root.rt);

            // 3. 후위순회
            DFS(root.lt);
            DFS(root.rt);
            System.out.print(root.data + " ");
        }
    }
    public static void main(String[] args){
        TreeNode t = new TreeNode();
        eNode root = new eNode(1);
        root.lt = new eNode(2);
        root.rt = new eNode(3);
        root.lt.lt = new eNode(4);
        root.lt.rt = new eNode(5);
        root.rt.lt = new eNode(6);
        root.rt.rt = new eNode(7);
        t.DFS(root);
    }
}