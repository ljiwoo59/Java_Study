import java.util.Random;
import java.util.Scanner;

class RspGame {
	public String game(int user, int com) {
		int result = 0;
		if (user == com)
			result = 3;
		else if (user == 1 && com == 2)
			result = 2;
		else if (user == 1 && com == 3)
			result = 1;
		else if (user == 2 && com == 1)
			result = 1;
		else if (user == 2 && com == 3)
			result = 2;
		else if (user == 3 && com == 1)
			result = 2;
		else if (user == 3 && com == 2)
			result = 1;
		if (result == 1)
			return "win!!";
		else if (result == 2)
			return "loose!!";
		else
			return "draw!!";
	}
}

public class GameTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//String gababo[] = {"가위", "바위", "보"};
		Random rand = new Random();
		RspGame ga = new RspGame();
		System.out.println("Game start. Select below");
		System.out.println("1. 5판 3승");
		System.out.println("2. 3판 2승");
		System.out.println("3. 1판 1승");
		System.out.print("Input number.");
		int select = sc.nextInt();
		//System.out.println(select);
		
		int win = 0;
		int loose = 0;
		int user;
		int com;
		String result;
		if (select == 1) {
			while (win != 3 && loose != 3) {
				System.out.print("select 가위 바위 보: ");
				user = sc.nextInt();
				//System.out.println(gababo[user - 1]);
				com = rand.nextInt(3) + 1;
				result = ga.game(user, com);
				System.out.println(result);
				if (result.equals("win!!"))
					win++;
				else if (result.equals("loose!!"))
					loose++;
			}
			if (win == 3)
				System.out.println("### user win!!!");
			else
				System.out.println("### com win!!!");
		}
		if (select == 2) {
			while (win != 2 && loose != 2) {
				System.out.print("select 가위 바위 보: ");
				user = sc.nextInt();
				//System.out.println(gababo[user - 1]);
				com = rand.nextInt(3) + 1;
				result = ga.game(user, com);
				System.out.println(result);
				if (result.equals("win!!"))
					win++;
				else if (result.equals("loose!!"))
					loose++;
			}
			if (win == 2)
				System.out.println("### user win!!!");
			else
				System.out.println("### com win!!!");
		}
		if (select == 3) {
			while (win != 1 && loose != 1) {
				System.out.print("select 가위 바위 보: ");
				user = sc.nextInt();
				//System.out.println(gababo[user - 1]);
				com = rand.nextInt(3) + 1;
				result = ga.game(user, com);
				System.out.println(result);
				if (result.equals("win!!"))
					win++;
				else if (result.equals("loose!!"))
					loose++;
			}
			if (win == 1)
				System.out.println("### user win!!!");
			else
				System.out.println("### com win!!!");
		}
		sc.close();
	}

}
