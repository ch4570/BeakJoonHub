

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int avg = 0;     // 평균
		int mode = 0;   // 최빈값
		int range = 0;  // 범위
		int median = 0; // 중앙값
		// 테스트 케이스의 수를 입력받음
		int num = Integer.parseInt(br.readLine());
		
		
		// 숫자를 입력받을 List 선언
		List<Integer> list = new ArrayList<>();
		
		// 최빈 값을 계산할 HashMap 선언
		Map<Integer, Integer> map = new HashMap<>();
		
		// 합계를 더할 sum 변수 선언
		int sum = 0;
		
		// 테스트 케이스의 수만큼 숫자를 입력받아 list에 저장
		for(int i=0; i<num; i++) {
			list.add(Integer.parseInt(br.readLine()));
			sum += list.get(i);
		}
		
		// sum이 음수일 경우와 양수일 경우에 따라 평균 계산
		if(sum<0) {
			//음수일 경우, 문제에서 1.8을 반올림하면 2가되게 하라고 제시하였으므로,
			//sum이 음수일 경우 절댓값을 반환받아 계산한후, 다시 -1을 곱하여 음수로 반환
			avg = (int)Math.round((double)Math.abs(sum)/num)*-1;
		}else {
			avg = (int)(Math.round((double)sum/num));
		}
		
		// 중앙 값을 구하기 위해 오름차순으로 정렬
		Collections.sort(list);
		
		// list의 size를 반으로 나눠, 중간 값을 구함
		median = list.get(num/2);
		
		// list에서 최대값 - 최소값을 하여 범위를 구함,
		// 단, list의 크기가 1일 경우 예외가 발생할 수 있으므로, 조건식으로 걸러줌
		if(list.size() > 1) {
			range = (list.get(num-1) - list.get(0));
		}else {
			range = (list.get(0) - list.get(0));
		}
		
		
		//hashmap에 중복을 제거하여 최빈 값 저장(값, 최빈 값(빈도수))
		for(int numbers : list) {
			map.put(numbers, map.getOrDefault(numbers, 0)+1);
		}
		
		List<Integer> list2 = new ArrayList<>();
		// value만 list로 뽑아옴
		for(int numbers : map.values()) {
			list2.add(numbers);
		}

		//가장 많은 빈도를 가진 값만 뽑아옴
		int max = Collections.max(list2);
		
		
		// 결과 저장
		List<Integer> list3 = new ArrayList<>();
		for(int number : map.keySet()) {
			if(map.get(number) == max) {
				list3.add(number);
			}
		}
		
		// 정렬
		Collections.sort(list3);
		
		if(list3.size() > 1) {
			mode = list3.get(1);
		}else {
			mode = list3.get(0);
		}
		
		System.out.println(avg);
		System.out.println(median);
		System.out.println(mode);
		System.out.println(range);
	}

}
