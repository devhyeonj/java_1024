package Study;

import java.util.Scanner;
// int형 숫자에서 각각의 자릿수를 구하는 방법 // 집에가서 다시 해보기
public class ArrayEx06 {

	public static void main(String[] args) {
		/*
		 * 정수 4개 짜리 배열을 생성한 후, 4자리 숫자를 입력받아 배열에 저장하는 코드를 작성하세요.
		 * 1234
		 * 0번지 : 1
		 * 1번지 : 2
		 * 2번지 : 3
		 * 3번지 : 4
		 */
		
		Scanner sc = new Scanner(System.in);
		
		int size= 4;
		int num = 0; // 정수
		System.out.printf("%d자리 정수를 입력하세요>>",size);
		num = sc.nextInt();
		
		int num2 = num;
		int[] arr = new int[size]; // 4자리 숫자를 입력받을 배열
		
		//일의 자리부터 추출하니까 거꾸로 저장해야 하기때문에
		
		for (int i = size-1; i>=0; i--) {
			arr[i] = num % 10;
			System.out.println("+++++" + arr[i]);
			num /= 10;
			System.out.println("------" + num);
		}
		
		for (int i : arr) {
			System.out.println(i);
		}
		
		
		
		
		
	}
}
