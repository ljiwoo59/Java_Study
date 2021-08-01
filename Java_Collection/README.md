# Collection Framework
* *java.util* 패키지
  * 다수의 데이터를 쉽게 처리하는 방법 제공
    * DB 처럼 CRUD 기능
## 핵심 Interface
![java-collection-framework-hierarchy](https://user-images.githubusercontent.com/54715744/127766655-8b336895-81f6-4e5e-9dde-f50947e9e833.jpg)
* **List** : 순서가 있는 데이터의 집합, 데이터 중복 **O**
  * ArrayList, LinkedList
* **Set** : 순서를 유지하지 않는 데이터의 집합, 데이터 중복 **X**
  * HashSet, TreeSet
* **Map** : ***key*** 와 ***value*** 쌍으로 데이터를 관리하는 집합
  * 순서는 유지되지 않으며 ***key*** 의 중복 **X**, ***value*** 는 중복 **O**
  * *Collection* 을 상속 받지 않음
  * HashMap, TreeMap
### 주요 메소드
|분류|Collection|
|:--:|:---------|
|**추가**|add(E e),|
|    |addAll(Collection<? *extends* E> c)|
|**조회**|contains(Object o),|
||containsAll(Collection<?> c),|
||equals(),|
||isEmpyt(),|
||iterator(),|
||size()|
|**삭제**|clear(),|
||removeAll(Collection<?> c),|
||retainAll(Collection<?> c)|
|**수정**||
|**기타**|toArray()|

## List
* 순서가 있는 데이터의 집합
* 순서가 있으므로 데이터의 중복을 허락
* 데이터 삭제시 주의
  * 요소가 삭제되면 size 가 줄어들기 때문에 *index* 차감, 혹은
  * 뒤에서 부터 접근하는 *for* 문 활용
* **ArrayList**
* **LinkedList**
* *Vector* (더 이상 쓰지 않음)

### 주요 메소드
|분류|Collection|List|
|:--:|:---------|:--|
|**추가**|add(E e),|add(int index, E element),|
|    |addAll(Collection<? *extends* E> c)|addAll(int index, Collection<? *extends* E> c)|
|**조회**|contains(Object o),|get(int index),|
||containsAll(Collection<?> c),|indexOf(Object o),|
||equals(),|lastIndexOf(Object o),|
||isEmpyt(),|listIterator()|
||iterator(),||
||size()||
|**삭제**|clear(),|remove(int index)|
||removeAll(Collection<?> c),||
||retainAll(Collection<?> c)||
|**수정**||set(int index, E element)|
|**기타**|toArray()|subList(int fromIndex, int toIndex)|

* 평균적으로 각 메소드의 수행 시간은 **O(n)** 이다

### [ArrayList vs. LinkedList](https://github.com/ljiwoo59/Java_Study/blob/main/Java_Collection/ArrayVsLinkedTest.java)
* 정적인 데이터 활용, 단순한 데이터 조회용 : **ArrayList**
* 동적인 데이터 추가, 삭제가 많은 작업 : **LinkedList**
#### ArrayList
* 접근 속도가 빠름
* 크기를 변경할 수 없어 추가 데이터를 위해 새로운 배열을 만들고 복사 해야함 (내부적으로)
* 데이터의 추가, 삭제에 많은 시간이 걸림

#### LinkedList
* 각 요소를 *Node* 로 정의하고 *Node* 는 다음 요소의 참조 값과 데이터로 구성됨
  * 각 요소가 다음 요소의 링크 정보를 가지며 연속적으로 구성될 필요가 없다

## Set
* 순서 없이 데이터를 넣는 형태
  * 순서가 없으므로 데이터를 구별할 *index* 가 없어 중복이 허용되지 않음
* Update 를 하지 못함
* 평균적으로 수행 시간은 **O(1)** 이다
* **HashSet**
* *SortedSet* (이진 트리로 정렬된 상태로 요소 관리)
  * *NavigableSet*
    * **TreeSet** 

## Map
* ***Key*** 와 ***Value*** 를 하나의 **Entry** 로 묶어서 데이터 관리
  * *Key* : 데이터의 중복을 허락하지 않음
  * *Value* : 데이터의 중복이 허락됨
* **HashMap**
* *SortedMap*
  * *NavigableMap*
    * **TreeMap**
* *HashTable* (더 이상 쓰지 않음)

### 주요 메소드
|분류|Map<K, V>|
|:--:|:---------|
|**추가**|put(K key, V value),|
|    |putAll(Map<? *extends* K, ? *extends* V> m)|
|**조회**|containsKey(Object key),|
||containsValue(Object value),|
||entrySet(),|
||keySet(),|
||get(Object key),|
||values(),|
||size(),|
||isEmpty()|
|**삭제**|clear(),|
||remove(Object key)|
|**수정**|put(K key, V value),|
||putAll(Map<? *extends* K, ? *extends* V> m)|

* *Collection* 메소드를 상속 받지 않음
  * *Entry* 메소드를 상속
* 이미 존재하는 *Key* 에 같은 *Key* 를 추가 시 마지막 *Value* 로 치환
* 평균적으로 수행 시간은 **O(1)** 이다
  * TreeMap 은 평균 **O(log n)**

---
## 정렬
* 요소를 특정 기준에 대한 내림차순 또는 오름차순을 배치 하는 것
* 순서를 가지는 *Collection*만 정렬 가능
  * **List** 계열
  * **SortedSet** 의 자식 객체
  * **SortedMap** 의 자식 객체 (*Key* 기준)
* **Collections.*sort*(List<T> list)**
  * 객체가 *Comparable* 을 구현하고 있는 경우 정렬 가능 (String, Integer)
  * 객체가 구현하고 있지 않은 경우, 비교 가능한 기준이 있다면 사용 (객체 안의 String 비교)
* **Comprator** 활용
  * 객체가 *Comparable* 을 구현하고 있지 않거나 사용자 정의 알고리즘으로 정렬하려는 경우
  * *sort*(List<T> list, *Comparator*<? Super T> c)
```java
public class StringLengthComparator implements Comparator<String> { // 글자 수 별로 정렬
    @Override
    public int compare(String o1, String o2) {
        int len1 = o1.length();
        int len2 = o2.length();
        return Integer.compare(len1, len2);
    }
}

public void stringLengthSort() {
  Collections.sort(names, new StringLengthComparator());
}
```

