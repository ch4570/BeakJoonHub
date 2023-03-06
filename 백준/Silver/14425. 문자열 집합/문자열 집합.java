import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	int count = 0;
	
	String[] arr = br.readLine().split(" ");
	int a = Integer.parseInt(arr[0]);
	int b = Integer.parseInt(arr[1]);
	String[] arr1 = new String[a];
	String[] arr2 = new String[b];
	
	for(int i=0; i<a; i++) {
		arr1[i] = br.readLine();
	}
	
	for(int i=0; i<b; i++) {
		arr2[i] = br.readLine();
	}
	
	for(int i=0; i<arr1.length; i++) {
		for(int k=0; k<arr2.length; k++) {
			if(arr1[i].equals(arr2[k])) {
				count++;
			}
		}
	}
	System.out.println(count);
	}

}