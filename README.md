# Java_Study
## [기본 및 응용](https://github.com/ljiwoo59/Java_Basics)
* Type
* Array

## 객체지향 프로그래밍
블록 형태의 모듈화된 프로그래밍
* 신뢰성, 추가/수정/삭제 용이, 재사용성, 유지보수성 <br>

현실의 객체가 갖는 속성과 기능이 **추상화 (abstraction)** 되어 *클래스*에 정의된다 <br>
*클래스*는 **구체화** 되어 *프로그램의 객체 (instance, object)* 가 된다 <br>

### 클래스
#### 멤버 변수 (상태, 속성)
* 전역 변수 이므로 자동 초기화
* **인스턴스 멤버 변수**
  * heap 에 객체 수 만큼 저장
  * 객체 생성 후 객체 이름으로 접근
  * 객체를 만들 때 마다 객체 별로 생성
  * Garbage Collector 에 의해 객체가 없어질 때 소멸
    * 프로그래머가 명시적으로 소멸시킬 수 없음 
* **클래스 멤버 변수**
  * **static** : 객체들 간에 공유 되는 유일한 값
    * Class Area 에 단 하나만 저장
    * 모든 객체가 공유
    * 객체 생성 없이 클래스 이름으로 사용가능
    * 멤버 필드, 메소드, 블록에 사용가능
  * 프로그램 종료 시 소멸
#### 멤버 메소드 (기능, 행위)
* **지역 변수**
  * 선언 된 라인이 실행될 때 생성 : thread 별로 생성된 stack 영역
  * 명시적 초기화 필요
  * 외부에서 접근 불가
  * 선언된 영역인 {} 를 벗어날 때 소멸
* **Variable arguments**
   * 메소드 선언 시 몇개의 인자가 들어올 지 예상할 수 없는 경우
   * ... 을 이용해 파라미터를 선언하면 호출 시 넘겨준 값의 개수에 따라 자동으로 배열 생성 및 초기화
```java
public void variableArgs(int... params) {}
```
* **Call by Value**
  * 메소드 호출 시 파라미터로 입력된 *값*을 **복사** 해서 전달
* **Method Overloading**
  * 동일한 기능을 수행하는 메소드의 *추가 작성* 
  * 중복 코드에 대한 효율적 관리 가능
  * 메소드의 이름은 동일하지만 파라미터의 개수 또는 순서, 타입이 달라야 함
  * 리턴 타입은 의미 없음

#### Constructor (생성자)
* 클래스 이름과 동일한 이름의 함수 (리턴 타입은 없음)
* 객체 생성 시에 호출
* **this()** : 생성자에서 다른 생성자 호출
* **super()** : 생성자에서 부모 생성자 호출

---
### 객체
클래스를 데이터 타입으로 메모리에 생성된 것 <br>
```java
Test t = new Test();
```
* heap 에 객체를 위한 공간 할당
* instance 변수 자동 초기화 | 명시적 초기화 (사용자가 지정한 값)
* 생성자 호출
* 참조값 반환 (주소값)
