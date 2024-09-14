### ArrayList

#### list의 마지막 값
```java
list.size() - 1
```
#### List 정렬
```java
Collections.sort(list);     // list 오름차순 정렬
Collections.sort(list, Collections.reverseOrder());   // list 내림차순 정렬
```
#### String[] → ArrayList
```java
Arrays.asList(strArr);
```
#### ArrayList<String> → String[]
```java
List<String> strList = new ArrayList<>();
String[] strArray = strList.toArray(new String[strList.size()]);
```
#### ArrayList<Integer> → int[]
```java
List<Integer> intList = new ArrayList<>();
intList.add(1);
intList.add(2);
intList.add(3);

// 방법 1
int[] arr1 = new int[intList.size()]
for (int i = 0 ; i < intList.size() ; i++) 
    arr1[i] = intList.get(i).intValue();

// 방법 2
int[] arr2 = intList.stream()
            .mapToInt(i -> i)
            .toArray();

// 방법 3
int[] arr3 = intList.stream()
            .mapToInt(Integer::intValue)
            .toArray();

// 방법 4
int[] arr4 = intList.stream()
            .filter(i -> i != null)
            .mapToInt(i -> i)
            .toArray();
```
#### 리스트 다루기
```java
List<String> strList = new ArrayList<>();

// 문자열 뒤집기
Collections.reverse(strList);
```
#### int[] → List<Integer>
```java
import java.util.List;
import java.util.stream.Collectors;   // 프로그래머스에서는 따로 추가해주지 않으면 찾지 못하는 듯

int[] arr = {1, 2, 3, 4, 5};
List<Integer> intList = Arrays.stream(arr).boxed().collect(Collectors.toList());
```