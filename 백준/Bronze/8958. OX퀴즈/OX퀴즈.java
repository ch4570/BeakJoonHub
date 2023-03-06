import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		String quiz = "";
		int[] score = new int[a];
		int count = 0;
		for (int i = 0; i < a; i++) {
			quiz = sc.next();
			for (int j = 0, k=0; j < quiz.length(); j++,k++) {
				if (quiz.charAt(j) == 'O') {
					score[i] += 1;
					count += 1;
					if (count >= 2) {
						score[i] = score[i] + (k * 1);
					}
				}else {
					count = 0;
					k = -1;
				}
			}
		}

		for(int i=0; i<score.length; i++) {
			System.out.println(score[i]);
		}
	}

}