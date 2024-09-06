package level1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Stream;

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
    public static void mTimesArray(String[] args) throws Exception {
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


    /**
     * 3차원 배열
     */
    public static void array3D(String[] args) throws Exception{
        /**
         * 출력
         * 1 2 3   \n  10 11 12  \n  19 20 21
         * 4 5 6   \n  13 14 15  \n  22 23 24
         * 7 8 9   \n  16 17 18  \n  25 26 27
         */
        String[][][] trdArr = new String[3][3][3];
        int num = 1;

        for(int i = 0; i < trdArr.length; i++) {
            for(int j = 0; j < trdArr[i].length; j++) {
                for(int k = 0; k < trdArr[i][j].length; k++) {
                    System.out.print(num+" ");
                    num++;
                }
                System.out.println();
            }
            System.out.println();
        }
    }


    /**
     * <a href="https://level.goorm.io/exam/159545/0%EC%BB%A4%ED%94%8C/quiz/1">0커플</a>
     */
    public static void zeroCouple(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arrS = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arrS[i] = Integer.parseInt(st.nextToken());
        }

        // 중복된 점수가 없다고 했으니, Set을 사용
        Set<Integer> uniqueVal = new HashSet<>();
        int score = 0;

        for(int i=0; i<N; i++) {
            int x = arrS[i];
            int absX = Math.abs(x);

            if(!uniqueVal.contains(absX)) {
                score += x;
                uniqueVal.remove(x);
            }
        }

        // Timeout 오류 발생
        /*int score = 0;
        for(int i=0; i<N; i++) {
           int x = arrS[i];	// -1이고, 절댓값 1
           int cnt = 0;
           for(int j=0; j<N; j++) {
               int y = arrS[j];	// 비교하는 값
               if(x!=y && Math.abs(x) == Math.abs(y)) {	// 전체 배열의 절대값을 비교하되, 자기 자신은 비교하지 않음
                   cnt++;
               }
           }
           if(cnt == 0) {
               score+=x;
           }
        }*/
        System.out.println(score);
    }


    /**
     * <a href="https://level.goorm.io/exam/49060/%EA%B0%9C%EB%AF%B8-%EC%A7%91%ED%95%A9%EC%9D%98-%EC%A7%80%EB%A6%84/quiz/1">개미 집합의 지름</a>
     * <p>이진탐색</p>
     */
    public static void DiameterOfAntColony(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String[] arr = input.split(" ");
        int N = Integer.parseInt(arr[0]);	// 개미 수 6
        int D = Integer.parseInt(arr[1]);	// 지름   3

        /*int[] ants = new int[N];
        String[] arr2 = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            ants[i] = Integer.parseInt(arr2[i]);
        }*/
        int[] ants = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(ants);	// 개미 정렬

        // https://maicoding.tistory.com/95
        int begin = 0, end = 0;
        int maxAnts = 0;

        /* 이진탐색: 정렬된 데이터 집합을 이분화하며 탐색 */
        while(begin < N && end < N){
            int length = ants[end] - ants[begin];
            int numOfAnts = end - begin + 1;

            if(length <= D){
                if(maxAnts < numOfAnts){
                    maxAnts = numOfAnts;
                }
                end++;
            }else{
                begin++;
            }
        }

        System.out.println(N - maxAnts);
    }


    /**
     * <a href="https://level.goorm.io/exam/47880/%EB%B6%80%EB%B6%84-%ED%8C%B0%EB%A6%B0%EB%93%9C%EB%A1%AC-%EB%AC%B8%EC%9E%90%EC%97%B4/quiz/1">부분 팰린드롬 문자열</a>
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int len = input.length();

        int answer = 0;
        // POINT 모든 케이스를 검사하기 위해 2중 for문을 사용해아함
        for(int i=0; i<len; i++) {
            for(int j=i+1; j<=len; j++) {
                String word = input.substring(i, j);
                char[] chArr = word.toCharArray();
                int lt = 0;
                int rt = word.length() - 1;

                boolean isPalindrom = true;
                while(lt < rt && isPalindrom) {
                    if(chArr[lt] == chArr[rt]) {
                        lt++;
                        rt--;
                    } else {
                        isPalindrom = false;
                    }
                }
                if(isPalindrom) {
                    answer = Math.max(answer, word.length());
                }
            }
        }

        System.out.println(answer);
    }
    // 실패코드 (0에서 문자끝까지 1개씩 줄여가며 반복함)
    /*for(int i=len; i>0; i--) {
        String word = input.substring(0, i);
        char[] chArr = word.toCharArray();
        int lt = 0;
        int rt = word.length() - 1;

        boolean isPalindrom = true;
        while(lt < rt && isPalindrom) {
            if(chArr[lt] == chArr[rt]) {
                lt++;
                rt--;
            } else {
                isPalindrom = false;
            }
        }
        if(isPalindrom) {
            answer = Math.max(answer, word.length());
        }
    }*/

}
