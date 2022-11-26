package chap7_method;

import java.util.Scanner;

class SignOf1 {
	// n의 부호 판정
	static int signOf(int n) {
		int sign = 0;
		
		if(n > 0 ) 
			sign = 1;
		else if (n <0)
			sign = -1;
		return sign;
	}

class SignOf2 {
	static int singOf(int n) {
		if (n>0)
			return 1;
		else if (n < 0) 
			return -1;
		return 0; 
		//return문은 여러 개 있어도 된다.
	}
}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("정수 x:");
		int x = stdIn.nextInt();
		
		int s = signOf(x);
		System.out.println("singOf(x)는 " +s + " 입니다.");
	}

}
