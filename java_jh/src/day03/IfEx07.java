package day03;

import java.util.Scanner;

public class IfEx07 {

	public static void main(String[] args) {
		/*
		 * 두 정수와 문자를 입력받아 산술연산자이면 산술연산 결과를 출력하는 코드를 작성하세요. 예시 두 정수와 문자를 입력하세요(예:1 + 2) :
		 * 1/2 1 / 2 = 0.5 ?는 산술연산자가 아닙니다.
		 * 
		 * 두 정수 num1과 num2, 문자 ch 를 입력받고 ch가 '+'와 같다면 num1 + num2를 출력하고 ch가 '-'와 같다면
		 * num1 - num2를 출력하고 ch가 '-'와 같다면 num1 * num2를 출력하고 ch가 '-'와 같다면 num1 / num2를
		 * 출력하고 ch가 '-'와 같다면 num1 % num2를 출력하고
		 * 
		 */
		System.out.print("두 정수와 문자를 입력하세요>>");
		Scanner sc = new Scanner(System.in);
		int num1,num2 =0;
		num1 = sc.nextInt();
		char ch = sc.next().charAt(0); //
		num2 = sc.nextInt();
		
		sc.close();

		// 확인
		System.out.println("" + num1 + ch + num2);

		if(ch == '+') {
			System.out.println(num1 + num2);
		}else if(ch == '-') {
			System.out.println(num1 - num2);
		}else if(ch == '*') {
			System.out.println(num1 * num2);
		}else if(ch == '/') {
			System.out.println((double)num1 / num2);
		}else if(ch == '%') {
			System.out.println(num1 % num2);
		} else {
			System.out.println("산술연산자가 아닙니다.");
		}

	}

}
