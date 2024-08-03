package inflearn;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * packageName    : inflearn
 * fileName       : Section2
 * author         : KimChansoo
 * date           : 24. 8. 3.
 * description    : 자바 알고리즘 문제풀이 입문 : Array(1, 2차원 배열)
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 8. 3.       KimChansoo       최초 생성
 */
public class Section2 {

    /**
     * 1. 큰 수 출력하기
     */
    public static void question2_1Solve(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        String str = sc.nextLine();

        String[] sArr = str.split(" ");

        int compVal = 0;
        for(int i=0; i<N; i++) {
            if(Integer.parseInt(sArr[i]) > compVal) {
                System.out.print(sArr[i]+" ");
            }
            compVal = Integer.parseInt(sArr[i]);
        }
    }


    public static void question2_1Answ(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(arr[0]);
        for(int i=1; i<n; i++) {
            if(arr[i] > arr[i-1]) {
                answer.add(arr[i]);
            }
        }
        for(int x : answer) {
            System.out.println(x+" ");
        }
    }


    /**
     * 4. 피보나치 수열 (배열 ver) [속도 상 for문 배열이 성능이 더 좋다]
     * TODO 다시 풀어보기
     *  피보나치 수열 : 앞의 2개의 수를 합하여 다음 숫자가 되는 수열
     */
    public static void question2_4Solve(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        List<Integer> list = new ArrayList<>();
        list.add(1);
        int preVal = 0;
        for(int i=1; i<=N-1; i++) {
            list.add(list.get(i-1)+preVal);
            preVal = list.get(i-1);
        }
        for(int val : list) {
            System.out.print(val+" ");
        }
    }


    /**
     * 피보나치 수열 정석 풀이
     * @see Section7 fibonacci
     */
    public static void question2_4Answ(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] answer = new int[n];

        // POINT 앞의 배열 2개는 고정
        answer[0] = 1;
        answer[1] = 1;
        for(int i=2; i<n; i++) {
            answer[i] = answer[i-2] + answer[i-1];  // 앞의 2개 더해서 저장
        }

