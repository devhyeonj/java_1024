package day02;

import java.util.Scanner;

public class OperatorEx08 {

	public static void main(String[] args) {
		/*
		 * 정수를 입력받아 입력받은 정수가 홀수인지 짝수인지 출력하는 코드를 작성하세요.
		 * 예시 
		 * 정수를 입력하세요 : 5
		 * 5는 홀수입니다. 
		 * 짝수는 정수를 2로 나누었을 때 나머지가 0과 같은 수 
		 */
		int num; 
		Scanner sc = new Scanner(System.in);
		// 정수를 입력 받음
		System.out.print("정수를 입력하세요 : ");
		num = sc.nextInt();
		// 짝수 ? 홀수? 판단하는 코드
		String result = num % 2 ==0 ? "짝수" : "홀수";
		// 출력
		System.out.println(num+"는 "+result+"입니다.");
		sc.close();

	}

}
