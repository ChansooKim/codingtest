package types;

import java.util.Arrays;

/**
 * 정렬 (Sorting)
 *  데이터를 특정 기준에 따라 순서대로 정리하는 것.
 *
 * 자주 쓰이는 알고리즘: 버블 정렬, 선택 정렬, 삽입 정렬, 퀵 정렬, 병합 정렬
 */

 /**
 * 퀵 정렬(Quick Sort):
 *  기준(pivot)을 하나 잡고, 작은 값은 왼쪽, 큰 값은 오른쪽으로 분할해서 정렬
 */
class QuickSort {
    public static void quickSort(int[] arr, int start, int end) {
        if (start >= end) return; // 탈출 조건

        int pivot = arr[start];
        int left = start + 1, right = end;

        while (left <= right) {
            while (left <= end && arr[left] <= pivot) left++;
            while (right > start && arr[right] >= pivot) right--;

            if (left <= right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            } else {
                int temp = arr[start];
                arr[start] = arr[right];
                arr[right] = temp;
            }
        }
        quickSort(arr, start, right - 1);
        quickSort(arr, right + 1, end);
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 2, 7, 1, 10};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}


/**
 * 버블 정렬 (Bubble Sort)
 *  인접한 두 요소를 비교하며 교환. 큰 값이 거품처럼 맨 끝으로 이동
 *
 * 시간 복잡도: O(N²) (느림, 하지만 구현이 쉬움)
 * 특징:
 *  구현이 매우 간단하지만, 대체로 비효율적
 *  이미 거의 정렬된 배열에서는 빠르게 수행
 */
class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5, 1, 4, 2, 8};
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}


/**
 * 선택 정렬 (Selection Sort)
 * 원리: 매번 배열에서 가장 작은 값을 찾아 제일 앞으로 보냄.
 *
 * 시간 복잡도: O(N²)
 * 특징:
 *  작은 데이터를 다룰 때는 유용
 *  교환 횟수가 적음
 */
class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}


/**
 * 삽입 정렬 (Insertion Sort)
 *  현재 위치에서 이전 요소들과 비교해 적절한 위치에 삽입
 *
 * 시간 복잡도: O(N²), (하지만 거의 정렬된 배열일 땐 O(N))
 * 특징:
 *  카드 게임에서 카드를 정렬하는 방법과 유사
 *  데이터가 거의 정렬된 경우 매우 빠름
 */
class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6};
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        System.out.println(Arrays.toString(arr));
    }
}


/**
 * 병합 정렬 (Merge Sort)
 * 원리: 배열을 반으로 쪼개서 각각 정렬한 뒤 병합
 *
 * 시간 복잡도: O(N log N) (항상 일정하게 빠름)
 * 특징:
 *  분할 정복(Divide and Conquer) 방식
 *  안정 정렬(Stable Sort)이며, 큰 데이터에서 성능이 우수
 *  다만, 추가적인 메모리 공간을 사용
 */
class MergeSort {
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) L[i] = arr[left + i];
        for (int i = 0; i < n2; i++) R[i] = arr[mid + 1 + i];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) arr[k++] = L[i++];
            else arr[k++] = R[j++];
        }

        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
