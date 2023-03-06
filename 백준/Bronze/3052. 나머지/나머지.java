import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr1 = new int[10];
		int[] arr2 = new int[10];
		boolean[] arr3 = new boolean[10];
		int count = 0;
		for(int i=0; i<arr1.length; i++) {
			arr1[i] = sc.nextInt();
		}
		
		for(int i=0; i<arr2.length; i++) {
			arr2[i] = (arr1[i] % 42);
		}
		
		for(int i=0; i<arr2.length; i++) {
			if(i==9) {
				for(int k=0; k<arr2.length-1; k++) {
					if(arr2[i] == arr2[k]) {
						arr3[i] = true;
					}else {
						arr3[i] = false;
					}
				}
			}
			for(int j=(i+1); j<arr2.length; j++) {
				if(arr2[i] == arr2[j]) {
					arr3[i] = true;
					break;
				}else {
					arr3[i] = false;
				}
				
				
			}
			
		}
		
		for(int i=0; i<arr3.length; i++) {
			if(arr3[i] == false) {
				count++;
			}
		}
		if(count == 0) {
			count = 1;
		}
		System.out.println(count);
	}

}