        for(int x : answer) {
            System.out.print(x+" ");
        }
    }


    // 단순 풀이
    public static void question2_4Answ2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] answer = new int[n];

        // POINT 앞의 변수 a=1, b=1은 고정
        int a=1, b=1, c;
        System.out.print(a+" "+b+" ");
        for(int i=2; i<n; i++) {
            c = a + b;
            System.out.println(c+" ");
            a = b;
            b = c;
        }

        for(int x : answer) {
            System.out.print(x+" ");
        }
    }


    /**
     * 5. 소수(에라토스테네스 체)
     * 소수(prime number) : 1과 자신만을 약수로 갖는 수
     */
    public static void question2_5Solve(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        List<Integer> list = new ArrayList<>();
        list.add(2);
        // FIXME Time Limit Exceeded 오류 발생 (제한시간이 1초로, 2중 For문 사용 시 결과가 안나옴)
        for(int i=3; i<N; i++) {
            boolean isTrue = true;
            for(int val : list) {
                if(i%val == 0) {
                    // 소수 아님
                    isTrue = false;
                    break;
                }
            }
            if(isTrue) {
                list.add(i);
            }
        }
        System.out.println(list.size());
    }


    public static void question2_5Solve2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N+1];       // 입력된 갯수만큼 생성
        // arr = { 0, 0, 0.... ,0 }
        int count = 0;
        for(int i=2; i<=N; i++) {
            if(arr[i] == 0) {   // 2+2+2+2
                count++;
                for(int j=i; j<=N; j=j+i) {
                    arr[j] = 1;
                }
            }
        }
        System.out.println(count);
    }



    // N의 갯수만큼의 list를 생성하고, 체크해서 약수를 걸러낸다 - '에라토스테네스의 체'
    public static void question2_5Answer(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();       // 20
        int answer = 0;
        int[] ch = new int[n+1];    // n+1까지 해야 index 'n'번까지 생성됨 (생성하면, 배열의 모든 기본 값은 '0'으로 초기화)
        for(int i=2; i<=n; i++) {   // 2~20까지 검사
            if(ch[i] == 0) {    // 소수인 경우
                answer++;
                for(int j=i; j<=n; j=j+i) { // POINT j가 i의 배수만큼 돌아야해서, j=j+i 만큼 증가
                    ch[j] = 1;  // ch[i] = 1인 경우, 위의 조건문에 걸리지 않게 되기 때문에, i의 배수인 경우 전부 찾아서 제외하게 된다
                }
            }
        }
        System.out.println(answer);
    }


    /**
     * 8. 등수구하기
     * TODO 다시 풀어보기
     */
    public static void question2_8Solve(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   // 학생의 수
        int arr[] = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        int answer[] = new int[n];
        for(int i=0; i<n; i++) {
            int cnt = 1;
            for(int j=0; j<n; j++) {
                if(arr[j] > arr[i]) {
                    cnt++;
                }
                answer[i] = cnt;
            }
        }
        for(int x : answer) {
            System.out.print(x+" ");
        }
    }


    // 2차원 배열에서 첫 번째 배열을 1등으로 두고, 비교하면서 등수를 증가시킨다
    public static void question2_8Answer(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] answer = new int[n];
        for(int i=0; i<n; i++) {
            int cnt = 1;    // 첫번째는 항상 1등

            for(int j=0; j<n; j++) {
                if(arr[j] > arr[i]) {
                    cnt++;  // POINT 비교군이 더 크면 1등수 내려간다 (1등->2등)
                }
                answer[i] = cnt;
            }
        }
        for(int x : answer) {
            System.out.print(x+" ");
        }
    }


    /**
     * 9. 격자판 최대합
     */
    public static void question2_9Solve(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[][] arr = new int[n][n];
        // 격자판 입력
        for(int i=0; i<n; i++) {
            String str = sc.nextLine();
            for(int j=0; j<n; j++) {
                String[] tmp = str.split(" ");

                arr[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        // 가로방향
        int max1 = 0;
        for(int i=0; i<arr.length; i++) {
            int inArr[] = arr[i];
            int max = 0;
            for(int j=0; j<inArr.length; j++) {
                max += arr[i][j];
            }
            if(max > max1) max1 = max;
        }
//        System.out.println("max1: "+ max1);

        // 세로방향
        int max2 = 0;
        for(int j=0; j<arr.length; j++) {
            int max = 0;
            for(int i=0; i<arr[j].length; i++) {
                max += arr[i][j];
            }
            if(max > max2) max2 = max;
        }
//        System.out.println("max2: "+ max2);

        // 대각선 2개
        int max3 = 0;
        for(int i=0; i<arr.length; i++) {
            // [0][0] + [1][1] + [2][2] +[3][3]...
            max3 += arr[i][i];
        }

        int max4 = 0;
        for(int i=0; i<arr.length; i++) {
            // [0][4] + [1][3] + [2][2] + [3][1] + [4][0]
            max4 += arr[i][arr.length-i-1];   // FIXME arr.lengh-i-1 을 해줘야함
        }

//        System.out.println("max3: "+ max3+", max4: "+max4);
        System.out.println(Math.max(max4, Math.max(max3, Math.max(max1, max2))));
    }


    public static void question2_9Answer(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        // 격자판 입력
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int answer = Integer.MIN_VALUE;
        int sum1, sum2;
        // POINT 가로, 세로를 한번에 계산할 수 있다
        for(int i=0; i<n; i++) {
            sum1 = sum2 = 0;
            for(int j=0; j<n; j++) {
                sum1 += arr[i][j];
                sum2 += arr[j][i];
            }
            answer = Math.max(answer, sum1);    // 큰 값을 answer로 갱신
            answer = Math.max(answer, sum2);
        }
        // 대각선
        sum1 = sum2 = 0;
        for(int i=0; i<n; i++) {
            sum1 += arr[i][i];
            sum2 += arr[i][n-i-1];
        }
        answer = Math.max(answer, sum1);
        answer = Math.max(answer, sum2);

        System.out.println(answer);
    }



}
