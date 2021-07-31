public class Product {
	int no;
	String model;
	double price;
	int remain;
	
	public Product(int no, String model, double price, int remain) {
		this.no = no;
		this.model = model;
		this.price = price;
		this.remain = remain;
	}
	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getRemain() {
		return remain;
	}

	public void setRemain(int remain) {
		this.remain = remain;
	}

	public String toString() {
		return "model_no=" + no + ", model=" + model + ", price=" + price + ", remain=" + remain;
	}
}
