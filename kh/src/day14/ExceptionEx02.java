package day14;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionEx02 {

	public static void main(String[] args) {
		// Scanner를 통해 정수를 입력 받아 입력받은 정수를 출력하는 코드를 작성하세요.
		// 정수 대신 문자열을 입력하면 예외가 발생하는데, 이예외를 처리하는 코드를 작성하세요.
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요>>");
		int num =0;
		try {
			num = sc.nextInt();
			System.out.println(num);
		} catch (InputMismatchException e) {
			e.printStackTrace();
			System.out.println("예외발생!!!!!!!!!");
		}
		sc.close();
	}

}
