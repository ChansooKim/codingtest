package inflearn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

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
