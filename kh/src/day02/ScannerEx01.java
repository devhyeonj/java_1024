package day02;

import java.util.Scanner;

public class ScannerEx01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
//		System.out.println("정수를 입력하세요 : ");
//		int num = sc.nextInt(); 
//		System.out.println(num);
//		System.out.println("실수를 입력하세요 : ");
//		double num2 = sc.nextDouble();
//		System.out.println(num2);
		System.out.println("정수A와 정수B를 입력하세요:");
		int numA = sc.nextInt();
		int numB = sc.nextInt();
		System.out.println(numA+" "+numB);
		// 사용 다해서 닫아주세요 의미 ( 필수는 아니지만 왠만하면 하는게 좋다
		sc.close();
		

	}

}
