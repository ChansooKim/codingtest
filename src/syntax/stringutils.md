
### StringBuilder
```java
StringBuilder answer = new StringBuilder(my_string.substring(s, e + 1);   // s부터 e까지 StringBuilder에 절사하여 담음

// StringBuilder에 담긴 String 뒤집기
String x = "abcde";
String reverse = new StringBuilder(x).reverse().toString(); // "edcba
```

### StringTokenizer
```java
//1. 띄어쓰기 기준으로 문자열을 분리
StringTokenizer st = new StringTokenizer(문자열);
 
//2. 구분자를 기준으로 문자열을 분리
StringTokenizer st = new StringTokenizer(문자열, 구분자);
 
/* 3. 구분자를 기준으로 문자열을 분리할 때 구분자도 토큰으로 넣는다. (true)
 * 구분자를 분리된 문자열 토큰에 포함 시키지 않는다. (false)
 * (디폴트 : false)
 */
 StringTokenizer st = new StringTokenizer(문자열 , 구분자 , true/false);

String str = "오늘!날씨는!맑음";
StringTokenizer st = new StringTokenizer(str, "!", true);

while (st.hasMoreTokens()) {
	System.out.println(st.nextToken());
}

```

| 리턴값 | 메소드 | 역할 |
| --- | --- | --- |
| boolean | hasMoreTokens() | 남아있는 토큰이 있으면 true를 리턴, 더 이상 토큰이 없으면 false 리턴 |
| String | nextToken() | 객체에서 다음 토큰을 반환 |
| String | nextToken(String delim) | delim 기준으로 다음 토큰을 반환 |
| boolean | hasMoreElements() | hasMoreTokens와 동일한데 엘리먼트보다 토큰으로 된 메서드를 주로 사용 |
| Object | nextElement() | nextToken 메서드와 동일하지만 문자열이 아닌 객체를 리턴 |
| int | countTokens() | 총 토큰의 개수를 리턴 |

### Scanner

```java
// 스캐너 객체 생성
Scanner sc = new Scanner(System.in);    // System.in은 입력한 값을 Byte 단위로 읽어주는 자바의 표준 입력 스트림

String str = sc.next();   // 입력받은 문자열을 str에 저장
```

| 메소드 | 설명 |
| --- | --- |
| next() | String을 읽음. 토큰(Token)을 기준으로 읽음 |
| nextLine() | String을 읽음. 개행(Enter)을 기준으로 읽음 |
| nextInt() | int 를 읽음 |
| nextBoolean() | boolean 을 읽음 |
| nextByte() | byte 를 읽음 |
| nextShort() | short 를 읽음 |
| nextLong() | long 을 읽음 |
| nextFloat() | float 을 읽음 |
| nextDouble() | double 을 읽음 |