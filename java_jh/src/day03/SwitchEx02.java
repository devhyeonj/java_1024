package day03;

import java.util.Scanner;

//IfEx07 Switch로 바꾼거
public class SwitchEx02 {

	public static void main(String[] args) {
		/*
		 * 두 정수와 산술 연산자를 입력 받아 산술 연산 결과를 하는 코드를 switch 문으로 작성하세요.
		 */
		
		Scanner sc = new Scanner(System.in);
		int num1,num2;
		char ch;
		System.out.print("두 정수와 산술 연산자를 입력하세요>>");
		num1 = sc.nextInt();
		ch = sc.next().charAt(0);
		num2 = sc.nextInt();
		
		switch (ch) {
		case '+':
			System.out.println(num1+num2);
			break;
		case '-':
			System.out.println(num1-num2);
			break;
		case '*':
			System.out.println(num1*num2);
			break;
		case '/':
			System.out.println((double)num1/num2);
			break;
		case '%':
			System.out.println(num1%num2);
			break;
		default:
			System.out.println("산술 연산자가 아닙니다.");
			break;
		}
	}

}
