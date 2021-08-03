# I/O
* 데이터 입/출력
* 데이터는 한쪽에서 주고 한쪽에서 받는 구조로 되어있음
  * 입력과 출력의 끝단 : *Node*
  * 두 *Node* 를 연결하고 데이터를 전송할 수 있는 개념 : ***Stream***
  * *Stream* 은 단방향으로만 가능

|구분|**Stream** 종류|
|:--:|:-------------:|
|**입력용/출력용**|InputStream|
||OutputStream|
|**입출력 단위**|Character Stream|
|(char / byte)|Byte Stream|
|**데이터입출력 방법**|Node(Sink) Stream|
|(직/간접)|Process Stream|

## Node Stream

|근원지/목적지|Byte Stream|Character Stream|
|:-----------:|:---------:|:--------------:|
|Memory|ByteArrayInputStream|CharArrayReader|
||ByteArrayOutputStream|CharArrayWriter|
|File|FileInputStream|FileReader|
||FileOutputStream|FileWriter|

### InputStream 의 주요 메소드
|메소드|설명|
|------|----|
|public abstract **int read()**|*Byte* 하나를 읽어서 *int* 로 변환. 읽을 값이 없으면 -1 리턴|
|public **int read(byte b[])**|데이터를 읽어서 *b* 를 채우고 읽은 바이트 개수 리턴. 읽을 값이 없으면 0 리턴|
|public **int read(byte b[], int offset, int len)**|최대 *len* 만큼 데이터를 읽어서 *b* 의 *offset* 부터 *b* 에 저장하고 읽은 바이트 개수 리턴|
|public **void close()**|스트림을 종료해서 자원 반납|

#### FileInputStream
* public **FileInputStream(String name)** : *name* 경로의 파일을 읽는 FileInputStream 을 생성

### Reader 의 주요 메소드
|메소드|설명|
|------|----|
|public abstract **int read()**|*char* 하나를 읽어서 *int* 로 변환. 읽을 값이 없으면 -1 리턴|
|public **int read(char cbuf[])**|데이터를 읽어서 *cbuf* 를 채우고 읽은 문자 개수 리턴. 읽을 값이 없으면 0 리턴|
|public **int read(char cbuf[], int offset, int len)**|최대 *len* 만큼 데이터를 읽어서 *cbuf* 의 *offset* 부터 *cbuf* 에 저장하고 읽은 문자 개수 리턴|
|public **int read(java.nio.CharBuffer target)**|데이터를 읽어서 *target* 에 저장. *target* 은 *cbuf* 를 대체함|
|public **void close()**|스트림을 종료해서 자원 반납|

### OutputStream 의 주요 메소드
|메소드|설명|
|------|----|
|public abstract **void write(int b)**|*b* 의 내용을 바이트로 출력|
|public **void write(byte b[])**|*b* 를 문자열로 변환해서 출력|
|public **void write(byte b[], int offset, int len)**|*b* 의 *offset* 부터 *offset + len - 1* 만큼을 문자열로 변환해 출력|
|public **void close()**|스트림을 종료해서 자원 반납. 내부적으로 ***flush()*** 호출|
|public **void flush()**|버퍼가 있는 스트림에서 버퍼의 내용을 출력 후 버퍼를 비움|

#### FileOutpustStream
* public **FileOutputStream(String name)** : *name* 경로의 파일에 출력하는 FileOutputStream 을 생성
* public **FileOutputStream(String name, boolean append)** : *name* 경로의 파일에 출력하는 FileOutputStream 을 생성. 기존에 파일이 있다면 뒤에 이어 씀

### Writer 의 주요 메소드
|메소드|설명|
|------|----|
|public **void write(int c)**|*c* 를 문자로 출력|
|public **void write(char cbuf[])**|*cbuf* 를 문자열로 변환해서 출력|
|abstract public **void write(char cbuf[], int offset, int len)**|*cbuf* 의 *offset* 부터 *offset + len - 1* 만큼을 문자열로 변환해 출력|
|public **void write(String str)**|*str* 을 출력|
|public **void write(String str, int offset, int len)**|*str* 의 *offset* 부터 *offset + len - 1* 만큼을 출력|
|public **Writer append(CharSequence csq)**|*csq* 를 출력하고 Writer 리턴|
|public **Writer append(CharSequence csq, int start, int end)**|*csq* 의 *start* 부터 *end* 까지를 출력하고 Writer 리턴|
|public **void close()**|스트림을 종료해서 자원 반납. 내부적으로 ***flush()*** 호출|
|abstract public **void flush()**|버퍼가 있는 스트림에서 버퍼의 내용을 출력 후 버퍼를 비움|

---

## Process Stream
* 다른 스트림에 부가적인 기능을 제공하는 스트림
  * 문자 set 변환
  * Buffering 을 통한 속도 향상
  * 기본 데이터 형의 전송
  * 객체 입출력
* Stream Chaining
  * 필요에 따라 여러 보조 스트림을 연결해서 사용 가능
  
### 종류

|처리|Byte Stream|Character Stream|
|:-:|:----------:|:--------------:|
|**버퍼링**|BufferedInputStream|BufferedReader|
||BufferedOutputStream|BufferedWriter|
|**자료변환**|DataInputStream||
|(기본자료형인식)|DataOutputStream||
|**객체직렬화**|ObjectInputStream||
|(객체입출력)|ObjectOutputStream||

