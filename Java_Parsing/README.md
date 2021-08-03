# Parsing
* 문서에서 필요한 정보를 얻기 위해 태그를 구별하고 내용을 추출하는 과정

## [SAX Parser](https://github.com/ljiwoo59/Java_Study/tree/main/Java_Parsing/SAXParser)
* **Simple API for XML parser**
 
![sax](https://user-images.githubusercontent.com/54715744/128015912-a63459fc-166e-4884-a758-338fd4a6c346.gif)

* 문서를 읽으면서 태그의 시작, 종료 등 **이벤트** 기반으로 처리하는 방식
* ***Handler***
  * **이벤트**가 발생했을 때 처리할 내용을 가지고 있는 객체

### SAX Event
* void **startDocument()**
* void **endDocument()**
* void **startElement(String uri, String localName, String qName, Attributes attributes)**
* void **endElement(String uri, String localName, String qName)**
* void **characters(char[] ch, int start, int length)**
  
## [DOM Parser](https://github.com/ljiwoo59/Java_Study/tree/main/Java_Parsing/DOMParser)
* **Document Object Model parser**

![dom](https://user-images.githubusercontent.com/54715744/128015681-6c312c34-16cb-4c73-934f-62e25384fc93.gif)

* 문서를 다 읽고 난 후 문서 구조 **전체**를 자료구조에 저장하여 탐색하는 방식
* ***DOM Tree***
  * 문서를 구성하는 모든 요소를 ***Node*** (태그, 속성, 값) 로 구성
  * 태그들은 *root* 노드를 시작으로 부모-자식 관계 구성

### DOM API
* String **getNodeName()**
* String **getNodeValue()**
* short **getNodeType()**
* Node **getParentNode()**
* NodeList **getChildNodes()**
* Node **getPreviousSibling()**
* Node **getNextSibling()**
* String **getTextContent()**
* NodeList **getElementsByTagName(String name)**
* String **getAttribute(String name)**
* String **getTagName()**
  
### SAX vs. DOM
* **SAX** 는 빠르지만 한번에 처리하기 때문에 다양한 탐색이 어려움
* **DOM** 은 다양한 탐색이 가능하지만 느리고 무거우며 큰 문서를 처리하기 어려움

---
# Swing
* Java Application 에서 사용되는 **GUI** 를 제공하는 추상적으로 정의된 컴포넌트 모음

## Container
* 다른 컴포넌트를 배치하기 위한 컴포넌트
* 다른 *Container* 를 포함할 수 있고 나중에 복합적인 Layout 을 구성할 수 있게 한다
* **JFrame** : 독립적으로 사용될 수 있으며 타이틀과 사이즈를 조절할 수 있는 버튼을 가짐
* **JPanel** : 반드시 다른 *Container* 에 포함되어야 하며 복합적인 Layout 구성에 사용

### 다른 Component
* **JButton** b
* **JLabel** l
* **JTextField** tf
* **JTable** table
* **JList** list

## Layout 과 LayoutManager
* **Layout** : *Component* 들을 *Container* 에 어떻게 배치할 것인가
* **LayoutManager** : *Container* 별로 *Container* 의 위치와 크기, 배치 방식을 결정하는 객체

### BorderLayout
* ***JFrame*** 의 기본 *Layout*

![borderlayout](https://user-images.githubusercontent.com/54715744/128023596-65866663-c5f8-4386-8a27-0d53898adca4.jpg)


* *North, South, West, East, Center* 에 각각의 컴포넌트를 배치
* 각 영역에는 하나의 컴포넌트를 담을 수 있고 중복해서 담을 경우 마지막에 담은 컴포넌트만 보임
* 크기를 조절할 때 *North* 와 *South* 는 좌우로, *East* 와 *West* 는 상하로, *Center* 은 양방향으로 늘어남
* 생성자에서 수직, 수평 간격 조절 가능
  * **setLayout(new BorderLayout(int hgap, int vgap))
* 컴포넌트를 배치할 때는 영역을 지정해야함
  * **BorderLayout.CENTER
* 사용하지 않는 공간은 크기가 0\*0 이고 *Center* 가 기본

## Event Handling
### Delegation Model (이벤트 처리 모델)
![si_q8](https://user-images.githubusercontent.com/54715744/128024051-046d21ee-ac29-4e11-a79e-a7b77683cf15.JPG)

* 실제로 이벤트가 일어나는 곳은 *Component* 지만 **EventListener** 를 등록시킨 후 위임받은 *handler* 클래스 내에서 이벤트 처리

### 이벤트 처리 클래스
#### XX Listener
* 이벤트 처리에 대한 메소드를 정의한 *interface* 로 *handler* 는 이를 구현
* 하나의 *component* 에 여러개의 *event handle* 을 붙일 수 있음
  * *implements* ActionListener, WindownListener

#### XX EventAdapter
* *Listener* 를 *implements* 할 경우 사용하지 않는 *event handler* 까지 구현해야 하는 단점 커버
* 상속받은 후 필요한 메소드만 ***Override*** 가능


