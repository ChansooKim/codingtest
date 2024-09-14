#### Arrays to List
```java
List<Integer> intList = new ArrayList<>(Arrays.asList());
```
```java
int[] numArr = {1, 2, 3, 4, 5};
int idx = 3;
Arrays.copyOfRange(numArr , 0, idx+1);   // Array의 0부터 idx까지의 범위를 복사한다
```
```java
/* 프로그래머스 - 리스트 자르기 예제 */
public int[] solution(int n, int[] slicer, int[] num_list) {
      int a = slicer[0];
      int b = slicer[1];
      int c = slicer[2];
      switch(n) {
          case 1:   // n = 1 : num_list의 0번 인덱스부터 b번 인덱스까지 
              return Arrays.copyOfRange(num_list, 0, b+1);
          case 2:   // n = 2 : num_list의 a번 인덱스부터 마지막 인덱스까지
              return Arrays.copyOfRange(num_list, slicer[0], num_list.length);
          case 3:   // n = 3 : num_list의 a번 인덱스부터 b번 인덱스까지
              return Arrays.copyOfRange(num_list, a, b+1);
          case 4:   // n = 4 : num_list의 a번 인덱스부터 b번 인덱스까지 c 간격으로
              int size = (slicer[1]-slicer[0])/slicer[2]+1;
              List<Integer> temp = new ArrayList<>();
              for(int i=slicer[0]; i<=slicer[1]; i+=slicer[2]) {
                  temp.add(num_list[i]);
              }
              return temp.stream().mapToInt(Integer::intValue).toArray();
      }
      return null;
  }
```