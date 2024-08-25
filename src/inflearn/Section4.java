package inflearn;

import java.util.*;

/**
 * packageName    : inflearn
 * fileName       : Section4
 * author         : KimChansoo
 * date           : 24. 8. 3.
 * description    : 자바 알고리즘 문제풀이 입문 : HashMap, TreeSet (해쉬, 정렬지원 Set)
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 8. 3.       KimChansoo       최초 생성
 */
public class Section4 {

    /**
     * 1. 학급 회장 (HashMap)
     * TODO 다시 풀어보기
     */
    public static void question4_1Solve(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   // 반 학생 수
        String str = sc.next(); // 투표 내용 (선생님이 발표한 순서)
        // 후보는 A, B, C, D, E 총 5명

        Map<Character, Integer> vote = new HashMap<>();
        for(int i=0; i<5; i++) {
            vote.put((char)(65+i), 0);  // ASCII코드 사용
        }

        for(char x : str.toCharArray()) {
            vote.put(x, vote.getOrDefault(x, 0)+1);
        }

        char answer = ' ';
        int max = Integer.MIN_VALUE;
        for(char key : vote.keySet()) {
            if(max < vote.get(key)) {
                max = vote.get(key);
                answer = key;
            }
        }
        System.out.println(answer);

        // POINT Map.Entry와 map.entrySet()을 활용해서 전체 값을 사용할 수도 있다
//        for(Map.Entry<Character, Integer> entry : vote.entrySet()) {
//            entry.getKey();
//            entry.getValue();
//        }
    }


    public static void question4_1Answer(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String str = sc.next();

        char answer = ' ';
        HashMap<Character, Integer> map = new HashMap<>();

        for(char x : str.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0)+1);
        }

        int max = Integer.MIN_VALUE;
        for(char key : map.keySet()) {
            if(map.get(key) > max) {
                max = map.get(key);
                answer = key;       // POINT max값인 key값을 찾을 때 그 때의 key를 가지고 있다가 return 해줘야함
            }
        }

        System.out.println(answer);
    }


    /**
     * 2. 아나그램 (두 문자열이 알파벳의 나열 순서는 다르지만 그 구성이 일치하는 두 단어)
     */
    public static void question4_2Solve(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();

        Map<String, Integer> str1Map = makeWordMap(str1);
        Map<String, Integer> str2Map = makeWordMap(str2);

        if(str1Map.equals(str2Map)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }


    /**
     * 입력 단어를 받아 HashMap 형태로 알파벳을 분리하여 반환
     * @param word
     * @return
     */
    public static Map<String, Integer> makeWordMap(String word) {
        Map<String, Integer> map = new HashMap<>();
        for(char ch : word.toCharArray()) {
            String chr = String.valueOf(ch);
            if(map.containsKey(chr)) {
                map.put(chr, map.get(chr)+1);
            } else {
                map.put(chr, 1);
            }
        }
        return map;
    }


    public static void question4_2Answer(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();

        String answer = "YES";
        HashMap<Character, Integer> map = new HashMap<>();
        for(char x : a.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        for(char x : b.toCharArray()) {
            if(!map.containsKey(x) || map.get(x) == 0) {
                answer = "NO";
                break;
            }
            map.put(x, map.get(x)-1);
        }
        System.out.println(answer);
    }


    /**
     * 3. 매출액의 종류
     */
    public static void question4_3Solve(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   // n일 동안의 매출기록
        int k = sc.nextInt();   // k일 동안의 매출액의 종류를 각 구간별로 구한다

        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        // POINT 후반부 테스트케이스에서 Time Limit Exceeded 오류 발생
        //  투 포인터 알고리즘을 사용하는 방향으로 변경 필요
        List<Integer> list = new ArrayList<>();
        int start = 0;
        while(list.size() < n-k+1) {
            Set<Integer> set = new HashSet<>();
            for(int i=start; i<start+k; i++) {
                set.add(arr[i]);
            }
            list.add(set.size());
            start++;
        }

        for(int x : list) {
            System.out.print(x+" ");
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        // POINT 슬라이딩 윈도우 알고리즘 사용
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> HM = new HashMap<>();

        for(int i=0; i<k-1; i++) {  // k의 길이만큼 반복문이 실행되어야 함
            HM.put(arr[i], HM.getOrDefault(arr[i], 0)+1);
        }
        int lt = 0;
        for(int rt=k-1; rt<n; rt++) {
            HM.put(arr[rt], HM.getOrDefault(arr[rt], 0)+1);
            answer.add(HM.size());
            HM.put(arr[lt], HM.get(arr[lt])-1);
            if(HM.get(arr[lt]) == 0) {  // 연속된 구간 안에 없으면 Map에서 삭제
                HM.remove(arr[lt]);
            }
            lt++;
        }

        for(int x : answer) {
            System.out.print(x+" ");
        }
    }

}
