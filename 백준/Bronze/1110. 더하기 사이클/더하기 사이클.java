import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = 0;
		int num = sc.nextInt();
		int newNum = num;
		
		while(true) {
			newNum = ((newNum%10)*10) + (((newNum%10)+(newNum/10))%10);
			count++;
			if(newNum == num) {
				break;
			}

		}
		System.out.println(count);

	}

}