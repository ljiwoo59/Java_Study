import java.util.ArrayList;

public interface IProductMgr {
	void add(Product prod); // 상품정보 저장
	ArrayList<Product> search(); // 상품 전체 검색
	Product searchNo(int no); // 상품번호로 검색
	ArrayList<Product> searchModel(String model); // 상품명으로 검색 
	ArrayList<Product> searchTV(); // TV 만 검색
	ArrayList<Product> searchRefrig(); // Refrigerator 만 검색
	ArrayList<Product> searchRefrig400(); // 400L 이상의 Refrigerator 검색
	ArrayList<Product> searchTV50(); // 50inch 이상의 TV 검색
	void update(int no, double price) throws NoNotFoundException; // 상품 가격 변경 
	void deleteNo(int no); // 상품번호로 삭제
	double totalprice(); // 전체 재고 상품 금액
}
