import java.util.Scanner;

public class jump{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for (int t = 0; t < testcase; t++) {
			int arrsize = sc.nextInt();
			int num = sc.nextInt();
			int[][] arr = new int[arrsize][arrsize];
			int[][] info = new int[num][3];
			for(int i = 0; i < num; i++) {
				info[i][0] = sc.nextInt(); //row
				info[i][1] = sc.nextInt(); //col
				info[i][2] = sc.nextInt(); //dir
				arr[info[i][0]][info[i][1]] = 1;
			}
			int alive = num;
			for(int i = 0; i < num; i++) {
				if (info[i][2] == 1) { // up
					if (info[i][0] - 3 < 0 
							|| info[i][0] - 5 < 0
							|| info[i][0] - 6 < 0
							|| arr[info[i][0] - 3][info[i][1]] == 1
							|| arr[info[i][0] - 5][info[i][1]] == 1
							|| arr[info[i][0] - 6][info[i][1]] == 1) {
						alive--;
					}
					else
						arr[info[i][0] - 6][info[i][1]] = 1;
					arr[info[i][0]][info[i][1]] = 0;
				}
				
				else if (info[i][2] == 2) { // down
					if (info[i][0] + 3 >= arrsize
							|| info[i][0] + 5 >= arrsize
							|| info[i][0] + 6 >= arrsize
							|| arr[info[i][0] + 3][info[i][1]] == 1
							|| arr[info[i][0] + 5][info[i][1]] == 1
							|| arr[info[i][0] + 6][info[i][1]] == 1) {
						alive--;
					}
					else
						arr[info[i][0] + 6][info[i][1]] = 1;
					arr[info[i][0]][info[i][1]] = 0;
				}
				
				else if (info[i][2] == 3) { // left
					if (info[i][1] - 3 < 0 
							|| info[i][1] - 5 < 0
							|| info[i][1] - 6 < 0
							|| arr[info[i][0]][info[i][1] - 3] == 1
							|| arr[info[i][0]][info[i][1] - 5] == 1
							|| arr[info[i][0]][info[i][1] - 6] == 1) {
						alive--;
					}
					else
						arr[info[i][0]][info[i][1] - 6] = 1;
					arr[info[i][0]][info[i][1]] = 0;
				}
				
				else if (info[i][2] == 4) { // right
					if (info[i][1] + 3 >= arrsize
							|| info[i][1] + 5 >= arrsize
							|| info[i][1] + 6 >= arrsize
							|| arr[info[i][0]][info[i][1] + 3] == 1
							|| arr[info[i][0]][info[i][1] + 5] == 1
							|| arr[info[i][0]][info[i][1] + 6] == 1) {
						alive--;
					}
					else
						arr[info[i][0]][info[i][1] + 6] = 1;
					arr[info[i][0]][info[i][1]] = 0;
				}
						
			}
			System.out.println("#" + (t+1) + " " + alive);
		}
		sc.close();
	}
}
