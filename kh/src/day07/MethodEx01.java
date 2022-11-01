package day07;

public class MethodEx01 {

	public static void main(String[] args) {
		/*
		 * 클래스 
		 * - 멤버변수
		 * 	- 속성
		 * - 멤버 메소드
		 *  - 기능
		 * - 생성자
		 * 	- 초기화
		 * 
		 * 생성자 : 멤버 변수들의 값들을 초기화
		 * 기본 생성자 ( 가로안에 아무것도 안들어간 생성자)
		 * public 클래스명() {
		 * 		초기화;
		 * }
		 * 생성자
		 * public 클래스명(자료형 변수명, 자료형 변수명, ...) {
		 * 		초기화;
		 * }
		 * 복사 생성자
		 * public 클래스명(클래스명 객체명) {
		 * 		초기화;
		 * }
		 * **** 메소드 : 기능
		 * 접근제한자 예약어 리턴타입 메소드명(매개변수들) { // 영어단어로 메소드명을 만듬
		 * 		구현;
		 * }
		 * 메소드 : 음료수 자판기(콜라, 사이다, 환타)
		 * 리턴타입 : 음료수 
		 * 		- 기능이 끝나고 나서 돌려주는 정보의 자료형
		 * 매개변수 : 돈, 메뉴
		 * 		- 기능이 실행되기 위해 필요한 정보들(필수)
		 * 
		 * 메소드 호출
		 * 메소드명(매개변수/값)
		 */
		System.out.println(sum1(1,2)); 
		int num1 = 1, num2 = 2;
		sum2(num1, num2);
	}
	/*
	 * 기능 : 두 정수가 주어지면 두 정수의 합을 알려주는 메소드
	 * 매개변수 : 두 정수 => int num1, int num2;
	 * 리턴타입 : 두 정수의 합 => 정수 => int
	 * 메소드명 : sum1
	 */
	
	/*
	 * 기능 : 두 정수가 주어지면 두 정수의 합을 콘솔에 출력하는 메소드
	 * 매개변수 : 두 정수 => int num1, int num2;
	 * 리턴타입 : 없음 => void
	 * 메소드명 : sum2
	 */
	
	public static int sum1(int num1,int num2) { // sysout이 있어야 출력 가능
		return num1+num2;
	}
	
	public static void sum2(int num1,int num2) { // 없어도 됨
		System.out.println(num1+num2);
		return ; // void에서는 생략 가능하다
	}
	
	

}
