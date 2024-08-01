package practice;

import java.util.Scanner;

public class Prac1_3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("+와 -를 번갈아 n개 출력합니다.");

        n = sc.nextInt();

        // 어짜피 번갈아 출력되니까, 짝수번 횟수만큼 출력
        /*for(int i = 0; i < n/2; i++) {
            System.out.print("+-");
        }*/

        for(int i = 1; i <= n/2; i++) {
            System.out.print("+-");
        }

        // 짝수가 아니면 홀수일때 출력하는 + 한번 출력
        if(n % 2 != 0) {
            System.out.print("+");
        }


    }
}
