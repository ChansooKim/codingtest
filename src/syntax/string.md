#### String.split()
```java
String[] strArr = String.split("");    // String -> String[] 변환
```

#### String.toCharArray()
```java
String str = "abcdefg";
for(Char ch : str.toCharArray()) {    // String -> char[] 변환
    System.out.println(ch);
}
```

#### Arrays.sort(String[])
```java
String[] strArr = new String[20];

Arrays.sort(strArr);   // 오름차순 정렬
Arrays.sort(strArr, Collections.reverseOrder());   // 내림차순 정렬
```

#### ArrayList to String
```java
List<String> list = new ArrayList<>();
String str = String.join("", arrayList);
```

#### startsWith() / endsWith()
```java
// startsWith는 문자열이 지정된 접두사(String suffix)로 끝나는지 검사
public int solution(String my_string, String is_suffix) {
    return myString.startsWith(is_suffix) ? 1 : 0;
}
// endsWith는 문자열이 지정된 접미사(String suffix)로 끝나는지 검사
public int solution(String my_string, String is_suffix) {
    return myString.endsWith(is_suffix) ? 1 : 0;
}
```


#### 문자열 다루기
```java
String str = "Programmers";

str.substring(0, s);   // 시작부터 s인덱스까지 절사
str.substring(e + 1);  // e부터 끝까지 절사

str.charAt(i);    // 인덱스에 해당하는 char 값을 반환
```

#### String to List
```java
String my_string = "CodingTest";

List<String> myList = new ArrayList<>(Arrays.asList(my_string.split("")));
```

#### Tips
```java
/* 두 정수 q, r과 문자열 code가 주어질 때, code의 각 인덱스를 q로 나누었을 때
나머지가 r인 위치의 문자를 앞에서부터 순서대로 이어 붙인 문자열을 return 하는 solution 함수를 작성하라 */
public String solution(int q, int r, String code) {
      StringBuilder sb = new StringBuilder();

      for (int i = r; i < code.length(); i += q)    // 정해진 크기만큼 증가한다면 i+=q로 q만큼 증가하게 사용할 수 있다
          sb.append(code.charAt(i));

      return sb.toString();
  }
```