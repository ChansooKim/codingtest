package inflearn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * packageName    : inflearn
 * fileName       : Section3
 * author         : KimChansoo
 * date           : 24. 8. 3.
 * description    : 자바 알고리즘 문제풀이 입문 : Two pointers, Sliding window[효율성 : O(n^2)->O(n)]
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 8. 3.       KimChansoo       최초 생성
 */
public class Section3 {

    /**
     * 1. 두 배열 합치기(two pointers algorithm)
     * TODO 다시 풀어보기
     * O(n log n)
     */
    public static void question3_1Solve(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nArr = new int[n];
        for(int i=0; i<n; i++) {
            nArr[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] mArr = new int[m];
        for(int i=0; i<m; i++) {
            mArr[i] = sc.nextInt();
        }

        List<Integer> list = new ArrayList<>();
        int p1 = 0, p2 = 0;
        while(p1 < n && p2 < m) {
            if(nArr[p1] < mArr[p2]) {
                list.add(nArr[p1]);
                p1++;
            } else {
                list.add(mArr[p2]);
                p2++;
            }
        }
        // 어느쪽이 소진됐는지 모르니까 둘 다 확인
        while(p1 < n) {
            list.add(nArr[p1]);
            p1++;
        }
        while(p2 < m) {
            list.add(mArr[p2]);
            p2++;
        }

        for(int x : list) {
            System.out.print(x+" ");
        }
    }


    public static void question3_1Answer(String[] args) {
        // POINT 두 개의 배열을 비교하며 둘 중 작은 값을 ArrayList에 넣어가며 구현
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0; i<n; i++) {
            a[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] b = new int[m];
        for(int i=0; i<m; i++) {
            b[i] = sc.nextInt();
        }

        ArrayList<Integer> answer = new ArrayList<>();
        // pointer 2개
        int p1 = 0, p2 = 0;
        while(p1 < n && p2 < m) {   // p1이든, p2든 어느 하나라도 소진되면 반복문 종료
            if(a[p1] < b[p2]) {
                answer.add(a[p1++]);    // 후위증감연산자로 a[p1]이 List에 add되고, p1의 값이 1증가
            } else {
                answer.add(b[p2++]);
            }
        }
        while(p1 < n) answer.add(a[p1++]);
        while(p2 < m) answer.add(b[p2++]);

        for(int x : answer) {
            System.out.println(x+" ");
        }
    }


    /**
     * 2. 공통원소구하기(two pointers algorithm)
     * TODO 다시 풀어보기
     */
    public static void question3_2Solve(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0; i<n; i++) {
            a[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] b = new int[m];
        for(int i=0; i<m; i++) {
            b[i] = sc.nextInt();
        }
        /* POINT 먼저 위 배열을 각 오름차순 정렬한다. "투포인터는 무조건 오름차순 정렬"
          * 각 배열은 중복되지 않는 원소가 오름차순으로 주어지기 때문에, 1개의 배열을 지나면 앞으로 배열 안에서 중복되는 수는 없다 */

        Arrays.sort(a);
        Arrays.sort(b);

        List<Integer> answer = new ArrayList<>();
        int p1 = 0, p2 = 0;
        while(p1 < n && p2 < m) {
            if(a[p1] == b[p2]) {
                answer.add(a[p1]);
                p1++;
                p2++;
            } else if(a[p1] < b[p2]) {
                p1++;
            } else if(a[p1] > b[p2]) {
                p2++;
            }
        }
        for(int x : answer) {
            System.out.print(x+" ");
        }
    }


    public static void question3_2Answer(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0; i<n; i++) {
            a[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] b = new int[m];
        for(int i=0; i<m; i++) {
            b[i] = sc.nextInt();
        }

        // 오름차순 정렬
        Arrays.sort(a);     // POINT 배열의 정렬 Arrays.sort();
        Arrays.sort(b);

        List<Integer> answer = new ArrayList<>();
        int p1 = 0, p2 = 0;
        while(p1 < n && p2 < m) {
            if(a[p1] == b[p2]) {
                answer.add(a[p1++]);
                p2++;
            } else if(a[p1] < b[p2]) {
                p1++;       // 작은 쪽을 증가시킨다
            } else {
                p2++;
            }
        }
        for(int x : answer) {
            System.out.print(x+" ");
        }
    }


    /**
     * 3. 최대 매출(Sliding window)
     */
    public static void question3_3Solve(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   // 매출기록 일수
        int k = sc.nextInt();   // 연속된 일자
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        // POINT [효율성 : O(n^2)->O(n)]
        // 2중 for문으로 j일 때 3개 씩 반복하지 말 것
        /*int max = Integer.MIN_VALUE;
        for(int i=0; i<n-2; i++) {
            // FIXME k 값을 활용하지 않음 (k 만큼 반복하도록 수정)
            int sum = arr[i] + arr[i+1] + arr[i+2];
            max = Math.max(max, sum);
        }*/

        // 초기 K 일자 만큼의 매출액 합
        int max = 0, sum = 0;
        for(int i=0; i<k; i++) {
            sum += arr[i];
        }
        max = sum;

        for(int i=k; i<n; i++) {
            sum += (arr[i]-arr[i-k]);
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }


    // 갯수 만큼 초기화를 하고, 이후 앞의 배열을 지우고 뒤의 배열을 추가하며 창문을 밀듯이 진행
    public static void question3_3Answer(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   // 매출기록 일수
        int k = sc.nextInt();   // 연속된 일자
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        
        // POINT K가 3개인 경우, 미리 3개만큼 초기화를 해놓을 것
        int answer = 0, sum = 0;
        for(int i=0; i<k; i++) {
            sum += arr[i];
        }
        answer = sum;
        // POINT 앞의 Window에서 다음 배열을 더하고 맨 첫번째 배열을 빼는 방식으로 진행
        for(int i=k; i<n; i++) {
            sum += (arr[i]-arr[i-k]);
            answer = Math.max(answer, sum);
        }

        System.out.println(answer);
    }


    /**
     * 4. 연속 부분 수열
     * TODO 다시 풀어보기
     */
    public static void question3_4Solve(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        int answer = 0;
        for(int i=0; i<n; i++) {
            int sum = 0;
            for(int j=i; j<n; j++) {    // 첫번째
                if(sum < m) {
                    sum += arr[j];
                } else if(sum == m) {
                    answer++;
                    break;
                } else {
                    break;
                }
            }
        }
        System.out.println(answer);
    }


    /**
     * 투 포인터 사용
     */
    public static void question3_4Answer(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        // POINT 2중 for문을 사용해도 되지만, O(n^2)으로 횟수가 늘어나면 오래걸리기때문에 투 포인터를 사용한다
        int answer = 0;
        int sum = 0;
        int lt = 0;
        for(int rt=0; rt<n; rt++) {
            sum += arr[rt];
            if(sum == m) {
                answer++;
            }
            while(sum >= m) {
                sum -= arr[lt++];   // sum에서 lt값을 빼고, lt값은 1 증가
                if(sum == m) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }


    /**
     * 5. 연속된 자연수의 합(two pointers)
     * // TODO 다시 풀어보기
     */
    public static void question3_5Solve(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 2개 이상의 연속된 자연수의 합
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = i+1;
        }
        // { 1, 2, 3, 4, ... , 14, 15}
        int count = 0;
        int p1 = 0, p2 = 0;
        while(p1 < n) {
            int sum = 0;
            p1 = p2;
            for(int i=p1; i<n; i++) { // arr[0] ~ arr[14]
//                sum += arr[i];      // 1+2+3+4+5
                if(sum < n) {
                    sum += arr[i];
                } else if(sum == n) {
                    count++;
                    p2++;
                    break;
                } else if(sum > n) {
                    p2++;
                    break;
                }
            }
        }
        System.out.println(count);
    }


    public static void question3_5Answer(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 2개 이상의 연속된 자연수의 합
        int n = sc.nextInt();
        // 15를 예로 봤을 때, 15/2 = '8'까지만 배열에 존재해도 된다. (8과 9는 15가 넘으니까)
        int answer = 0;
        int sum = 0;
        int lt = 0;

        int m = n/2+1;
        int[] arr = new int[m];
        for(int i=0; i<m; i++) {
            arr[i] = i+1;       // 0번 인덱스에 1, 1번 인덱스에 2...
        }
        for(int rt=0; rt<m; rt++) {
            sum+=arr[rt];   // 1+2+3+4+5
            if(sum==n) {
                answer++;
            }
            while(sum>=n) {
                sum -= arr[lt++];   // POINT sum이 n을 넘어가면, 왼쪽포인터(lt)의 값 만큼을 sum에서 빼고 lt를 증가
                if(sum==n) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }


    /**
     * 5-1. 연속된 자연수의 합 (수학)
     * 5번 문제에 대한 수학적 풀이
     */
    public static void question3_5Answer2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = 0;
        int cnt = 1;

        n--;
        while(n>0) {
            cnt++;
            n = n-cnt;
            if(n % cnt == 0) {  // 연속된 자연수가 가능한 경우
                answer++;
            }
        }
        System.out.println(answer);
    }


    /**
     * 6. 최대 길이 연속부분수열
     */
    public static void question3_6Solve(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int answer = 0;
        int cnt = 0;    // 0을 1로 바꾼 횟수 (k값을 넘어가면 안됨)
        int lt = 0, rt = 0;
        int continueCnt = 0;
        while (cnt < k) {
            continueCnt = 0;
            for (int i = lt; i < arr.length; i++) {
                if (arr[i] == 0) {
                    cnt++;
                } else {
                    continueCnt++;
                }

                if(cnt == k) lt++;
            }
        }

        answer = Math.max(answer, continueCnt);
        System.out.println(answer);
    }


    public static void question3_6Answer(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        int answer = 0, cnt = 0, lt=0;
        for(int rt = 0; rt<n; rt++) {
            if(arr[rt] == 0) {
                cnt++;
            }

            while(cnt > k) {
                if(arr[lt] == 0) {
                    cnt--;
                }
                lt++;
            }
            answer = Math.max(answer, rt-lt+1);
        }
        System.out.println(answer);
    }

}
