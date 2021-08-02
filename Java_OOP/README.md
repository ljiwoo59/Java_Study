# 객체지향 프로그래밍
블록 형태의 모듈화된 프로그래밍
* 신뢰성, 추가/수정/삭제 용이, 재사용성, 유지보수성 <br>

현실의 객체가 갖는 속성과 기능이 **추상화 (abstraction)** 되어 *클래스*에 정의된다 <br>
*클래스*는 **구체화** 되어 *프로그램의 객체 (instance, object)* 가 된다 <br>

## 클래스
### 멤버 변수 (상태, 속성)
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
### 멤버 메소드 (기능, 행위)
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
* [**Lambda**](https://github.com/ljiwoo59/Java_Study/blob/main/Java_OOP/LambdaTest.java)
  * 식별자 (함수 이름) 없이 실행 가능한 메소드
  * (*parameter* ...)->{실행문}

### Constructor (생성자)
* 클래스 이름과 동일한 이름의 함수 (리턴 타입은 없음)
* 객체 생성 시에 호출
* **this()** : 생성자에서 다른 생성자 호출
* **super()** : 생성자에서 부모 생성자 호출

### Inner Class
* *Top Level Class* 안의 클래스를 ***Inner Class*** 라 한다
* **Static Class**
* **Local Class**
* [**Member Class**](https://github.com/ljiwoo59/Java_Study/blob/main/Java_OOP/MyCar.java)
  * 객체를 사용하기 위해서는 *Top Level Class* 객체가 먼저 생성되어야 함
* [**Anonymous Class**](https://github.com/ljiwoo59/Java_Study/blob/main/Java_OOP/MyTablet.java)
  * 추상 인터페이스/클래스를 상속 받는 자식 클래스의 정의 및 객체 생성을 하지 않고 해당 인터페이스/클래스의 추상 메소드를 사용하고자 하는 곳에 정의한다

## 객체
클래스를 데이터 타입으로 메모리에 생성된 것 <br>
```java
Test t = new Test();
```
* heap 에 객체를 위한 공간 할당
* instance 변수 자동 초기화 | 명시적 초기화 (사용자가 지정한 값)
* 생성자 호출
* 참조값 반환 (주소값)
---
## Java is A P.I.E
* **Abstraction (추상화)** : 현실의 객체를 추상화 해서 클래스를 구성
* **Polymorphism (다형성)** : 하나의 객체를 여러가지 타입(형) 으로 참조
* **Inheritance (상속)** : 부모 클래스의 자산을 물려받아 자식을 정의함으로 코드의 재사용 가능
* **Encapsulation (데이터 은닉과 보호)** : 데이터를 외부에 직접 노출시키지 않고 메소드를 이용해 보호

## Inheritance
***is a* 관계** <br>
* 기존의 클래스의 자산을 자식 클래스에서 재사용하기 위한 것
  * 부모의 생성자와 초기화 블록은 상속하지 않음
    * 생상자는 상속받지 않지만 자식 인스턴스를 생성하면 자동 호출
    * 부모 객체가 먼저 생성 됨 으로서 부모 생성자가 먼저 호출
    * 부모 생성자가 매개 변수를 가지고 있으면 자동으로 호출되지 않음
* 부모의 코드를 변경하면 모든 자식들에게도 적용
* ***extends*** 키워드 사용

### Single Inheritance (단일 상속)
* Java 는 단일 상속만 지원
  * ***Interface*** 와 **포함관계 (*has a*)** 사용 가능
    * 포함 관계란 클래스에서 특성을 가져올 때 멤버 변수로 처리하는 것
* 부모 타입의 객체를 자식 타입으로 생성 시, **Override** 된 메소드를 제외하곤 쓸 수 없음
* 다중 상속의 경우 여러 클래스의 기능을 물려받을 수 있으나 관계가 복잡해짐

### Method Overriding
* 조상 클래스에 정의된 메소드를 자식 클래스에 적합하게 수정하는 것
  * **메소드 이름**이 같아야 한다
  * **매개 변수의 개수, 타입, 순서**가 같아야 한다
  * **리턴 타입**이 같아야 한다
  * **접근 제한자**는 부모 보다 범위가 넓거나 같아야 한다
  * 조상보다 더 큰 **예외**를 던질 수 없다
* Annotation : @Override
  * 컴파일러에게 해당 메소드는 Override 한 메소드임을 알려줌
  * 반드시 super class 에 선언되어있는 메소드여야 함

### Object Class
* 가장 최상위 클래스로 모든 클래스의 조상
* ***toString()*** : 객체를 문자열로 변경
  * String 클래스에서 주소값이 아닌 내용 반환으로 재정의함
* ***equals(Object obj)*** : 두 객체가 같은지를 비교
  * String 클래스에서 주소값이 아닌 내용 비교로 재정의함
  * 객체의 주소 비교는 == 활용
* ***hashCode()*** : 시스템에서 객체를 구별하기 위해 사용되는 정수 값
  * HashSet, HasMap 등 에서 객체의 동일성을 확인하기 위해 사용
  * equals 메소드를 재정의 할 때는 반드시 *hashCode* 도 재정의 할 것
 ---
 ## Encapsulation
 * 변수는 ***private*** 접근 제한자로 막을 수 있음
 * ***public*** 메소드를 통한 접근 통로 마련 : **setter / getter**

### Modifier (제한자)
* 클래스, 변수, 메소드 선언부에 사용되어 부가적인 의미 부여
* 하나의 대상에 여러 제한자를 조합 가능하나 **접근 제한자** 는 *하나* 만 사용 가능
* 종류
  * **접근 제한자** : *public, protected, default, private*
  * *static* : 클래스의 레벨 요소 설정
  * *final* : 요소를 더 이상 수정할 수 없음
    * *final class* : 상속 금지, Override 금지
    * *final method* : Override 금지
    * *final variable* : 상수화
  * *abstract* : 추상 메소드 및 추상 클래스
  * *synchronized* : 멀티스레드에서의 동기화 처리

#### Access Modifier (접근 제한자)
|제한자|같은 클래스|같은 패키지|다른 패키지의 자식 클래스|전체|
|:----:|:---------:|:---------:|:----------------------:|:--:|
|**public**|O|O|O|O|
|**protected**|O|O|O||
|**default**|O|O|||
|**private**|O||||

* **Method Override** 는 부모의 제한자 범위와 넓거나 같은 범위로만 사용 가능

### Singleton 디자인 패턴
* 객체의 생성 제한
  * 객체를 구별할 필요가 없는 경우 (stateless 객체)
  * 객체를 계속 생성 / 삭제 하는데 많은 비용이 들어 재사용이 유리한 경우
* 외부에서 생성자에 접근 금지
  * 생성자의 접근 제한자를 ***private*** 으로 설정
* 내부에서 직접 객체 생성
  * 멤버 변수이므로 ***private*** 설정
* 외부에서 *private member* 에 접근 가능한 **getter** 생성 (setter 는 불필요)
* 객체 없이 외부에서 접근할 수 있도록 **getter** 와 **변수** 에 ***static*** 추가
* 외부에서는 언제나 **getter** 를 통해 객체를 참조하므로 하나의 객체 재사용

---
## Polymorphism (다형성)
* 하나의 객체가 많은 형(타입)을 가질 수 있는 성질
* 조상 클래스의 타입으로 자식 클래스 객체를 참조 할 수 있음
* 다른 타입의 객체를 다루는 배열
  * Object 배열은 어떤 타입의 객체라도 다 저장할 수 있음
    * Collection API
* 매개변수의 다형성
  * Object 타입을 파라미터로 받는다는 것은 모든 객체를 처리한다는 것

### 참조형 객체의 형 변환
* 참조하는 변수의 타입에 따라 접근할 수 있는 내용이 제한됨
* 자식에서 부모로 : **묵시적 캐스팅**
* 부모에서 자식으로 : **명시적 캐스팅**
  * 부모 타입으로 생성된 객체는 캐스팅된 자식의 메소드를 쓸 수 없음
* ***instanceof*** 연산자로 실제 메모리에 있는 객체가 특정 클래스 타입인지 *boolean* 으로 리턴 
* 상속 관계에서 객체의 *멤버 변수*가 중복될 때
  * 참조 변수의 타입에 따라 연결이 달라짐
* 상속 관계에서 객체의 *메소드*가 중복될 때 (Override 되었을 때)
  * 무조건 자식 클래스의 메소드가 호출됨
---
## Abstract Class
* **추상 메소드**를 가지는 클래스
 *  추상 메소드 : 함수의 body 가 없는 미완성의 함수 (구현부는 ; 로 대체)
 *  일반 메소드만도 가질 수 있으나 추상 메소드가 하나 이상 이면 **무조건** 추상 클래스 여야만 함
* **상속** 전용 클래스
 * 객체를 생성할 수 없음
 * 자식을 참조할 수 있음
 * 자식 클래스에서 *abstract* 메소드를 재정의 하지 않은 경우, 해당 자식 클래스는 추상 클래스
* 구현의 강제를 통해 프로그램의 안전성 향상
* *Interface*에 있는 메소드 중 구현할 수 있는 메소드를 구현해 개발의 편의 지원

## Interface
* 최고 수준의 추상화 단계 : 모든 메소드가 ***abstract*** 형태 
  * JDK 8 이상부터 default method 와 static method 구현 가능
    * **default method** : 인터페이스에 선언 된 구현부가 있는 일반 메소드
      * 접근 제한자는 ***public*** 으로 한정 (생략 가능)
      * 기존 *interface* 기반으로 동작하는 라이브러리의 *interface*에 추가해야 하는 기능 발생 시
      * ***super* class** 의 메소드 우선 : super class 가 구체적인 메소드를 갖는 경우 default method 무시
      * 다른 *interface* 에서 동일한 이름의 메소드를 정의했을 때 *sub* class 는 반드시 **Override**
    * **static method** : 인터페이스에 선언 된 static 메소드
      * 별도의 객체가 필요 없음
      * 구현체 클래스 없이 바로 인터페이스 이름으로 메소드에 접근해서 사용 가능
* 모든 **멤버 변수**는 ***public static final*** 이며 생략 가능
* 모든 **메소드**는 ***public abstract*** 이며 생략 가능
* 인터페이스는 다른 인터페이스를 **extends**를 이용해 상속 가능
  * 다중 상속 가능
* 클래스에서 **implements** 를 이용해 ***interface*** 구현
  * 모든 ***abstract*** 메소드를 **Override** 해서 구현하거나
  * 구현하지 않을 경우 ***abstract* class**로 표시해야 함
  * 다중 ***interface* implements** 가능
  * 다형성은 조상 인터페이스에도 적용
* 구현의 강제로 표준화 처리
* 인터페이스를 통한 간접적인 클래스 사용으로 손쉬운 모듈 교체 지원
* 서로 상속의 관계가 없는 클래스들에게 인터페이스를 통한 관계 부여로 다형성 확장
* 모듈 간 독립적 프로그래밍 가능

## Generic
* 다양한 **타입**의 객체를 다루는 메소드나 컬렉션 클래스에 컴파일 시의 타입 체크를 해주는 기능
  * 미리 사용할 타입을 명시해서 형 변환을 하지 않아도 됨
  * 객체의 타입에 대한 안전성 향상 및 형 변환의 번거로움 감소
* **클래스**또는 **인터페이스** 선언시 <> 에 타입 파라미터 표시
  * 변수 쪽과 생성 쪽의 타입은 반드시 같아야함
```java
Class_Name<String> generic1 = new Class_Name<String>();
Class_Name<Integer> generic2 = new Class_Name<>(); // 생략 가능
```
* 필요에 따라 구체적인 타입 제한 필요
  * 인터페이스로 제한할 경우도 ***extends*** 사용
  * 클래스와 함께 인터페이스 제약 조건을 이용할 경우 & 로 연결
```java
class TypeRestrict1<T extends Number>{}
class TypeRestrict2<T extends Number & Comparable<String>>{}
```
* **Generic method** : 파라미터와 리턴 타입으로 타입 파라미터를 갖는 메소드
  * 메소드 리턴 타입 앞에 타입 파라미터 변수 선언
```java
public <P> void method1(P p) {}
public <P> P method2(P p) {return p;}
```
---
## [Product_Management](https://github.com/ljiwoo59/Java_Study/tree/main/Java_OOP/ProductManage)
* 재고 관리 프로그램 구현

 
