package day19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class LambdaEx01 {

	public static void main(String[] args) {
		/* 람다식을 쓰는 이유?
		 * - 코드가 간결해짐 ( 아래 예제 참고)
		 * - 콜렉션에서 필터링이 쉬어짐
		 * 람다식은 언제 사용?
		 * - 함수적 인터페이스의 객체가 필요한 경우
		 * 함수적 인터페이스란?
		 * - 인터페이스의 추상메소드가 1개인 인터페이스
		 */
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,10,-1,100,22));
		
		System.out.println(list);
		Collections.sort(list, (a,b)-> b-a);
		System.out.println(list);
	}

}
