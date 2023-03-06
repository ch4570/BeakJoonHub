import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] arr = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
				't', 'u', 'v', 'w', 'x', 'y', 'z' };
		boolean[] boolArr = new boolean[26];
		String str = sc.next();
		String[] result = new String[26];
		for (int i = 0; i < result.length; i++) {
			result[i] = "-1 ";
			boolArr[i] = false;
		}
		for (int i = 0; i < str.length(); i++) {
			for (int j = 0; j < arr.length; j++) {	
				if(str.charAt(i) == arr[j] && boolArr[j] == false) {
					result[j] = (i + "") + " ";
					boolArr[j] = true;
				}
					

			}
		}

		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i]);
		}
	}

}