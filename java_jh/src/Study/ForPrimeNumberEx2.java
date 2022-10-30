package Study;

public class ForPrimeNumberEx2 {

	public static void main(String[] args) {
		/*
		 * 정수 num가 소수인지 아닌지 판별하는 코드를 작성하세요.
		 * 소수는 약수가 1과 자기 자신뿐인 수 => 약수의 개수가 2개인 수
		 * 1은 소수가 아니다
		 */
		int num = 71; // 정수
		int count=0;
		
		for (int i = 1; i <=num; i++) {
			if(num % i == 0) {
				count++; // 약수 갯수 세기
				System.out.println(i); //약수 출력
			}
		}
		
		// 소수 판별
		if(count == 2) {
			System.out.println("소수 입니다.");
		}else {
			System.out.println("소수가 아닙니다.");
		}

	}
}
