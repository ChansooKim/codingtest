package inflearn;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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
}
