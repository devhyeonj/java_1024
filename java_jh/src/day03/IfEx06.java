package day03;

import java.util.Scanner;

public class IfEx06 {

	public static void main(String[] args) {
		
		/*
		 * Scanner 를 이용하여 문자를 하나 입력받아
		 *  입력받은 문자가 + - * / % 중 하나이면 산술연산자라고 출력
		 * 아니면 산술연산자가 아닙니다라고 출력하는 코드를 작성
 		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("문자 입력>>>");
		char ch = sc.next().charAt(0);
		
		if(ch == '+' || ch == '-' || ch == '/' || ch == '%') {
			System.out.println("산술연산자");
		}else {
			System.out.println("산술연산자가 아닙니다.");
		}
	}

}
