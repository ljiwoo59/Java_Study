public class TV extends Product{
	
	double inch;
	String dp_type;
	
	public TV(int no, String model, double price, int remain, double inch, String dp_type) {
		super(no, model, price, remain);
		this.inch = inch;
		this.dp_type = dp_type;
	}

	public double getInch() {
		return inch;
	}

	public void setInch(double inch) {
		this.inch = inch;
	}

	public String getDp_type() {
		return dp_type;
	}

	public void setDp_type(String dp_type) {
		this.dp_type = dp_type;
	}
	
	public String toString() {
		return this.getClass().getSimpleName() + " : " + super.toString() + ", inch=" + inch + ", dp_type=" + dp_type;
	}
}
