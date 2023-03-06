import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		시						분						요리 소요시간(분)
		int A = sc.nextInt(); int B = sc.nextInt(); 
		int C = sc.nextInt();
		int divide = (B+C)/60;
		
		//오후 11시 전이면서 분의 합계가 60미만일때
		if(A<23 && (B+C)<60) {
			System.out.println(A + " " + (B+C));
		//오후 11시면서 분의 합계가 60 이상일때
		}else if(A==23 && (B+C)>=60) {
			A = 0;
			System.out.println((A+(divide-1)) + " " + ((B+C)-(divide*60)));
		//오후 11시 전이면서 분의 합계가 60이상이고, 합계 시간이 24시를 넘어가지 않을때
		}else if(A<23 && (B+C)>=60 && (divide+A)<24){
				System.out.println((A+(divide)) + " " + ((B+C)-(divide*60)));
		//오후 11시 전이면서 분의 합계가 60이상이고, 합계 시간이 24시를 넘어갈때
		}else{			
				System.out.println(((divide+A)-24) + " " + ((B+C)-(divide*60)) );
			
		}

	}

}