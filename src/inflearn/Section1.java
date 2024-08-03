package inflearn;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * packageName    : inflearn
 * fileName       : Section1
 * author         : KimChansoo
 * date           : 24. 8. 2.
 * description    : 자바 알고리즘 문제풀이 입문 : String(문자열)
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 8. 2.       KimChansoo       최초 생성
 */
public class Section1 {

    public static void main(String[] args) {
        Section1 s = new Section1();
        s.question1_10Answer(new String[10]);
    }

    /**
     * 1. 문자 찾기
     * String 배열 사용
     */
    public static void question1_1Solve(String[] args){
        Scanner in = new Scanner(System.in);
        String input1 = in.nextLine().toLowerCase();
        String input2 = in.nextLine().toLowerCase();

        String[] arr = input1.split("");

        int count = 0;
        for(String ch : arr) {
            if(input2.equals(ch)) {
                count++;
            }
        }
        System.out.println(count);
    }

    // Char 배열 사용
    public static void question1_1Answer(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine().toLowerCase();
        char c = in.next().charAt(0);   // POINT 문자열은 1개이기 때문에 charAt(0)으로 Char 형태 변환
        int count = 0;
        for(char ch : input.toCharArray()) {
            if(ch == c) {
                count++;
            }
        }
        System.out.println(count);
    }


    /**
     * 2. 대소문자 변환
     * ASCII 코드로 풀이도 가능
     * 대문자 A~Z 65~90 / 소문자 a~Z 97~122   97-65 = 32 (소문자에서 32를 빼면 대문자가 됨)
     */
    public static void question1_2Solve(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        char[] charArr = input.toCharArray();
        for(char ch : charArr) {
            if(Character.isUpperCase(ch)) {
                System.out.print(Character.toLowerCase(ch));
            } else if(Character.isLowerCase(ch)) {
                System.out.print(Character.toUpperCase(ch));
            }
        }
    }

    // ASCII 코드 사용
    public static void question1_2Answer(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        String answer = "";
        for(char ch : input.toCharArray()) {
            // POINT 대문자 A~Z 65~90 / 소문자 a~Z 97~122   97-65 = 32 (소문자에서 32를 빼면 대문자가 됨)
            if(ch >= 97 && ch <= 122) { // 소문자
                answer += (char)(ch - 32);
            } else {
                answer += (char)(ch + 32);
            }
        }
        System.out.println(answer);
    }


    /**
     * 3. 문장 속 단어 (indexOf(), substring())
     */
    public static void question1_3Solve(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        String answer = "";
        String[] arr = input.split(" ");
        for(String str : arr) {
            if(str.length() > answer.length()) {
                answer = str;
            }
        }
        System.out.println(answer);
    }


    public static void question1_3Answer(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String answer = "";
        int m = Integer.MIN_VALUE;
        String[] s = input.split(" ");
        for(String x : s) {
            int len = x.length();
            if(len > m) {
                m = len;
                answer = x;
            }
        }
        System.out.println(answer);
    }


    public static void question1_3Answer2(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String answer = "";
        int m = Integer.MIN_VALUE, pos;

        while((pos = input.indexOf(' ')) != -1) {
            String tmp = input.substring(0, pos);
            int len = tmp.length();
            if(len > m) {
                m = len;
                answer = tmp;
            }
            input = input.substring(pos+1);
        }
        System.out.println(answer);
    }


    /**
     * 4. 단어 뒤집기(StringBuilder 이용법 또는 직접뒤집기)
     */
    public static void question1_4Solve(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String[] words = new String[N];
        for(int i=0; i<N; i++) {
            String word = sc.next();
            words[i] = word;
        }
        String[] newWords = new String[N];
        for(int i=0; i< words.length; i++) {
            char[] chars = words[i].toCharArray();
            String revWord = "";
            for(int j=chars.length-1; j>=0; j--) {
                revWord = revWord + chars[j];
            }
            newWords[i] = revWord;
        }

        for(String print : newWords) {
            System.out.println(print);
        }
    }

