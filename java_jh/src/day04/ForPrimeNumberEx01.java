package day04;

public class ForPrimeNumberEx01 {

	public static void main(String[] args) {
		/*
		 * 정수 num가 소수인지 아닌지 판별하는 코드를 작성하세요.
		 * 소수는 약수가 1과 자기 자신뿐인 수 => 약수의 개수가 2개인 수
		 * 1은 소수가 아니다
		 * 반복 횟수: i는 1부터 num까지 1씩 증가
		 * 규칙성 : i가 num의 약수이면 count(약수의 개수)를 1증가
		 * 반복문 종료 후 : count가 2이면 소수라고 출력하고 2보다 크면 소수가 아니라고 출력
		 */
		int num = 71 , count =0;
		
		for (int i = 1; i <=num; i++) {
			if(num%i ==0 ) {
				count++;
				System.out.print(i+" "); // 약수출력
			}
		}
		
		System.out.println();
		
		if(count == 2) {
			System.out.println(num + " 소수 입니다.");
		}else {
			System.out.println(num +" 소수가 아닙니다.");
		}

	}

}
