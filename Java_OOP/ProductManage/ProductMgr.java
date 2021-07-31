import java.util.ArrayList;

public class ProductMgr implements IProductMgr{
	private static IProductMgr mgr = new ProductMgr();
	private static ArrayList<Product> p = new ArrayList<>();
	
	private ProductMgr() {};
	
	public static IProductMgr getInstace() {
		return mgr;
	}
	
	public void add(Product prod) { // 상품 저장 기능
		p.add(prod);
	}
	
	public ArrayList<Product> search() { // 상품 전체 검색
		return p;
	}
	
	public Product searchNo(int no) { // 상품번호 검색
		for (Product prod : p) {
			if (prod.getNo() == no)
				return prod;
		}
		return null;
	}
	
	public ArrayList<Product> searchModel(String model) { // 상품명 검색 (부분 검색 가능)
		ArrayList<Product> names = new ArrayList<>();
		if (model != null) {
			for (Product prod : p) {
				if (prod.getModel().contains(model))
					names.add(prod);
			}
		}
		return names;
	}
	
	public ArrayList<Product> searchTV() { // TV 만 검색
		ArrayList<Product> tv = new ArrayList<>();
		for (Product prod : p) {
			if (prod instanceof TV)
				tv.add(prod);
		}
		return tv;
	}
	
	public ArrayList<Product> searchRefrig() { // Refrigerator 만 검색
		ArrayList<Product> refrig = new ArrayList<>();
		for (Product prod : p) {
			if (prod instanceof Refrigerator)
				refrig.add(prod);
		}
		return refrig;
	}
	
	public void deleteNo(int no) { // 상품번호 삭제
		for (int i = 0; i < p.size(); i++) {
			if (p.get(i).getNo() == no)
				p.remove(i--);
		}
	}
	
	public double totalprice() {
		double total = 0;
		for (Product prod : p) {
			total += prod.getPrice() * prod.getRemain();
		}
		return total;
	}

	@Override
	public ArrayList<Product> searchRefrig400() {
		ArrayList<Product> refrig = new ArrayList<>();
		for (Product prod : p) {
			if (prod instanceof Refrigerator && ((Refrigerator) prod).getVolume() >= 400)
				refrig.add(prod);
		}
		return refrig;
	}

	@Override
	public ArrayList<Product> searchTV50() {
		ArrayList<Product> tv = new ArrayList<>();
		for (Product prod : p) {
			if (prod instanceof TV && ((TV) prod).getInch() >= 50)
				tv.add(prod);
		}
		return tv;
	}

	@Override
	public void update(int no, double price) throws NoNotFoundException{
		Product prod = searchNo(no);
		if (prod == null)
			throw new NoNotFoundException(no);
		prod.setPrice(price);
	}
}
