# Exception Handling
![1520193587846](https://user-images.githubusercontent.com/54715744/127773464-7f5386c3-8676-4359-8f2d-89b134a70568.jpg)

* 어떤 원인에 의해 오동작 하거나 비정상적으로 종료되는 경우
* **Error**
  * 메모리 부족, stack overflow 와 같이 발생하면 복구할 수 없음
  * 프로그램의 비 정상적 종료를 막을 수 없음
* **Exception**
  * 읽으려는 파일이 없거나 네트워크 연결이 안되는 등 복구가 가능한 비교적 상태가 약한 것들
  * 프로그램 코드에 의해 수습될 수 있는 상황
  * **Checked Exception** : 예외에 대한 대처 코드가 없으면 컴파일이 되지 않음
    * *Non-Runtime Exception*
    * SQLException, IOException, FileNotFoundException...
  * **Unchecked Exception** : 예외에 대한 대처 코드가 없더라도 컴파일은 진행됨 
    * *Runtime Exception*
    * ArithmeticException...

## Throwable 의 주요 메소드
|메소드|설명|
|------|----|
|**public String getMessage()**|발생된 예외에 대한 구체적인 메세지를 반환|
|**public Throwable getCause()**|예외의 원인이 되는 Throwable 객체 또는 null 을 반환|
|**public void printStackTrace()**|예외가 발생된 메소드가 호출되기까지의 메소드 호출스택 출력|

## try ~ catch 구문
* 예외가 발생한 곳에서 **직접 처리**
```java
try { // 예외가 발생하면 JVM 이 해당 Exception 클래스의 객체 생성 후 던짐
  // 예외가 발생할 수 있는 코드
 } catch (XXException e) { // 던져진 Exception 을 처리할 수 있는 catch 블록에서 받은 후 처리
  // 예외가 발생했을 때 처리할 코드
 } // 정상적으로 처리되면 try-catch 블록을 벗어나 다음 문장 진행
```
### 다중 Exception Handling
* **try** 블록에서 여러 종류의 예외가 발생할 경우
  * 하나의 **try** 블록에 여러 개의 **catch** 블록 추가 가능
* 상위 타입의 예외가 먼저 선언되는 경우 뒤에 등장하는 **catch** 블록은 동작할 기회가 없음 (다형성 적용)
  * 상속 관계에서는 작은 범위(자식) 에서 큰 범위(조상) 순으로 정의

### try ~ catch ~ finally 구문
* **finally** 는 예외 발생 여부와 상관 없이 언제나 실행
  * 중간에 *return* 을 만나는 경우도 **finally** 블록을 먼저 수행 후 리턴 실행
* 주요 목적: **try** 블록에서 사용한 리소스 반납

### try-with-resources
* JDK 1.7 이상에서 리소스의 자동 ***close*** 처리
* **try** *선언문*에 선언된 객체들에 대해 자동 ***close*** 호출 (**finally** 역할)
  * 단 해당 객체들이 *AutoCloseable* interface 를 구현할 것
    * 각종 I/O stream, socket, connection...
  * 해당 객체는 **try** *블록* 에서 다시 할당될 수 없음

## throws 키워드
* 메소드에서 처리해야 할 하나 이상의 *예외*를 **호출한 곳** 으로 전달 (**처리 위임**)
  * 예외가 없어지는 것이 아니라 단순히 전달됨
  * 예외를 전달받는 메소드는 다시 예외 처리의 책임 발생
  * 처리하려는 예외의 조상 타입으로 ***throws*** 처리 가능
    * *throws* Exception
* **Checked Exception** 은 반드시 ***try ~ catch*** 또는 ***throws*** 필요
* **Runtime Exception** 은 ***throws*** 하지 않아도 전달 되지만 ***try ~ catch*** 로 처리
* 메소드 재정의 시 조상클래스 메소드가 던지는 예외보다 부모 예외를 던질 수 없다

---

## 사용자 정의 예외
* API 에 정의된 Exception 이외에 필요에 따라 사용자 정의 예외 클래스 작성
* 대부분 **Exception** 또는 **RuntimeException** 클래스를 상속 받아 작성
  * *Checked Exception* : 명시적 예외 처리 또는 *throws* 필요
  * *Runtime Exception* : 묵시적 예외 처리 가능
* 객체의 활용 - 필요한 추가정보, 기능 활용 가능
* 코드의 재사용 - 동일한 상황에서 예외 객체 재사용 가능
* *throws* 매커니즘의 이용 - 중간 호출 단계에서 return 불필요

---
## [Product_Management](https://github.com/ljiwoo59/Java_Study/tree/main/Java_OOP/ProductManage)
* 재고 관리 프로그램 구현

