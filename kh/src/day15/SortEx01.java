package day15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortEx01 {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(10);
		list.add(3);
		list.add(20);
		list.add(-1);
		// comparator 인터페이스를 구현한 구현 클래스가 필요 
		Collections.sort(list, new Comparator<Integer>() {
//객체 정렬하고 싶으면 omparator 인터페이스를 구현한 구현 객체가 필요하다
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
												
		});
		System.out.println(list);
		
		
	}
}

