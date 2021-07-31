class Product {
	int model_no;
	String model;
	double price;
	int remain;
	
	public Product(int model_no, String model, double price, int remain) {
		this.model_no = model_no;
		this.model = model;
		this.price = price;
		this.remain = remain;
	}

	public String toString() {
		return "model_no=" + model_no + ", model=" + model + ", price=" + price + ", remain=" + remain;
	}
}

class TV extends Product {
	double inch;
	String dp_type;
	
	public TV(int model_no, String model, double price, int remain, double inch, String dp_type) {
		super(model_no, model, price, remain);
		this.inch = inch;
		this.dp_type = dp_type;
	}

	public void setInfo(double inch, String dp_type) {
		this.inch = inch;
		this.dp_type = dp_type;
	}
	
	public void getInfo() {
		System.out.println(toString());
	}
	
	public String toString() {
		return "TV " + super.toString() + ", inch=" + inch + ", dp_type=" + dp_type;
	}	
}

class Refrigerator extends Product {
	double volume;

	public Refrigerator(int model_no, String model, double price, int remain, double volume) {
		super(model_no, model, price, remain);
		this.volume = volume;
	}

	public void setInfo(int volume) {
		this.volume = volume;
	}
	
	public void getInfo() {
		System.out.println(toString());
	}
	
	public String toString() {
		return "Refrigerator " + super.toString() + ", volume=" + volume;
	}
}

public class ProductTest {

	public static void main(String[] args) {
		TV t = new TV(100, "Samsung", 300, 5, 32, "QHD");
		t.setInfo(32, "UHD");
		t.getInfo();
		System.out.println("---");
		Refrigerator  r = new Refrigerator(200, "LG", 200, 8, 400);
		r.setInfo(50);
		r.getInfo();
		

	}

}
