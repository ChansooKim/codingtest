### Stack

- 한 쪽 끝에서만 데이터를 넣고 뺄 수 있는 제한적으로 접근 가능한 선형 자료구조
- 후입선출 구조 (LIFO, Last-In-First-Out)로 마지막에 삽입한 원소는 맨 위에 쌓여 있다가 가장 먼저 삭제된다

```java
// import
import java.util.Stack;

// 선언
Stack<Integer> stack = new Stack<>();

// 삽입
stack.push(1);      // 삽입 후 삽입한 값을 반환한다
stack.add(2);       // 삽입 후 성공 시 true, 실패 시 false(StackOverFlow) 반환

// 삭제
stack.pop();        // 맨 위의 값을 삭제 후 삭제한 값을 반환, 공백 스택인 경우 Exception(EmptyStackException) 발생
stack.remove(0);    // 원하는 인덱스를 삭제 후 삭제한 값을 반환, 옳지 않은 인덱스 입력 시 ArrayIndexOutOfBoundsException 발생 

// 스택의 top에 있는 원소 반환
stack.peek();       // stack의 최상단에 존재하는 값을 반환한다

// 크기
stack.size();

// 공백 스택 검사
stack.isEmpty();

// 원소 검사
stack.search(2);     // 해당 원소가 존재하는지 검색 후 top에서부터 몇 번째에 존재하는 지 반환, 존재하지 않으면 -1 반환

// 값 변경
stack.set(0, 4);     //stack.set(index, 변경할 값) - 해당하는 index의 값을 변경할 값으로 변경 

// 인덱스에 해당하는 값 반환
stack.elementAt(0);  // 존재 시 해당 인덱스 값 반환, 올바르지 않은 인덱스 입력 시 ArrayIndexOutOfBoundsException 발생

// 스택 초기화
stack.clear();

```