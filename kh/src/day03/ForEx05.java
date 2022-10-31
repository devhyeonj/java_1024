package day03;

public class ForEx05 {

	public static void main(String[] args) {
		/*
		 * 1부터 10까지의 합을 구하는 코드를 작성하세요
		 * 반복횟수 : i는 1부터 10까지 1씩 증가
		 * 규칙성 : sum = sum + i
		 * 반복문 종류 후 : sum을 출력
		 */
		
		int sum =0; //합계
		
		for (int i = 1; i <= 10; i++) {
			sum += i; // sum = sum + i;
		}
		System.out.println(sum);

	}

}
