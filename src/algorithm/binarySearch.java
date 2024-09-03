package algorithm;

/**
 * packageName    : algorithm
 * fileName       : BinarySearch
 * author         : KimChansoo
 * date           : 24. 8. 2.
 * description    : 이진탐색 알고리즘
 * @see <a href="https://terms.naver.com/entry.naver?cid=58598&docId=3597414&categoryId=59316">네이버 지식백과</a>
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 8. 2.       KimChansoo       최초 생성
 */
public class BinarySearch {

    public static void main(String[] args) {
        // 91번 책 찾기
        int[] bookShelf = {12, 16, 20, 28, 33, 46, 52, 64, 68, 71, 83, 88, 91, 96, 99};
        int targetBook = 28;

        int result = binarySearchFunc(bookShelf, targetBook);
        if(result != -1) {
            System.out.println(targetBook + "번 책은 " + (result+1) + "번째에 있습니다.");  // 배열값이므로 +1
        } else {
            System.out.println(targetBook + "번 책을 찾을 수 없습니다.");
        }
    }

    private static int binarySearchFunc(int[] arr, int target) {
        // 1. 왼쪽과 오른쪽으로 나눈다.  (배열의 첫번째 값과 마지막 값)
        int left = 0;
        int right = arr.length - 1;

        // 2. 반복하며 한 칸씩 줄여가며 탐색한다.
        while(left <= right) {
           int mid = left + (right - left) / 2;

           if(arr[mid] == target) {
               return mid;      // 찾으려는 책 번호와 일치하는 인덱스 반환
           } else if(arr[mid] < target) {
               left = mid + 1;  // 중간값이 찾는 책보다 작으면, 오른쪽 부분 확인
           } else {
               right = mid - 1; // 중간값이 찾는 책보다 크면, 왼쪽 부분 확인
           }
        }

        return -1;  // 찾는 책이 없으면 -1 반환
    }

    /**
     * 이진탐색의 기본 형태
     * left, right = 0, len(arr) - 1
     * while left <= right:
     *     mid = left + (right - left) / 2
     *     if arr[mid] < target:
     *         left = mid + 1
     *     else:
     *         right = mid - 1
     *
     * return arr[left]
     */

}
