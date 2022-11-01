package day07;

public class MethodEx02 {

	public static void main(String[] args) {
		// 7단을 출력하는 코드를 작성하세요. 단, 메소드를 이용할 것
		
		int dan = 7;
		printMultiTable1(dan);
		System.out.println("------------");
		printMultiTable2(dan, 1, 9);
		System.out.println("------------");
		for (int i = 1; 1 <=9; i++) {
			System.out.println(dan);
		}
	}
	/*
	 * 기능: 단이 주어지면 해당하는 단을 콘솔에 출력하는 메소드
	 * 매개변수 : 단 => 정수 => int num
	 * 리턴타입 :없음 => void
	 * 메소드명 : printTimesTable1
	 */
	public static void printMultiTable1(int num) {
		for (int j = 1; j <=9; j++) {
			System.out.println(num + "x" + j + " = " + num*j);
		}
	}

	
	/* 제일 이상적
	 * 기능: 단과 시작정수, 끝정수가 주어지면 해당 하는 단을 단 x 시작 숫자에서
	 * 단 x 끝숫자까지 콘솔에 출력하는 메소드
	 * 매개변수 : 단, 시작숫자, 끝 숫자 => int num, int start, int end
	 * 리턴타입 : 없음
	 * 메소드명 : printMultiTable2
	 */
	public static void printMultiTable2(int num, int start, int end) {
		for (int j = start; j <=end; j++) {
			System.out.println(num + "x" + j + " = " + num*j);
		}
	}
	
	/*
	 * 기능 : 두 정수가 주어지면 두 정수의 곱을 알려주는 메소드
	 * 매개변수 : 두 정수 => int num1, int num2
	 * 리턴타입 : 두 정수의 곱 => 정수 => int
	 * 메소드명 : multiTimesTable1
	 */
	public static int multiTimesTable1(int num1,int num2) {
		
		return num1*num2;
	}
	
	//내가 작성한 코드
	public static void gugudan(int num) {
		for (int i = num; i <=num; i++) {
			for (int j = 1; j <= 9; j++) {
				System.out.println(num+"x"+j+"="+(num*j));
			}
		}
	}
			
	}

