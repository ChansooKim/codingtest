### Deque

- Deque(Double Ended Queue)는 양방향 대기열이라고도 불리는 자료구조
- 양방향으로 열려있는 구조로 Queue와 외형적으로 비슷한 구조이나, Stack과 Queue와 달리 LIFO, FIFO 같은 순서에 구숙되지 않음
- 양쪽으로 데이터를 추가하고, 삭제할 수 있어 Stack과 Queue를 구현할 수 있다

```java
// import
import java.util.Deque;
import java.util.LinkedList;

// 선언
Deque<Integer> deque = new LinkedList<>();
Deque<Integer> dq = new ArrayDeque<>();

// 삽입
deque.add(1);           // 마지막에 원소를 삽입, 용량 초과 시 Exception 발생
deque.addFirst(1);      // 맨 앞에 원소를 삽입, 용량 초과 시 Exception 발생
deque.addLast(1);       // 마지막에 원소를 삽입, 용량 초과 시 Exception 발생
deque.offer(2)          // 마지막에 원소를 삽입, 삽입 성공 시 true, 용량 초과 시 false 리턴
deque.offerFirst(2);    // 맨 앞에 원소를 삽입, 삽입 성공 시 true, 용량 초과 시 false 리턴
deque.offerLast(2);     // 마지막에 원소를 삽입, 삽입 성공 시 true, 용량 초과 시 false 리턴

// 삭제
deque.remove();         // 맨 앞의 원소 제거 후 해당 원소를 리턴, 공백 덱인 경우 Exception 발생
deque.removeFirst();    // 맨 앞의 원소 제거 후 해당 원소를 리턴, 공백 덱인 경우 Exception 발생
deque.removeLast();     // 마지막 원소 제거 후 해당 원소를 리턴, 공백 덱인 경우 Exception 발생
deque.poll();           // 맨 앞의 원소 삭제 후 삭제된 값을 반환, 공백 덱인 경우 null 리턴
deque.pollFirst();      // 맨 앞의 원소 삭제 후 삭제된 값을 반환, 공백 덱인 경우 null 리턴
deque.pollLast();       // 마지막 원소 삭제 후 삭제된 값을 반환, 공백 덱인 경우 null 리턴

// 값 확인
deque.getFirst();       // 맨 앞의 원소를 리턴, 공백 덱인 경우 Exception 발생
deque.getLast();        // 마지막 원소를 리턴, 공백 덱인 경우 Exception 발생
deque.peek();           // 맨 앞의 원소를 리턴, 공백 덱인 경우 null 리턴
deque.peekFirst();      // 맨 앞의 원소를 리턴, 공백 덱인 경우 null 리턴
deque.peekLast();       // 마지막 원소를 리턴, 공백 덱인 경우 null 리턴

// 덱의 크기
deque.size();

// 덱 검색
deque.contains(1);   // 해당 값이 존재하면 true, 없으면 false 반환

// 공백 검사
deque.isEmpty();     // 공백 덱이면 true, 공백 큐가 아니면 false 반환
```

<a href="https://www.geeksforgeeks.org/deque-interface-java-example/">Docs</a>