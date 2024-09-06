### Queue

- 삽입과 삭제의 위치가 제한된 유한 순서 리스트
- 선입선출 구조 (FIFO, First-In-Fist-Out)로 가장 먼저 삽입된 원소가 가장 먼저 삭제된다

```java
// import
import java.util.Queue;
import java.util.LinkedList;

// 선언
Queue Q = new LinkedList();
Queue<Integer> queue = new LinkedList<>();

// 삽입
queue.add(1);       // 삽입 성공 시 true 반환, 실패 시 Exception 발생
queue.offer(2);     // 삽입 성공 시 true, 실패 시 false 반환

// 삭제
queue.remove(1);    // 큐에 해당 값이 존재하면 해당 값 삭제 후 true, 존재하지 않으면 false 반환
queue.remove();     // 삭제 후 삭제된 값을 반환, 공백 큐 인 경우 Exception 발생 (NoSuchElementException)
queue.poll();       // 삭제 후 삭제된 값을 반환, 공백 큐 인 경우 null 반환

// 큐의 Head에 위치한 값 반환
queue.element();    // 큐의 head 값 반환, 공백 큐 인 경우 NoSuchElementException 발생
queue.peek();       // 큐의 head 값 반환, 공백 큐 인 경우 null 반환

// 큐 초기화
queue.clear();

// 큐의 크기
queue.size();

// 큐 검색
queue.contains(1);   // 해당 값이 존재하면 true, 없으면 false 반환

// 공백 큐 검사
queue.isEmpty();     // 공백 큐이면 true, 공백 큐가 아니면 false 반환

```