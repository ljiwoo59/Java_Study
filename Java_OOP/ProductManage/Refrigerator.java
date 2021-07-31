public class Refrigerator extends Product{
	
	double volume;
	
	public Refrigerator(int no, String model, double price, int remain, int volume) {
		super(no, model, price, remain);
		this.volume = volume;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public String toString() {
		return this.getClass().getSimpleName() + " : " + super.toString() + ", volume=" + volume;
	}
}
