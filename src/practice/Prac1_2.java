package practice;

import java.util.Scanner;

public class Prac1_2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n;
        do{
            System.out.println("Enter number: ");
            n = sc.nextInt();
        } while(n <= 0);

//        whileLoop(sc.nextInt());
        forLoop(n);
    }

    static void whileLoop(int n) {
        int sum = 0;
        int i = 1;

        while (i <= n) {
            sum += i;
            i++;
        }
        System.out.println("1부터 "+n+" 까지의 합은 "+sum+" 입니다.");
    }

    static void forLoop(int n) {
        int sum = 0;
        for(int i = 1; i <= n; i++) {
            sum += i;
        }
        System.out.println("1부터 "+n+" 까지의 합은 "+sum+" 입니다.");
    }
}
