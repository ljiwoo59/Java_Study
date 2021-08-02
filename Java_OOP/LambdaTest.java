package com.lambda;
/*
람다식 : 식별자 없이 실행 가능한 함수
함수형 언어에서 나온 개념 - 자바 스크립트

(parameter,,,) -> {실행문}
*/

@FunctionalInterface // 추상 메소드가 1개인 인터페이스
interface Something{
	int some(int a, int b);
}

interface MyMax {
	int getMax(int a, int b);
}

class Person {
	public void work(Something s) {
		int result = s.some(3, 5);
		System.out.println("결과 : " + result);
	}
	
	public void test(MyMax m, int a, int b) {
		int result = m.getMax(a, b);
		System.out.println("결과 : " + result);
	}
}

public class LambdaTest {

	public static void main(String[] args) {
		Person kim = new Person();
		
		// 람다 사용 X
		kim.work(new Something() { // anonymous class 활용
			@Override
			public int some(int a, int b) {
				return a + b;
			}	
		});
		
		// 람다 사용 : 인터페이스 이름, 메소드 이름 필요없이 추상 메소드에만 집중
		kim.work((a, b)->{
			return a+b;
		});
		
		kim.test((a, b)->{
			return Math.max(a, b);
		}, 10, 5);
		
		// MyMax 인터페이스 안의 추상메소드를 구현한 무명의 객체가 생성되어 mm 이 참조한다
		MyMax mm = (a, b)->(a > b) ? a : b;

	}

}
