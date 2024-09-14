### Stream

#### IntStream
```java
// for문을 통한 구현
for(int i=1; i<=10; i++) {
		System.out.println(i);    // 1 ~ 10까지 출력
}

// IntStream을 통한 구현
IntStream.range(1, 11).forEach(System.out::println);       // 1 ~ 11의 전 까지 출력
IntStream.rangeClosed(1, 10).forEach(System.out::println); // 0 ~ 10까지의 근사값 (1~10 출력)
```

```java
/* 배열 안의 2가 모두 포함된 가장 작은 연속된 부분 배열을 return 하는 solution 함수 */
import java.util.stream.IntStream;
class Solution {
    public int[] solution(int[] arr) {
        int[] idx = IntStream.range(0, arr.length).filter(i -> arr[i] == 2).toArray();
        if (idx.length == 0) return new int[]{-1};
        return IntStream.rangeClosed(idx[0], idx[idx.length - 1]).map(i -> arr[i]).toArray();
    }
}
```