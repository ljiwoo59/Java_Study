# Product_Management
재고 관리 프로그램 구현 <br>

### Product 클래스
* 상품 공통 정보를 담는 클래스
  * 제품번호, 제품명, 가격 정보, 재고수량

### TV 클래스
* **Product** 를 상속 받음
* 추가정보 : 인치, 디스플레이타입

### Refrigerator 클래스
* **Product** 를 상속 받음
* 추가정보 : 용량

### IProductMgr 인터페이스
* 상품정보 (TV 와 Refrigerator) 저장
* 상품정보 전체 검색
* 상품번호로 검색
* 상품명으로 검색 (부분 검색 가능)
* TV 만 검색
* Refrigerator 만 검색
* 400L 이상의 Refrigerator 검색
* 50inch 이상의 TV 검색
* 상품번호와 가격을 입력 받아 상품 가격을 변경
* 상품번호로 삭제
* 전체 재고 상품 금액

### ProductMgr 클래스
* IProductMgr 을 상속받는 Singleton
* *static* ArrayList 를 이용하여 상품 관리

### ProductTest 클래스
* 구현 기능 테스트

### NoNotFoundException 클래스
* 상품번호 
