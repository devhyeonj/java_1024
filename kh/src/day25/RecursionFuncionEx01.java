package day25;

public class RecursionFuncionEx01 {
	/*
	 * 재귀함수 :함수의 실행문으로 자신을 다시 호출하는 함수
	 * 잘못 작성하면 스택 오버 플로우가 발생할 수 있음
	 * 
	 * 보통 알고리즘 탐색할때 씀
	 */
	public static void main(String[] args) {
		print(10);
		/* 양의 정수 n!을 구하는 코드를 작성하세요.
		 * n! = 1*2*3*n; //초기값 1
		 * n*(n-1)!
		 * n*(n-1)*(n-2)
		 * */
		System.out.println(factorial(5));
		
	}
	public static long factorial(int num) {
		if(num < 0) 
			throw new RuntimeException("음수는 팩토리얼을 구할 수 없습니다.");
		if(num == 1 || num ==0)
			return 1;
		return num * factorial(num-1);
	}
	
	public static void print(int num) {
		System.out.println(num);
		//print(num);
	}

}
