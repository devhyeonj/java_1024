package day07;

import java.util.Iterator;

// 다시 해보기
public class MethodEx03 {

	public static void main(String[] args) {
		/*
		 * 주어진 정수 num가 소수인지 아닌지 판별하는 코드를 작성하세요.
		 * 단 , 메소드를 이용할것 
		 * 일을 시키는걸 메소드라 생각하자 줄게있으면 리턴타입있음
		 */
		printPrimeNumber(71);
		System.out.println(isPrimeNumber(5));
		

	}
	/*
	 * 기능 : 정수가 주어지면 소수인지 아닌지 출력하는 메소드
	 * 매개변수 : 정수 => int num
	 * 리턴타입 : 출력 => 없음 => void
	 * 메소드명 : printPrimeNumber
	 */
	public static void printPrimeNumber(int num) {
		int count = 0, i=0; 
		for (i = 1, count=0; i<= num; i++) {
			if(num % i == 0) {
				count++;
			}
		}
		if(count == 2) {
			System.out.println(num+"는 소수");
		}else {
			System.out.println(num+"는 소수가 아님");
		}
	}
	
	/*
	 * 기능 : 정수가 주어지면 소수인지 아닌지 알려주는 메소드
	 * 매개변수 : 정수 => int num
	 * 리턴타입 : 소수인지 아닌지 => boolean
	 * 메소드명 : isPrimeNumber
	 */
	
	public static boolean isPrimeNumber(int num) {
		for (int i = 2; i< num; i++) { // 1은 소수이니까 2부터 시작함
			// 1과 num를 제외한 약수		// ex) 2-4까지 약수가 있느냐
			if(num % i == 0) { // 없다
				return false;
			}
		}//그럼 소수 // 입력값 제한
		return num <= 1 ? false : true; // -면 무조건 소수이기떄문에 이렇게 설정한다
	}	
}
