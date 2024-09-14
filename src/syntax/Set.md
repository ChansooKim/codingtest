### Set

- 순서가 보장되지 않는 자료구조
- 중복 값을 허용하지 않음
- null 값을 저장할 수 있음

```java
Set<String> phones = new HashSet<>();
phones.add("iPhone");
phones.add("Galaxy");
phones.add("Xiaomi");
phones.add("Blackberry");

phones.remove("Xiaomi");  // 인자 삭제

Set<String> endSales = new HashSet<>();
endSales.add("Blackberry");

phones.removeAll(endSales);  // Collection 아이템(List 등) 삭제

Boolean in_blackberry = phones.contains("Blackberry");  // Set 내 객체가 존재하는지 확인

Iterator<String> iterator = phones.iterator();    // Set의 모든 객체를 순회 (for문도 가능)
while(iterator.hasNext()) {
    System.out.println("remain phones: "+iterator.next());
}
```