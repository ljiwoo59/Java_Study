import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayVsLinkedTest {
	private static void addTest(String testcase, List<Object> list) {
		long start = System.nanoTime();
		for (int i = 0; i < 1000000; i++) {
			list.add(new String("Hello"));
		}
		long end = System.nanoTime();
		System.out.printf("%s, 소요시간: \t%15d%n", testcase, end-start);
		
	}

	private static void addTest2(String testcase, List<Object> list) {
		long start = System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			list.add(0, new String("Hello"));
		}
		long end = System.nanoTime();
		
		System.out.printf("%s, 소요시간: \t%15d%n", testcase, end-start);
	}

	private static void accessTest(String testcase, List<Object> list) {
		long start = System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			list.get(i);
		}
		long end = System.nanoTime();
		System.out.printf("%s, 소요시간: \t%15d%n", testcase, end-start);
	}

	public static void main(String[] args) {
		ArrayList<Object> alist = new ArrayList<Object>();
		LinkedList<Object> llist = new LinkedList<Object>();

		addTest("순차적 추가: ArrayList", alist); //순차적 추가: ArrayList, 소요시간: 	       24232600
		addTest("순차적 추가: LinkedList", llist); //순차적 추가: LinkedList, 소요시간: 	       72439500

		addTest2("중간에 추가: ArrayList", alist); //중간에 추가: ArrayList, 소요시간: 	    20958121500
		addTest2("중간에 추가: LinkedList", llist); //중간에 추가: LinkedList, 소요시간: 	        2700500

		accessTest("데이터 접근: ArrayList", alist); //데이터 접근: ArrayList, 소요시간: 	        2631700
		accessTest("데이터 접근: LinkedList", llist); //데이터 접근: LinkedList, 소요시간: 	     7551592600
	}
}
