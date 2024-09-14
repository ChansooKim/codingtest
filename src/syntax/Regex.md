
### 정규식 문법 (Regex)
| \\ | 백슬래시(\) 문자 |
| --- | --- |
| \t | tab(탭) 문자 |
| \n | newline 문자(ex. 엔터) |
| \r | carriage-return 문자 |
| \d | 숫자 : [0-9] |
| \D | 숫자를 제외한 모든 문자 : [^0-9] |
| \s | 공백 문자 : [ \t\n\x0B\f\r] |
| \S | 공백이 아닌 문자 : [^\s] |
| \w | 숫자나 영어, _(under-bar) : [a-zA-Z_0-9] |
| \W | 숫자나 영어, _가 아닌 모든 문자 : [^\w] |
| . | 모든 문자 |

```java
input = replactAll("\\s+", " ");    // 1개 이상의 공백문자를 1개의 공백문자로 변경
```

### printf 표현식
| format | 설명 |
| --- | --- |
| %s | String 형식으로 출력 |
| %d | 정수 형식으로 출력 |
| %n | 줄바꿈 |
| %f | float 형식으로 출력 |
| %t | date, time 형식으로 출력 |
| %o | 8진수 정수의 형식으로 출력 |
| %x | 16진수 정수의 형식으로 출력 |
| %b | boolean 형식으로 출력 |
| %e | 지수 표현식의 형식으로 출력 |

```java
System.out.printf("%5.2f%n", 123.456);   // 123.45
System.out.prinft("%03d %n", 90);        // 090  -> 3자리를 차지하고 만약에 수가 3자리가 안되면 0을 채운다

```

```java
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
String input = br.readLine();

String[] strArr = input.split(" ");
double word1 = Double.parseDouble(strArr[0]);
double word2 = Double.parseDouble(strArr[1]);
double sumWord = word1 + word2;

// printf 사용
System.out.printf("%.6f%n", sumWord);
```