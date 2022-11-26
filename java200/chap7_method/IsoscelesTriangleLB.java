package chap7_method;

import java.util.Scanner;

public class IsoscelesTriangleLB {
	// 문자C를 N개 연속 표시
	static void putChars(char c,int n) {
		while (n-- > 0) 
		System.out.print(c);	
		
	}
	//문자 '*'를 n개 연속 표시
	static void putStars(int n) {
		putChars('*', n);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("왼쪽 아래가 직각인 이등변 삼각형을 표시합니다.");
		System.out.print("단수는:");
		int n = sc.nextInt();
		for(int i=1;i<=n;i++) {
			putStars(i);
			System.out.println();
		}
	}

}
