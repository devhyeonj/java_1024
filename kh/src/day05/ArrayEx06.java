package day05;

import java.util.Scanner;
// int형 숫자에서 각각의 자릿수를 구하는 방법 // 집에가서 다시 해보기
public class ArrayEx06 {

	public static void main(String[] args) {
		/*
		 * 정수 4개 짜리 배열을 생성한 후, 4자리 숫자를 입력받아 배열에 저장하는 코드를 작성하세요
		 */
		
		Scanner sc = new Scanner(System.in);
		
		int size = 4;
		int num = 0; // 정수
		System.out.print(size+"자리 정수를 입력하세요>>");
		num = sc.nextInt();
		
		int num2 = num;
		int[] arr = new int[size]; // 4자리 숫자를 입력받을 배열
		
		// 거꾸로 저장해야 하기때문에 -1 한거임
		for (int i = size-1; i>= 0; i--) {
		    	arr[i] = num % 10;
		    	num /=  10; 
		}
		for (int tmp : arr) {
			System.out.println(tmp);
		}
		int i = size-1;
		while (num2 != 0 ) {
			arr[i--] = num2 % 10;
	    	num2 /=  10; 
		}
		
		
	}

}
