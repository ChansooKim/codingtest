package level0;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * packageName    : level1
 * fileName       : Level1_goorm
 * author         : KimChansoo
 * date           : 24. 7. 31.
 * description    : Goorm_Level1
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 7. 31.       KimChansoo       최초 생성
 */
public class Level1_goorm {

    /**
     * <a href="https://level.goorm.io/exam/174732/%EB%8C%80%EC%86%8C%EB%AC%B8%EC%9E%90-%EB%B0%94%EA%BE%B8%EA%B8%B0/quiz/1">대소문자 바꾸기</a>
     */
    public static void p1(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String str = br.readLine();

        int len = Integer.parseInt(input);
        for(int i=0; i<len; i++) {
            char ch = str.charAt(i);
            if(Character.isUpperCase(ch)) {
                System.out.print(String.valueOf(ch).toLowerCase());
            } else if(Character.isLowerCase(ch)) {
                System.out.print(String.valueOf(ch).toUpperCase());
            }
        }
    }

    /**
     * <a href="https://level.goorm.io/exam/174704/a-b-2/quiz/1">A + B(2)</a>
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String[] strArr = input.split(" ");
        double word1 = Double.parseDouble(strArr[0]);
        double word2 = Double.parseDouble(strArr[1]);
        double sumWord = word1 + word2;

        // printf 사용
//        System.out.printf("%.6f%n", sumWord);
        System.out.printf("%.6f", sumWord);
    }

    /**
     * <a href="https://level.goorm.io/exam/47882/%ED%97%B7%EA%B0%88%EB%A6%AC%EB%8A%94-%EC%9E%91%EB%8C%80%EA%B8%B0/quiz/1">헷갈리는작대기</a>
     */
    public static void q1(String[] args) throws Exception {
        /**
         * We wi1l we wi|I rock you!
         * xl30gjdhaI1gdfkl|dlh;(rn4ky1kgndlIIldfl|ld|dBjfHd
         * ~]I=-f{UX5%X<]`kQl8?O^UDflq=2`;1LM7a/74([|8qAO<.CJY>i_'\n*A-q(QWFgBL+}RU(ZITZL:\0?FWb1+bUeP0/Y%"1IB\
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int cnt1 = 0, cnt2 = 0, cnt3 = 0, cnt4 = 0;
//        int cnt1 = 0;
//        int cnt2 = 0;
//        int cnt3 = 0;
//        int cnt4 = 0;
        for (int i = 0; i < input.length(); i++) {
            String ch = String.valueOf(input.charAt(i));
//            String ch = input.charAt(i)+"";
            switch (ch) {
                case "1":
                    cnt1++;
                    break;
                case "I":
                    cnt2++;
                    break;
                case "l":
                    cnt3++;
                    break;
                case "|":
                    cnt4++;
                    break;
            }
        }
        System.out.println(cnt1);
        System.out.println(cnt2);
        System.out.println(cnt3);
        System.out.println(cnt4);
    }

    /**
     * <a href="https://level.goorm.io/exam/49094/%EA%B5%AC%EB%A6%84%EC%9D%B4%EC%9D%98-%EC%B7%A8%EB%AF%B8/quiz/1">구름이의 취미</a>
     */
    public static void q2(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        /**
         * Input
         * 10
         * 37
         * 1000000000
         */

        long n = Long.parseLong(input);
        // if(inputVal > 1000000000) inputVal = 1000000000;
        // 정육면체 변의 갯수: 12
        // 부피는 x*y*z
        // 1변의 길이가 N인 정육면체의 부피는 N*N*N

        // (n*(n+1))/2)^2  -> 1^3 + 2^3 + 3^3 + ... + N^3 공식
        /*int totScale = 0;
        for(int i=1; i <= inputVal; i++) {
            int scale = i*i*i;
            totScale += scale;
        }*/
        long sum = (n * (n + 1) / 2) % 1000000007;
        long result = (sum * sum) % 1000000007;
        System.out.println((int) result);
    }
}