#### 생성
* 단독으로 사용할 수 없음
* *Node Stream* 을 생성자의 파라미터에 연결
```java
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
```
#### 종료
* 보조 스트림의 ***close()*** 를 호출하면 노드 스트림의 ***close()*** 까지 호출 됨

### InputStreamReader & OutputStreamWriter
* ***byte*** 기반 스트림을 ***char*** 기반으로 변경해주는 스트림
  * 문자열을 관리하기 위해서는 *byte* 단위보다 *char* 단위가 유리
* 변환 시 encoding 지정 가능

|메소드|설명|
|------|----|
|public **InputStreamReader(InputStream in)**|기본 캐릭터 셋을 이용해 *InputStreamReader* 생성|
|public **InputStreamReader(InputStream in, String charsetName)**|*charsetName* 을 이용해 *InputStreamReader* 생성|
|public **InputStreamReader(IntputStream in, Charset cs)**|*cs* 를 이용해 *InputStreamReader* 생성|
|public **OutputStreamWriter(OuntputStream out)**|기본 캐릭터 셋을 이용해 *OutputStreamWriter* 생성|
|public **OutputStreamWriter(OutputStream out, String charsetName)**|*charsetName* 을 이용해 *OutputStreamWriter* 생성|
|public **OutputStreamWriter(OutputStream out, Charset cs)**|*cs* 를 이용해 *OutputStreamWriter* 생성|

### Buffered 계열
* 스트림의 입/출력 효율을 높이기 위해 버퍼를 사용하는 스트림

|메소드|설명|
|------|----|
|public **BufferedInputStream(InputStream in)**|*in* 을 이용해 크기가 8192 인 버퍼를 갖는 *BufferedInputStream* 생성|
|public **BufferedInputStream(InputStream in, int size)**|*in* 을 이용해 크기가 *size* 인 버퍼를 갖는 *BufferedInputStream* 생성|
|public **BufferedOutputStream(OutputStream out)**|*out* 을 이용해 크기가 8192 인 버퍼를 갖는 *BufferedOutputStream* 생성|
|public **BufferedOutputStream(InputStream out, int size)**|*out* 을 이용해 크기가 *size* 인 버퍼를 갖는 *BufferedOutputStream* 생성|

* BufferedReader & BufferedWriter 도 동일한 메소드
  * BufferedReader 의 **readLine()** 은 줄 단위로 데이터를 읽음
  
#### Scanner vs. BufferedReader
* *char* 형태의 데이터를 읽기 위한 클래스들
* **Scanner** : 자동 형변환을 지원하는 등 사용이 간편하지만 속도가 느림
* **BufferedReader** : 직접 스트림을 구성해야 하는 등 번거롭지만 속도가 빠름
  
### 객체 직렬화 (Serialization)
* 객체를 저장하거나 네트워크로 전송하기 위해 연속적인 데이터로 변환하는 것
* *Serializable interface* 를 구현할 것
* 클래스의 모든 멤버가 *Serializable interface* 를 구현해야 함
* 직렬화에서 제외하려는 멤버는 *transient* 선언
* **serialVersionUID**
  * 클래스의 변경 여부를 파악하기 위한 유일 키
  * 직렬화 할 때의 *UID* 와 역 직렬화 할 때의 *UID* 가 다를 경우 예외 발생
  * 직렬화 되는 객체에 *UID* 가 설정되지 않았을 경우 컴파일러가 자동 생성
    * 컴파일 시마다 변경 (InvalidCalssException 초래)
  * 직렬화되는 객체에 대해서 *serialVersionUID* 설정 권장

|메소드|설명|
|------|----|
|public **ObjectOutputStream(OutputStream out)**|*out* 을 이용해 *ObjectOutputStream* 생성|
|public final void **writeObject(Object obj)**|*obj* 를 직렬화해서 출력|
|public **ObjectInputStream(InputStream in)**|*in* 을 이용해 *ObjectInputStream* 생성|
|public final void **readObject(Object obj)**|직렬화된 데이터를 역직렬화해서 *Object* 로 리턴|

---
# IO vs. NIO

|구분|IO|NIO|
|---|--|---|
|**입출력**|*Stream* 방식 (InputStream과 OutputStream 필요)|*Channel* 방식 (Channel 하나로 양방향 소통)|
|**버퍼**|기본 버퍼를 지원하지 않음 (필요시 Buffered 계열 *Stream* 사용)|기본 버퍼 방식 (모든 데이터는 버퍼를 통해 가져옴)|
|**블로킹**|*Blocking*|*Blocking* or *Non-Blocking*|
||*read()*, *write()* 시 Blocking 되고 *close()* 되야 풀림|Interrupt 를 통해 thread 를 중지시킬 수 있음|
||해당 thread 를 interrupt 할 수 없음||

* **NIO** 는 다른 특성을 가진 **IO**
  * 여러 클라이언트 연결을 *non-blocking* 상태로 처리할 수 있어 효율적
  * 운영체제의 버퍼를 이용한 입출력으로 성능 개선
  * 다수의 클라이언트, 짧은 입출력 작업에 용이
  * Thread 병렬처리를 기본으로 하므로 *IO* 에 비해 복잡함
  * 대용량 처리, 소수의 클라이언트에는 *IO* 가 유리
  
