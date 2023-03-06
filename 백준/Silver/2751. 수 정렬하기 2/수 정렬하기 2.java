import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder st = new StringBuilder();
		
		
		List<Integer> list = new ArrayList<Integer>();

		int num = Integer.parseInt(br.readLine());
		
		
		for(int i=0; i<num; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}

		Collections.sort(list);
		
		for(int i=0; i<list.size(); i++) {
			st.append(list.get(i)+"\n");
		}
		
		System.out.println(st);

	}

}