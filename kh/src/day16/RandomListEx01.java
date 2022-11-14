package day16;

import java.util.ArrayList;
import java.util.HashSet;
// set은 중복을 제거하는거 외에는 list를 사용함 // 응용예제 기억하기
public class RandomListEx01 {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int maxCount = 3, min = 1,max =9; // set 1-9로 하면 정렬이 된다.
		HashSet<Integer> set = new HashSet<Integer>();
		
		// set 값이 3개 될때까지 넣음
		while(set.size() < maxCount) {
			int r = (int)(Math.random()*(max-min+1)+min);
			set.add(r);
		}
		list.addAll(set);
		System.out.println(list);

	}

}
