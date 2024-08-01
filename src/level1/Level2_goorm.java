package level1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * packageName    : level1
 * fileName       : Level2_goorm
 * author         : KimChansoo
 * date           : 24. 8. 1.
 * description    : Goorm_Level2
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 8. 1.       KimChansoo       최초 생성
 */
public class Level2_goorm {

    /**
     * <a href="https://level.goorm.io/exam/174909/m%EB%B0%B0-%EB%B0%B0%EC%97%B4/quiz/1">M배 배열</a>
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String input2 = br.readLine();
        // System.out.println(input);
        // System.out.println(input2);
        // N개의 요소 배열 A = [1,2,3..N]  배열의 i번째 수
        // M배 배열이란, 정수 배열 A의 모든 요소가 M으로 나누어 떨어지는 것
        // M으로 나누어지지 않으면 M을 곱하고, 나누어지면 그대로 두게 해서 만듦

        // 7 3
        String[] source = input.split(" ");
        int n = Integer.parseInt(source[0]);
        int m = Integer.parseInt(source[1]);

        // 1 2 3 4 5 6 7
        String[] numArr = input2.split(" ");

        for(String numStr : numArr) {
            int num = Integer.parseInt(numStr);
            if(num % m != 0) {
                System.out.print(num * m);
            } else {
                System.out.print(num);
            }
            System.out.print(" ");
        }
    }



}
