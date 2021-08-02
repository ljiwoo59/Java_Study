// member class 사용 조건: 바깥쪽 클래스가 먼저 생성되어 있어야 함

public class MyCar { // top-level class
	int num = 1234;
	
	public class Engine { // member inner class
		public void go() {
			System.out.println(num); // 
		}
	}
	public static void main(String[] args) {
		MyCar c = new MyCar(); // top-level class 객체 생성
		Engine e = c.new Engine(); // inner class 객체 생성
		
		e.go();
		System.out.println(e.getClass().getName()); // com.inner.MyCar$Engine
	}
}
