package inflearn;

import java.util.Scanner;

/**
 * packageName    : inflearn
 * fileName       : Section6
 * author         : KimChansoo
 * date           : 24. 8. 4.
 * description    : 자바 알고리즘 문제풀이 입문 : Sorting and Searching(정렬, 이분검색과 결정알고리즘)
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 8. 4.       KimChansoo       최초 생성
 */
public class Section6 {

    /**
     * 1. 선택정렬
     * TODO 다시 풀어보기
     *  첫 번째 자료를 두 번째 자료부터 마지막 자료까지 차례대로 비교하여 작은 값을 첫 번째로 놓고
     *  -> 두 번째 자료부터 다시 비교 반복
     */
    public static void question6_1Answer(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        for(int i=0; i<n-1; i++) {    // POINT 마지막 자료 앞에 값까지만 찾아도 됨(올 값을 바꾸면 뒤의 값이 의미가 없음)
            int idx = i;        // 하단에서 변경했던 인덱스는 다시 i값으로 초기화
            for(int j=i+1; j<n; j++) {  // 두 번째 자료와 비교
                if(arr[j] < arr[idx]) { // 두 번째 자료보다 첫 번째 자료가 더 크면
                    idx = j;            //  인덱스를 두 번째 자료로 변경 (오름차순이면 뒤로 보내야하니까)
                }
            }
            int tmp = arr[i];   // 첫 번째 자료를 뽑아서
            arr[i] = arr[idx];  //  첫 번째 인덱스에 두 번째 자료에 있던 값을 대입해 바꿔준다
            arr[idx] = tmp;     // 기존의 첫 번째 자료는 (tmp로 뽑아놓은) 두 번째 인덱스로 변경
        }

        for(int x : arr) {
            System.out.print(x+" ");
        }
    }


    /**
     * 2. 버블 정렬 O(n^2)
     */
    public static void question6_2Solve(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        for(int i=0; i<n-1; i++) {
            for(int j=0; j<n-i-1; j++) {
                if(arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }

        for(int x : arr) {
            System.out.print(x+" ");
        }
    }


    public static void question6_2Answer(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        for(int i=0; i<n-1; i++) {
            for(int j=0; j<n-i-1; j++) {    // POINT i가 하나씩 커짐에 따라, j는 하나씩 작게 반복
                if(arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }

        for(int x : arr) {
            System.out.print(x+" ");
        }
    }


    /**
     * 3. 삽입 정렬
     */
    public static void question6_3Solve(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        for(int i=1; i<n; i++) {
            int tmp = arr[i];
            int j;
            // 11 7 5 6 10 9
            for(j=i-1; j>=0; j--) {     // tmp=7, arr[j]=11, arr[j+1]=7
                if(arr[j] > tmp) {
                    arr[j+1] = arr[j];  // 7 자리에 11 삽입, 반복문 종료 후 j--되어 j=0, arr[j+1]=arr[1]=7
                } else {
                    break;
                }
            }
            arr[j+1] = tmp;
        }

        for(int x : arr) {
            System.out.print(x+" ");
        }
    }


    public static void question6_3Answer(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        for(int i=1; i<n; i++) {
            int tmp = arr[i];
            int j;
            for(j=i-1; j>=0; j--) {
                if(arr[j] > tmp) {
                    arr[j+1] = arr[j];
                } else break;
            }
            arr[j+1] = tmp;
        }

        for(int x : arr) {
            System.out.print(x+" ");
        }
    }
}
