package goorm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

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
    public static void ChangeCase(String[] args) throws Exception {
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
    public static void aPlusbTwo(String[] args) throws Exception {
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
    public static void confusingPole(String[] args) throws Exception {
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
    public static void goormHobby(String[] args) throws Exception {
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

    /**
     * 369 게임
     */
    public static void game369(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        // 입력 10 출력 3 / 입력 35 출력 15

        int count = Integer.parseInt(input);
        int clapCnt = 0;
        for(int i = 1; i < count; i++) {
            // 게임이 끝나기 전까지 반복
            String word = String.valueOf(i);
            for(int j = 0; j < word.length(); j++) {
                // 숫자 33, 66의 경우 박수를 2번 쳐야함
                if(word.charAt(j) == '3' || word.charAt(j) == '6' || word.charAt(j) == '9') {
                    clapCnt++;
                }
            }
        }
        System.out.println(clapCnt);
    }


    /**
     * <a href="https://level.goorm.io/exam/43068/1a-%EC%9D%B8%EA%B3%B5%EC%A7%80%EB%8A%A5-%EC%B2%AD%EC%86%8C%EA%B8%B0/quiz/1">인공지능 청소기</a>
     */
    public static void aiVacuumCleaner(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트케이스 수
        int T = Integer.parseInt(br.readLine());

        // 출력의 수
        String[] output = new String[T];
        for(int i=0; i<T; i++) {
            String caseTxt = br.readLine();
            String[] caseArr = caseTxt.split(" ");

            int X = Integer.parseInt(caseArr[0]);
            int Y = Integer.parseInt(caseArr[1]);
            int N = Integer.parseInt(caseArr[2]);

            // 맨허튼 거리가 (p1,p2) 와(q1,q2) 사이면 맨허튼 거리 = ∣p1−q1∣+∣p2−q2∣ 이다.
            int distance = Math.abs(X) + Math.abs(Y);   // 절대값
            if(distance <= N && (N-distance)%2 == 0) {
                /*
                 * 이미 청소했던 길을 다시 돌아갈 수 있기 때문에
                 * 위치에 이동을 완료하면 남는 시간동안 갔던 곳을 다시 왔다가 돌아와야해서
                 * 남은 값이 짝수여야 한다.
                 */
                output[i] = "YES";
            } else {
                output[i] = "NO";
            }
        }

        for(String txt : output) {
            System.out.println(txt);
        }
    }


    /**
     * <a href="https://level.goorm.io/exam/195683/%EC%9A%B4%EB%8F%99-%EC%A4%91%EB%8F%85-%ED%94%8C%EB%A0%88%EC%9D%B4%EC%96%B4/quiz/1">운동 중독 플레이어</a>
     */
    public static void exerciseAddictedPlayer(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        float W = Long.parseLong(st.nextToken());    // 무게
        float R = Long.parseLong(st.nextToken());    // 반복횟수

        float RM = W * (1+R/30);
        System.out.println((int)RM);
    }


    /**
     * <a href="https://level.goorm.io/exam/49086/%EC%A0%95%EC%82%AC%EA%B0%81%ED%98%95%EC%9D%98-%EA%B0%9C%EC%88%98/quiz/1">정사각형의 개수</a>
     */
    public static void numberOfSquares(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        // 입력 예제 "1000000"을 충족시키려면, Long 말고 BigDecimal을 사용해야함
        BigInteger sum = BigInteger.ZERO;
        for(long i=1; i<=N; i++) {
            sum = sum.add(BigInteger.valueOf(i).multiply(BigInteger.valueOf(i)));
        }
        System.out.println(sum);
    }


    /**
     * <a href="https://level.goorm.io/exam/49088/%EC%9D%98%EC%A2%8B%EC%9D%80-%ED%98%95%EC%A0%9C/quiz/1">의좋은 형제</a>
     */
    public static void goodBrother(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String[] nArr = input.split(" ");

        double N1 = Integer.parseInt(nArr[0]);
        double N2 = Integer.parseInt(nArr[1]);

        int D = Integer.parseInt(br.readLine());
        for(int i=0; i<D; i++) {
            if(i%2==1) {	// 홀수
                N1 = N1 + Math.ceil(N2/2);  // 식량의 양이 홀수라서 반으로 나눌 수 없는 경우, 통째로 넘겨줘야해서 올림 (Math.ceil())
                N2 = N2 - Math.ceil(N2/2);
            } else if(i%2==0) {	// 짝수
                N2 = N2 + Math.ceil(N1/2);
                N1 = N1 - Math.ceil(N1/2);
            }
        }

        System.out.printf("%d %d", (int) N1, (int) N2);
    }


    /**
     * <a href="https://level.goorm.io/exam/242356/%EB%B3%84-%EC%B0%8D%EA%B8%B0-1/quiz/1">별 찍기(1)</a>
     */
    public static void choppingStar1(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++) {
            for(int j=0; j<=i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }


    /**
     * <a href="https://level.goorm.io/exam/242374/%EB%B3%84-%EC%B0%8D%EA%B8%B0-2/quiz/1">별 찍기(2)</a>
     */
    public static void choppingStar2(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            for(int j=N; j>i; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }


    /**
     * <a href="https://level.goorm.io/exam/171192/%EC%A0%88%EC%95%BD/quiz/1">절약</a>
     */
    public static void saving(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // v는 최대 100,000 * 1,000,000 만큼 늘어날 수 있어서 Long 자료형 사용
        long[] cArr = new long[2];
        boolean isFail = false;
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String c = st.nextToken();
            long v = Long.parseLong(st.nextToken());

            if("in".equals(c)) {
                cArr[0] += v;
            } else {
                cArr[1] += v;
            }

            // 지출해야 할 돈이 현재 가지고 있는 돈보다 크면, 이후 수입과 상관없이 실패로 처리
            if("out".equals(c) && cArr[0] <= v) {
                isFail = true;
                break;
            }
        }

        if(cArr[0] - cArr[1] >= 0) {
            System.out.println("success");
        } else if(isFail) {
            System.out.println("fail");
        } else {
            System.out.println("fail");
        }
    }


    /**
     * <a href="https://level.goorm.io/exam/47883/%EB%8B%A8%EC%96%B4%EC%9D%98-%EA%B0%9C%EC%88%98-%EC%84%B8%EA%B8%B0/quiz/1">단어의 개수 세기</a>
     */
    public static void countingWords(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        input = input.trim();	// 앞 뒤 공백제거
        if(input.isEmpty()) {
            System.out.println(0);
        } else {
            // 한 개 이상의 공백을 한 개의 공백으로 변경
            input = input.replaceAll("\\s+", " ");

            String[] arr = input.split(" ");
            System.out.println(arr.length);
        }
    }


    /**
     * <a href="https://level.goorm.io/exam/242429/%EA%BD%83-%EC%84%A0%EB%AC%BC%ED%95%98%EA%B8%B0/quiz/1">꽃 선물하기</a>
     */
    public static void giftFlowers(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());	// 선물할 사람

        String[] output = new String[N];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(a < b) output[i] = "Sunflower";
            else if(a == b) output[i] = "Tulip";
            else output[i] = "Rose";
        }

        for(String print : output) {
            System.out.println(print);
        }
    }

}