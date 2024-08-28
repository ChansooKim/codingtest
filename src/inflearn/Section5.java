package inflearn;

import java.util.*;

/**
 * packageName    : inflearn
 * fileName       : Section5
 * author         : KimChansoo
 * date           : 24. 8. 4.
 * description    : 자바 알고리즘 문제풀이 입문 : Stack, Queue(자료구조)
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 8. 4.       KimChansoo       최초 생성
 */
public class Section5 {

    /**
     * 1. 올바른 괄호(Stack)
     * TODO 괄호는 Stack의 유명한 문제
     */
    public static void question5_1Solve(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        // (()(()))(()
        String isRight = "YES";
        Stack stack = new Stack();
        char[] arr = str.toCharArray();
        for(int i=0; i<str.length(); i++) {
            if(arr[i] == '(') {
                stack.push(arr[i]);
            } else {
                if(stack.isEmpty()) {
                    isRight = "NO";
                    break;
                } else {
                    stack.pop();
                }
            }
        }
        if(!stack.isEmpty()) {      // POINT 다 끝난 시점에 다시 한번 검사
            isRight = "NO";
        }
        System.out.println(isRight);
    }


    public static void question5_1Answer(String[] args) {
        Scanner sc = new Scanner(System.in);
        // (()(()))(()
        String str = sc.next();
        // POINT 여는 괄호'(' 를 만나면 Stack에 담고, 닫는 괄호 ')'를 만나면 Stack에서 꺼낸다
        //  닫는 괄호를 만났는데, Stack이 비어있으면 잘못된 문장

        String answer = "YES";
        Stack<Character> stack = new Stack<>();
        for(char x : str.toCharArray()) {
            if(x == '(') {
                stack.push(x);
            } else {
                if(stack.isEmpty()) {
                    return;
                } else {
                    stack.pop();
                }
            }
        }
        System.out.println(answer);
    }


    /**
     * 2. 괄호문자제거
     */
    public static void question5_2Solve(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        Stack<Character> stack = new Stack<>();
        String answer = "";
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == ')') {
                stack.push(s.charAt(i));
                while(stack.pop() != '(') {
                    // POINT stack.pop()은 최상단의 stack을 제거하면서 출력한다
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        for(char x : stack) {
            answer += x;
        }
        System.out.println(answer);
    }


    public static void question5_2Answer(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        String answer = "";
        Stack<Character> stack = new Stack<>();
        for(char x : str.toCharArray()) {
            if(x == ')') {
                // Stack에 담긴 값이 '('일 때 까지
                while(stack.pop() != '(');
            } else {
                stack.push(x);
            }
        }
        for(int i=0; i<stack.size(); i++) {
            answer += stack.get(i);
        }
        System.out.println(answer);
    }


    /**
     * 3. 크레인 인형뽑기(카카오)
     */
    public static void question5_3Solve(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int m = sc.nextInt();
        int[] moves = new int[m];
        for(int i=0; i<m; i++) {
            moves[i] = sc.nextInt();
        }
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<moves.length; i++) {
            // 1 5 3 5 1 2 1 4
            int x = moves[i];
            for(int j=0; j<n; j++) {
                int tmp = arr[j][x-1];
                arr[j][x-1] = 0;    // 뽑은 인형은 0으로 초기화
                if(tmp != 0) {
                    if(!stack.isEmpty() && tmp == stack.peek()) {
                        answer+=2;
                        stack.pop();
                    } else {
                        stack.push(tmp);
                    }
                    break;
                }
            }
        }
        // 4 3 1 1 3 2 4
        /*int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<stack.size(); i++) {
            map.put(stack.get(i), map.getOrDefault(stack.get(i), 0)+1);
        }
        for(int x : map.keySet()) {
            if(map.get(x) > 1) {
                answer+=map.get(x);
            }
        }*/
        /*int answer = 0;
        int last = 0;
        while(!stack.isEmpty()) {
            int pop = stack.pop();
            if(pop == last) {
                answer++;
            }
            last = pop;
        }*/

        System.out.println(answer);
    }


    public static void question5_3Answer(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] board = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        int m = sc.nextInt();
        int[] moves = new int[m];
        for(int i=0; i<m; i++) {
            moves[i] = sc.nextInt();
        }

        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int pos : moves) {
            for(int i=0; i<board.length; i++) {     // POINT 2차원 배열의 열 크기는 board[0].length
                if(board[i][pos-1] != 0) {
                    int tmp = board[i][pos-1];
                    board[i][pos-1] = 0;        // 꺼낸 인형은 '0'(없어짐)
                    if(!stack.isEmpty() && tmp == stack.peek()) {      // 바구니에 인형이 있을때만 비교
                        answer+=2;
                        stack.pop();
                    } else {
                        stack.push(tmp);
                    }
                    break;
                }
            }
        }

        System.out.println(answer);
    }


    /**
     * 6. 공주구하기(Queue)
     * TODO 다시 풀어보기
     */
    public static void question5_6Solve(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   // 왕자의 수
        int k = sc.nextInt();   // 외칠 특정 숫자

        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=n; i++) {
            queue.offer(i);
        }
        while(!queue.isEmpty()) {
            for(int i=1; i<k; i++) {    // k가 3인 경우, 1과 2를 offer() 하고 3은 poll()함
                queue.offer(queue.poll());
            }
            queue.poll();
            if(queue.size() == 1) {
                answer = queue.poll();
            }
        }
        System.out.println(answer);
    }


    public static void question5_6Answer(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   // 왕자의 수
        int k = sc.nextInt();   // 외칠 특정 숫자
        // POINT 왕자를 1 ~ 8까지 넣어주고, 3번째마다 제외(삭제)된다

        int answer = 0;
        Queue<Integer> Q = new LinkedList<>();  // POINT Queue는 LinkedList<>()로 선언
        for(int i=1; i<=n; i++) {
            Q.offer(i);     // 큐에 값 삽입
        }
        while(!Q.isEmpty()) {   // 큐가 비면 멈춤
            for(int i=1; i<k; i++) {
                Q.offer(Q.poll());  // POINT 꺼낸 값을 다시 큐에 넣어줌
            }
            Q.poll();
            if(Q.size() == 1) {
                answer = Q.poll();  // 큐가 비면 while문이 멈춤
            }
        }
        System.out.println(answer);
    }
    
}
