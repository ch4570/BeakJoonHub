import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf;	// 입력
		BufferedWriter bw;	// 출력
		int T;		// 테스트 케이스 수
		int A, B;	// 두 정수
		int i;		// for문 변수
		
		// 입력 선언
		bf = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(bf.readLine());
		// 출력 선언
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for(i=1; i<=T; i++) {
			
			// 문자열을 입력받고 공백기준으로 잘라서 문자열 배열에 넣기
			String[] temp = bf.readLine().split(" ");
			A = Integer.parseInt(temp[0]);
			B = Integer.parseInt(temp[1]);
			bw.write(A + B + "\n");	// write()함수는 자동개행이 없어서 처리해주어야 함
			}
		bw.flush();	// 남아있는 데이터를 모두 출력
		bw.close();	// 스트림을 닫음
	}
}