    public ArrayList<String> solution1_4(int n, String[] str) {
        ArrayList<String> answer = new ArrayList<>();
        for(String x : str) {
            String tmp = new StringBuilder(x).reverse().toString();
            answer.add(tmp);
        }
        return answer;
    }

    public static void question1_4Answer(String[] args) {
        Section1 t = new Section1();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String[] str = new String[n];
        for(int i=0; i<n; i++) {
            str[i] = sc.next();
        }
        for(String x : t.solution1_4(n, str)) {
            System.out.println(x);
        }
    }


    public static void question1_4Answer2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String[] str = new String[n];
        for(int i=0; i<n; i++) {
            str[i] = sc.next();
        }

        List<String> answer = new ArrayList<>();
        for(String x : str) {
            char[] s = x.toCharArray();
            int left = 0;
            int right = x.length()-1;
            while(left < right) {
                char tmp = s[left];
                s[left] = s[right];
                s[right] = tmp;
                left++;
                right--;
            }
            String tmp = String.valueOf(s);
            answer.add(tmp);
        }

        for(String answ : answer) {
            System.out.println(answ);
        }
    }


    /**
     * 5. 특정 문자 뒤집기 (toCharArray())
     */
    public static void question1_5Solve(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        int left = 0;
        int right = str.length()-1;

        char[] chars = str.toCharArray();
        while(left < right) {
            char tmp = chars[left];
            char tmp2 = chars[right];
            if(!Character.isAlphabetic(tmp)) {
                left++;
            } else if(!Character.isAlphabetic(tmp2)) {
                right--;
            } else {
                chars[left] = tmp2;
                chars[right] = tmp;
                left++;
                right--;
            }
        }
        String answer = String.valueOf(chars);
        System.out.print(answer);
    }


    /**
     * 6. 중복문자제거
     */
    public static void question1_6Solve(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        String input = sc.next();
        char[] chArr = input.toCharArray();
        Set<String> chSet = new HashSet<>();
        List<String> chList = new ArrayList<>();
        chSet.add(String.valueOf(chArr[0]));
        chList.add(String.valueOf(chArr[0]));   // Set만으로도 중복 제거는 가능하나, 순서때문에 ArrayList 사용
        for(int i=1; i<chArr.length; i++) {
            if(chSet.contains(String.valueOf(chArr[i]))) {
            } else {
                chList.add(String.valueOf(chArr[i]));
                chSet.add(String.valueOf(chArr[i]));
            }
        }
        for(String s : chList) {
            System.out.print(s);
        }
    }


    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.next();
        char[] chArr = input.toCharArray();
        Set<String> chSet = new HashSet<>();
        chSet.add(String.valueOf(chArr[0]));
        for(int i=1; i<chArr.length; i++) {
            if(chSet.contains(String.valueOf(chArr[i]))) {
            } else {
                chSet.add(String.valueOf(chArr[i]));
            }
        }
        for(String s : chSet) {
            System.out.print(s);
        }
    }*/


    public static void question1_6Answer(String[] args) {
        // indexOf()를 통해 찾는 String에서 char의 위치는 문자열에서 처음 발견된 위치를 알려준다
        Scanner sc = new Scanner(System.in);
//        String answer = "";
        StringBuilder ans = new StringBuilder();
        String input = sc.next();
        for(int i=0; i<input.length(); i++) {
            // indexOf()로 발견한 문자열의 위치와 반복문의 위치를 비교하는 방법으로 접근
            if(i == input.indexOf(input.charAt(i))) {
                // POINT i와 해당 char가 들어있는 index의 위치가 같다면, 처음 발견된 것이니 answer에 추가
//                answer += input.charAt(i);
                ans.append(input.charAt(i));
            }
        }
        System.out.println(ans);
    }


    /**
     * 7. 회문 문자열(Palindrom)
     */
    public static void question1_7Solve(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        str = str.toUpperCase();    // 대소문자 구별하지 않음
        int left = 0;
        int right = str.length() - 1;
        String isPalindrom = "YES";
        char[] chArr = str.toCharArray();
        while(left < right) {
            char tmp = chArr[left];
            if(tmp == chArr[right]) {
                left++;
                right--;
            } else {
                isPalindrom = "NO";
                break;
            }
        }
        System.out.println(isPalindrom);
    }

    // 문자열/2 만큼 반복하여 비교
    public static void question1_7Answer(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        str = str.toUpperCase();
        String answer = "YES";
        int len = str.length();
        for(int i=0; i<len/2; i++) {
            if(str.charAt(i) != str.charAt(len-i-1)) {
                answer = "NO";
                break;
            }
        }
        System.out.println(answer);
    }


    // StringBuilder의 reverse() 함수 사용
    public static void question1_7Answer2(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
//        str = str.toUpperCase();
        String reverseStr = new StringBuilder(str).reverse().toString();
//        if(str.equals(reverseStr)) System.out.println("YES");
        if(str.equalsIgnoreCase(reverseStr)) System.out.println("YES");     // POINT equalsIgnoreCase() 를 사용하여 대소문자 관계없이 비교
        else System.out.println("NO");
    }


    /**
     * 8. 팰린드롬(replaceAll 정규식 이용)
     */
    public static void question1_8Solve(String[] args) {
        Scanner sc = new Scanner(System.in);

        /* found7, time: study; Yduts; emit, 7Dnuof */
        String str = sc.nextLine();     // nextLine()이 아닌, next() 사용 시 공백에서 끊김
        // 알파벳 A~Z가 아닌(^) 것은 전부 공백("")으로 변경
        str = str.toUpperCase().replaceAll("[^A-Z]", "");

        String isPalindrom = "YES";
        int left = 0;
        int right = str.length()-1;
        char[] chArr = str.toCharArray();
        while(left < right) {
            char tmp = chArr[left];
            // 알파벳 이외의 문자들은 무시
            if(tmp == chArr[right]) {
                // Pass
            } else {
                isPalindrom = "NO";
                break;
            }
            left++;
            right--;
        }
        System.out.println(isPalindrom);
    }

    // replaceAll, StringBuilder의 reverse() 사용
    public static void question1_8Answer(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        str = str.toUpperCase().replaceAll("[^A-Z]", "");
        String reverseStr = new StringBuilder(str).reverse().toString();
        if(str.equals(reverseStr)) System.out.println("YES");
        else System.out.println("NO");
    }


    /**
     * 9. 숫자만 추출
     * ASCII 코드 x>=48 && x<=57 활용
     */
    public static void question1_9Solve(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String res = "";
        char[] chArr = str.toCharArray();
        for(int i=0; i<chArr.length; i++) {
            char tmp = chArr[i];
            if(!Character.isAlphabetic(tmp)) {
                res += String.valueOf(tmp);
            }
        }
        System.out.println(Integer.parseInt(res));
    }


    // ASCII코드와 char형이 정수형인 것을 이용
    public static void question1_9Answer(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int answer = 0;
        // POINT 문자열을 순서대로 탐색하면서, x>=48(숫자'0') && x<=57(숫자'9') 사이에 있다(숫자이다)
        for(char x : str.toCharArray()) {
            if(x>=48 && x<=57) {    // 숫자 ASCII코드 (0~9)
                answer = answer*10+(x - 48);
            }
        }
        System.out.println(answer);
    }


    public static void question1_9Answer2(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String answer = "";
        for(char x : str.toCharArray()) {
            // 숫자인지
            if(Character.isDigit(x)) {
                answer+=x;
            }
        }
        System.out.println(Integer.parseInt(answer));
    }


    /**
     * 10. 가장 짧은 문자거리
     */
    public static void question1_10Solve(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String s = st.nextToken();
        String t = st.nextToken();
        char T = t.charAt(0);       // 1자리 문자열이기때문에, String -> char에 str.charAt(0) 사용

        int[] answer = new int[s.length()];
        int p = 1000;

        // POINT 왼쪽에서 한 번 검사 후
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == T) {
                answer[i] = 0;
                p = 0;
            } else {
                p++;
                answer[i] = p;
            }
        }
        // POINT 오른쪽에서 다시 한 번 검사하며 기존의 값보다 작은 값을 넣어준다 (상대적으로 가장 짧은 거리)
        int q;
        if(answer[s.length()-1] == T) {
            q = 0;
        } else {
            q = answer[s.length()-1];
        }
        for(int i=s.length()-1; i>=0; i--) {
            if(s.charAt(i) != T) {
                q++;
                if(q < answer[i]) {
                    answer[i] = q;
                }
            } else {
                q = 0;
            }
        }
        for(int ans : answer) {
            System.out.print(ans+" ");
        }
    }


    public static void question1_10Answer(String[] args) {
        Scanner sc = new Scanner(System.in);
        // teachermode e
        String str = sc.next();
        char t = sc.next().charAt(0);

        int[] answer = new int[str.length()];
        int p = 1000;
        for(int i=0; i< str.length(); i++) {
            if(str.charAt(i) == t) {
                p = 0;
                answer[i] = p;
            } else {
                p++;
                answer[i] = p;
            }
            // 1001 0 1 2 3 0 1 2 3 4 0
        }

        p = 1000;
        for(int i= str.length()-1; i>=0; i--) {
            if(str.charAt(i) == t) {
                p = 0;
            } else {
                p++;
                answer[i] = Math.min(answer[i], p); // POINT Math.min(answer[i], p) 둘 중 작은 값을 넣어줌
            }
            // 1 0 1 2 1 0 1 2 2 1 0
        }

        for(int x : answer) {
            System.out.print(x+" ");
        }
    }


    /**
     * 11. 문자열 압축
     */
    public static void question1_11Solve(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // KKHSSSSSSSE
        String str = br.readLine();
        char[] cArr = str.toCharArray();
        String answer = "";

        char tmp = str.charAt(0);   // 시작문자(비교군)
        int repeatCnt = 1;
        for(int i=1; i<str.length()-1; i++) {
            if(tmp == cArr[i]) {
                repeatCnt++;
            } else {
                answer = answer + tmp;  // K2H
                tmp = cArr[i];          // S
                if(repeatCnt > 1) {
                    answer = answer + repeatCnt;
                    repeatCnt = 1;
                }
            }
        }
        System.out.println(answer);
    }


    // charAt(i)와 charAt(i+1)을 비교
    public static void question1_11Answer(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        String answer = "";
        s = s + " ";    // indexOutOfRange 오류 방지

        int cnt = 1;    // 반복횟수
        for(int i=0; i<s.length()-1; i++) {
            if(s.charAt(i) == s.charAt(i+1)) {  // POINT i와 i+1을 비교하고, 다르면 answer에 추가하고 cnt 초기화
                cnt++;
            } else {
                answer += s.charAt(i);
                if(cnt > 1) {
                    answer+= String.valueOf(cnt);
                    cnt = 1;
                }
            }
        }
        System.out.println(answer);
    }


    /**
     * 12. 암호 (replace(), parseInt(String, 2))
     */
    public static void question1_12Solve(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();       // 보낸 문자의 개수
        String str = sc.next();     // 문자의 개수의 7배 만큼의 # 또는 * 신호
//        4
//        #****###**#####**#####**##**
        String result = "";
        String word = "";
        for(int i=0; i<s*7; i++) {
            word += str.charAt(i);
            if(word.length() == 7) {
                word = word.replaceAll("#", "1");
                word = word.replaceAll("\\*", "0");
                // 1000111
                int c = Integer.parseInt(word, 2);  // POINT 2진수를 10진수로 변경
                result+= (char) c;      // 10진수 아스키번호를 char 문자로 변경

                word = "";
            }
        }
        System.out.println(result);
    }


    // substring(), replace() 사용
    // replace()와 replaceAll()의 차이는 replaceAll()은 정규식이 사용 가능하다
    public static void question1_12Answer(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String s = sc.next();

        String answer = "";
        for(int i=0; i<n; i++) {
            // 7글자를 추출해서, #과 *을 1과 0으로 변경
            String tmp = s.substring(0, 7).replace('#', '1').replace('*', '0');

            int num = Integer.parseInt(tmp, 2);     // 인자로 2진수 tmp를 줄테니 num이라는 정수로 변경해라

            answer += (char) num;

            s = s.substring(7); // POINT 7부터 끝까지 (7 글자 추출 후 앞의 7글자 제거)
        }
        System.out.println(answer);
    }
}
