// anonymous class

abstract class Movie {
	abstract void play();
}

interface Game {
	void play();
}

/**
class MyMovie extends Movie {
	@Override
	void play() {
		System.out.println("harry potter");
	}
}
**/

public class MyTablet {
	public void start(Movie m) {
		m.play();
	}
	public void start(Game m) {
		m.play();
	}
	
	public static void main(String[] args) {
		MyTablet tab = new MyTablet();
//		tab.start(new MyMovie()); // 원래는 추상 클래스를 상속받는 자식 클래스를 따로 정의하고 객체를 생성해야 한다
		tab.start(new Movie() { // anonymous class
			@Override
			void play() {
				System.out.println("harry potter");
			}
		});
		tab.start(new Game() {
			
			@Override
			public void play() {
				System.out.println("rayman");
			}
		});
	}
}
