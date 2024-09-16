package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/* Stack 문제 */
public class BJ_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            String input = br.readLine();
            sb.append(checkPS(input)).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static String checkPS(String str) {
        String bool = "YES";
        Stack<Character> stack = new Stack<>();
        char[] chArr = str.toCharArray();
        for(int i=0; i<chArr.length; i++) {
            if(chArr[i] == '(') {
                stack.push(chArr[i]);
            } else {
                if(stack.isEmpty()) {
                    return "NO";
                } else {
                    stack.pop();
                }
            }
        }
        if(!stack.isEmpty()) bool = "NO";
        return bool;
    }
}
