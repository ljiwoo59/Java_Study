import java.util.ArrayList;

public class ProductTest {

	public static void main(String[] args) {
		IProductMgr mgr = ProductMgr.getInstace();
		
		//상품정보 저장
		mgr.add(new Refrigerator(66, "R6", 2000, 1, 1000));
		mgr.add(new TV(1111, "T1", 400, 4, 524, "QHD"));
		mgr.add(new TV(4444, "T4", 100, 2, 15, "HD"));
		mgr.add(new Refrigerator(99, "R9", 150, 11, 700));
		mgr.add(new TV(2222, "T2", 600, 10, 65, "FHD"));
		mgr.add(new Refrigerator(11, "R1", 1000, 7, 50));
		
		System.out.println("--------상품 전체 검색--------");
		//상품 전체 검색
		ArrayList<Product> p = mgr.search();
		for (Product prod : p) 
			System.out.println(prod);
		System.out.println("---------상품번호 검색-------");
		//상품번호 검색
		System.out.println(mgr.searchNo(4444));
		System.out.println("--------상품명 검색 (부분 검색 가능)--------");
		//상품명 검색 (부분 검색 가능)
		p = mgr.searchModel("1");
		for (Product prod : p)
			System.out.println(prod);
		System.out.println("--------TV 만 검색--------");
		//TV 만 검색
		p = mgr.searchTV();
		for (Product prod : p)
			System.out.println(prod);
		System.out.println("--------Refrigerator 만 검색--------");
		//Refrigerator 만 검색
		p = mgr.searchRefrig();
		for (Product prod : p)
			System.out.println(prod);
		System.out.println("--------상품번호로 삭제--------");
		//상품번호로 삭제
		System.out.println("before remove");
		p = mgr.search();
		for (Product prod : p) 
			System.out.println(prod);
		System.out.println();
		System.out.println("after remove");
		mgr.deleteNo(4444);
		mgr.deleteNo(11);
		mgr.deleteNo(2222);
		p = mgr.search();
		for (Product prod : p) 
			System.out.println(prod);
		System.out.println("--------전체 재고 금액--------");
		//전체 재고 금액
		System.out.println(mgr.totalprice());
		System.out.println("--------400L 냉장고--------");
		p = mgr.searchRefrig400();
		for (Product prod : p)
			System.out.println(prod);
		System.out.println("--------50inch TV--------");
		p = mgr.searchTV50();
		for (Product prod : p)
			System.out.println(prod);
		System.out.println("--------가격변경--------");
		try {
			mgr.update(1111, 800);
			System.out.println(mgr.searchNo(1111));
		} catch (NoNotFoundException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("--------가격변경 (없는 번호)--------");
		try {
			mgr.update(91, 800);
			System.out.println(mgr.searchNo(91));
		} catch (NoNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

}
