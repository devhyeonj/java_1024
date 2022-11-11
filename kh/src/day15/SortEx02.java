package day15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortEx02 {
	
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("apple");
		list.add("orange");
		list.add("boy");
		list.add("year");
		list.add("a");
		// comparator 인터페이스를 구현한 구현 클래스가 필요 
		Collections.sort(list, new Comparator<String>() {
//객체 정렬하고 싶으면 omparator 인터페이스를 구현한 구현 객체가 필요하다
			@Override
			public int compare(String o1, String o2) {
				return -o1.compareTo(o2);
			}
		});
		System.out.println(list);
	}

}
