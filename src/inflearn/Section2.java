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
     * 2. 보이는 학생
     */
    public static void question2_2Solve(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        int count = 0;
        int frontStudent = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            int height = Integer.parseInt(st.nextToken());
            if(frontStudent < height) {
                frontStudent = height;
                count++;
            }
        }
        System.out.println(count);
    }


    public static void question2_2Answer(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        int answer = 1, max = arr[0];
        for(int i=1; i<n; i++) {
            if(arr[i] > max) {
                answer++;
                max = arr[i];
            }
        }
        System.out.println(answer);
    }


    /**
     * 3. 가위바위보
     */
    public static void question2_3Solve(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] aArr = new int[n];
        int[] bArr = new int[n];
        for(int i=0; i<n; i++) {
            aArr[i] = sc.nextInt();
        }
        for(int i=0; i<n; i++) {
            bArr[i] = sc.nextInt();
        }
        // 1:가위, 2:바위, 3:보
        for(int i=0; i<n; i++) {
            int a = aArr[i];
            int b = bArr[i];
            if(a == 1) {
                if(b == 2) System.out.println("B");
                else if(b == 3) System.out.println("A");
                else System.out.println("D");
            } else if(a == 2) {
                if(b == 1) System.out.println("A");
                else if(b == 2) System.out.println("D");
                else System.out.println("B");
            } else if(a == 3){
                if(b == 1) System.out.println("B");
                else if(b == 2) System.out.println("A");
                else System.out.println("D");
            }
        }
    }


    public static void question2_3Answer(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for(int i=0; i<n; i++) {
            a[i] = sc.nextInt();
        }
        for(int i=0; i<n; i++) {
            b[i] = sc.nextInt();
        }

        String answer = "";
        for(int i=0; i<n; i++) {
            if(a[i] == b[i]) answer+="D";
            else if(a[i]==1 && b[i]==3) answer+="A";
            else if(a[i]==2 && b[i]==1) answer+="A";
            else if(a[i]==3 && b[i]==2) answer+="A";
            else answer+="B";
        }
        for(char x : answer.toCharArray()) {
            System.out.println(x);
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
     * 6. 뒤집은 소수
     */
    public static void question2_6Solve(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        for(int i=0; i<n; i++) {
            String a = String.valueOf(arr[i]);
            StringBuilder b = new StringBuilder(a);
            b.reverse();

            int c = Integer.parseInt(b.toString());
            if(isPrime(c)) {
                System.out.print(c+" ");
            }
        }
    }


    public static boolean isPrime(int num) {
        if(num == 1) return false;
        else {
            for(int i=2; i<num; i++) {
                if(num%i==0) {
                    return false;
                }
            }
        }
        return true;
    }


    public static void question2_6Answer(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=0; i<n; i++) {
            int tmp = arr[i];
            int res = 0;
            while(tmp > 0) {
                // 숫자 뒤집기
                int t = tmp % 10;
                res = res * 10 + t;
                tmp = tmp / 10;

                /*res = res * 10 + t
                t = tmp % 10     (나머지)
                tmp = tmp / 10   (몫)*/
            }
            if(isPrime(res)) {
                answer.add(res);
            }
        }

        for(int x : answer) {
            System.out.print(x+" ");
        }
    }


    /**
     * 소수 판별함수
     * @param num
     * @return
     */
    /*public static boolean isPrime(int num) {
        if(num==1) return false;
        for(int i=2; i<num; i++) {
            if(num%i == 0) return false;
        }
        return true;
    }*/


    /**
     * 7. 점수계산
     */
    public static void question2_7Solve(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        int answer = arr[0];
        int contScore = arr[0];     // 가산점을 담는 변수
        boolean isContinue = arr[0] == 1;
        for(int i=1; i<n; i++) {
            if(isContinue && arr[i]==1) {
                contScore++;
                answer += contScore;
            } else if(arr[i]==1) {
                contScore++;
                answer += contScore;
                isContinue = true;
            } else {
                isContinue = false;
                contScore = 0;
            }
//            System.out.println("i: "+i+", answer: "+answer);
        }
        System.out.println(answer);
    }


    public static void question2_7Answer(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        int answer = 0, cnt = 0;
        for(int i=0; i<n; i++) {
            if(arr[i]==1) {
                cnt++;
                answer += cnt;
            } else {
                cnt = 0;
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


    /**
     * 10. 봉우리
     * TODO 다시 풀어보기
     */
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(arr[i][j] < arr[i][j+1]) {
                    if(arr[])
                }
            }
        }
    }*/


    public static void question2_10Answer(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int[] dx = {-1, 0, 1, 0};   // 지점 arr[i][j] 기준, 상하좌우를 사용하기 위한 배열
        int[] dy = {0, 1, 0, -1};

        int answer = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                // 격자에서 4 방향으로 봉우리 여부 판단
                boolean flag = true;
                for(int k=0; k<4; k++) {
                    int nx = i+dx[k];
                    int ny = j+dy[k];

                    // 봉우리가 아닌 경우
                    if(nx>=0 && nx<n && ny>=0 && ny<n && arr[nx][ny] >= arr[i][j]) { // indexOutOfBound 에러 방지 (테두리는 0으로 친다)
                        flag = false;
                        break;
                    }
                }
                if(flag) answer++;
            }
        }
        System.out.println(answer);
    }


    /**
     * 11. 임시반장 정하기 (3중 for문)
     * TODO 다시 풀어보기
     */
    public static void question2_11Solve(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][5];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int max = 0;
        int studentNum = 0;
        for(int i=0; i<n; i++) {
            int cnt = 0;
            for(int j=0; j<n; j++) {
                for(int k=0; k<5; k++) {
                    if(arr[i][k] == arr[j][k]) {
                        cnt++;
                        break;
                    }
                }
            }
            if(cnt > max) {
                max = cnt;
                studentNum = n+1;
            }
        }
        System.out.println(studentNum);
    }


    public static void question2_11Answer(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n+1][6];  // 1번부터 사용하기 때문에 n+1, 5학년까지 있으니까 6으로 잡음
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=5; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int answer = 0;
        int max = Integer.MIN_VALUE;
        for(int i=1; i<=n; i++) {
            int cnt = 0;
            for(int j=1; j<=n; j++) {
                for(int k=1; k<=5; k++) {
                    if(arr[i][k] == arr[j][k]) {
                        cnt++;
                        break;
                    }
                }
            }
            if(cnt > max) {
                max = cnt;
                answer = i;
            }
        }
        System.out.println(answer);
    }


    /**
     * 12. 멘토링 (4중 for문)
     * TODO 다시 풀어보기
     */
    public static void question2_12Solve(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   // 반 학생수
        int m = sc.nextInt();
        int[][] arr = new int[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int answer = 0;
        for(int i=0; i<m; i++) {
            int cnt = 0;
            int max = Integer.MIN_VALUE;    // 해당 줄에서의 최대 값
            for(int j=0; j<n; j++) {
                // arr[0][0]
//                int x = arr[i][j];  // arr[0][0]-> 1번
//                arr[i][j]
            }
        }
    }


    public static void question2_12Answer(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   // 반 학생수
        int m = sc.nextInt();
        int[][] arr = new int[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int answer = 0;
        for(int i=1; i<=n; i++) {
            // 각 열에서의 비교를 위한 2중 for문 (i, j)
            for(int j=1; j<=n; j++) {
                int cnt = 0;
                for(int k=0; k<m; k++) {
                    int pi=0, pj=0;     // pi: 멘토, pj: 멘티
                    for(int s=0; s<n; s++) {
                        if(arr[k][s] == i) pi=s;
                        if(arr[k][s] == j) pj=s;
                    }
                    if(pi < pj) cnt++;
                }
                if(cnt == m) {
                    // m개의 테스트에서 짝꿍이 될 수 있는 경우의 수
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }

}
