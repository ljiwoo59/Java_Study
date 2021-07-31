# Java_Basics
### Type
**Primitive Type (기본형)**
* 미리 정해진 크기의 Memory size 로 표현
* 변수 자체에 값 저장
* byte, short, int, long, float, double, boolean, char <br>

**Reference Type (참조형)**
* 미리 정해질 수 없는 데이터의 표현
* 변수에는 실제 값을 참조할 수 있는 주소만 저장 <br>

**Type Casting (형 변환)**
* 작은 데이터 타입에서 큰 데이터 타입으로는 **promotion** 가능 (묵시적 형 변환)
* 큰 데이터 타입에서 작은 데이터 타입으로는 형 변환 필요 (명시적 형 변환)
* *Primitive* 는 *Primitive* 끼리, *Reference* 는 *Reference* 끼리 가능
  * *boolean* 은 다른 기본 타입과 호환되지 않음
  * 기본 타입과 참조형의 형 변환을 위해서 *Wrapper* 클래스 사용
---
### Array

```java
// 1 차원 배열
int[] a = {1,2,3};
int b[] = {1,2,3};
int[] c = new int[]{1,3,5};
int[] d; d = new int[] {1,3,5}; // 선언할 때는 배열의 크기를 알 수 없을 때

// 2 차원 배열
int[][] a = {{1,2,3},{4,5,6}};

int[][] b = new int[4][]; // 4 * ? 배열
b[0] = new int[3];
b[1] = new int[4]; // 2차원 배열이 참조하는 1차원 배열의 크기는 다양할 수 있음
```
* 배열을 생성과 동시에 자료형에 대한 default 초기화 진행
  * boolean : false
  * char : 공백문자
  * byte, short, int : 0
  * long : 0L
  * float : 0.0f
  * double : 0.0
  * 참조형 변수 : null
* 응용
  * String 을 char 배열로 : **toCharArray()**
  * for 문을 통한 1차원 배열 출력 대신 : **Arrays.toString()**
  * for 문을 통한 2차원 배열 출력 대신 : **Arrays.deepToString()**
  * **System.arraycopy(Object src, int srcPos, Object dest, int destPos, int length)**
  * **Arrays.copyOf(Object src, int dest.length)**
* **for-each** with Array
  * **Naturally Read Only**
  * 가독성이 개선된 반복문으로 *index* 대신 직접 요소에 접근함

---
### 소금쟁이
* 소금쟁이는 3칸, 2칸, 1칸 씩 총 세번씩 순서대로 뛴다.
* 밖으로 나가거나 충돌한 소금쟁이는 죽는다.
* 배열의 *사방탐색*을 이용하여 구한다. <br>
#### 입력
* 테스트 케이스
* 배열의 크기, 소금쟁이 수
* 소금쟁이 수 만큼 시작위치 (행, 열), 방향 (1: 상, 2: 하, 3:좌, 4:우) <br>
#### 출력
* 살아있는 소금쟁이 수
