import java.io.*;
import java.util.*;

public class  Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine()); 

		String number = String.valueOf(num);

		char[] numArr = new char[number.length()];
		
		for(int i=0; i<numArr.length; i++) {
			numArr[i] = number.charAt(i);
		}
		
		List<Integer> list = new ArrayList<>();
		for(int i=0; i<numArr.length; i++) {
			list.add(Character.getNumericValue(numArr[i]));
		}

		
		Collections.sort(list,Collections.reverseOrder());
		
		for(int numb : list) {
			System.out.print(numb);
		}

	}

}