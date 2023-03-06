import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] words = sc.nextLine().split(" ");
		int count = 0;
		
		for(int i=0; i<words.length; i++) {
			if(words[i].equals("")) {
				
			}else {
				count++;
			}
		}
		
		System.out.println(count);
	}

}